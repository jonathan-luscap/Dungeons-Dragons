package com.dnd.character;

import com.dnd.connection.DatabaseAccessPersona;
import com.dnd.connection.DatabaseConnection;
import com.dnd.equipment.defensive.*;
import com.dnd.equipment.offensive.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonaDaoImplementation implements DatabaseAccessPersona {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int  add(Persona persona, int gameId) throws SQLException {
        PreparedStatement psHero = null;
        //insert the character
        psHero = con.prepareStatement("INSERT INTO Hero(name, life, type, game_id) VALUES(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        psHero.setString(1, persona.getName());
        psHero.setInt(2, persona.getLife());
        psHero.setInt(3, persona.getType().getId());
        psHero.setInt(4, gameId);
        psHero.executeUpdate();
        int personaId = 0;
        try (ResultSet rs = psHero.getGeneratedKeys()){
            if (rs.next()){
                personaId = rs.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve character by ID.");
            }
        }
        if (persona instanceof Player){
            Player player = (Player) persona;
            player.setId(personaId);
        }
        //insert offensiveEquipment
        OffensiveEquipmentDaoImplementation offensiveEquipment = new OffensiveEquipmentDaoImplementation();
        offensiveEquipment.add(persona, gameId);
        //insert defensiveEquipment
        DefensiveEquipmentDaoImplementation defensiveEquipment = new DefensiveEquipmentDaoImplementation();
        defensiveEquipment.add(persona, gameId);

        return personaId;
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement psHero = null;
        PreparedStatement psOffensiveEquipment = null;
        PreparedStatement psDefensiveEquipment = null;
        //delete hero
        psHero = con.prepareStatement("DELETE FROM Hero WHERE id = ?");
        psHero.setInt(1, id);
        psHero.executeUpdate();
        //delete OffensiveEquipment
        psOffensiveEquipment = con.prepareStatement("DELETE FROM OffensiveEquipment WHERE persona_id = ?");
        psOffensiveEquipment.setInt(1, id);
        psOffensiveEquipment.executeUpdate();
        // delete DefensiveEquiment
        psDefensiveEquipment = con.prepareStatement("DELETE FROM DefensiveEquipment WHERE persona_id = ?");
        psDefensiveEquipment.setInt(1, id);
        psDefensiveEquipment.executeUpdate();
    }

    @Override
    public Persona getPersona(int id) throws SQLException {
        PreparedStatement psHero = null;
        PreparedStatement psHeroType = null;
        PreparedStatement psOffensiveEquipment = null;
        PreparedStatement psDefensiveEquipment = null;
        psHero = con.prepareStatement("SELECT * FROM Hero WHERE id = ?");
        psHero.setInt(1, id);
        ResultSet rsHero = psHero.executeQuery();
        psOffensiveEquipment = con.prepareStatement("SELECT * FROM OffensiveEquipment WHERE persona_id = ?");
        psOffensiveEquipment.setInt(1, id);
        ResultSet rsOffensiveEquipment = psOffensiveEquipment.executeQuery();
        psDefensiveEquipment = con.prepareStatement("SELECT * FROM DefensiveEquipment WHERE persona_id = ?");
        psDefensiveEquipment.setInt(1, id);
        ResultSet rsDefensiveEquipment = psDefensiveEquipment.executeQuery();
        //get the character
        Persona persona = null;
        while (rsHero.next()){
            Persona.PersonaType personaType = Persona.PersonaType.values()[rsHero.getInt("type")];
            switch (personaType){
                case WARRIOR -> persona = new Warrior();
                case WIZARD -> persona = new Wizard();
            }
            persona.setType(personaType);
            persona.setName(rsHero.getString("name"));
            persona.setLife(rsHero.getInt("life"));
        }
        //get offensive equipment
        OffensiveEquipment offensiveEquipment = null;
        while (rsOffensiveEquipment.next()){
            int typeId = rsOffensiveEquipment.getInt("type");
            int damage = rsOffensiveEquipment.getInt("damage");
            OffensiveEquipment.OffensiveEquipmentType offensiveEquipmentType = OffensiveEquipment.OffensiveEquipmentType.values()[typeId];
            switch (offensiveEquipmentType){
                case SWORD -> offensiveEquipment = new Sword(damage);
                case MACE -> offensiveEquipment = new Mace(damage);
                case FLASH -> offensiveEquipment = new Flash(damage);
                case FIREBALL -> offensiveEquipment = new Fireball(damage);
            }
        }
        persona.setOffensiveEquipment(offensiveEquipment);
        //get defensive equipment
        DefensiveEquipment defensiveEquipment = null;
        while (rsDefensiveEquipment.next()){
            int typeId = rsDefensiveEquipment.getInt("type");
            int defense = rsDefensiveEquipment.getInt("damage");
            DefensiveEquipment.DefensiveEquipmentType defensiveEquipmentType = DefensiveEquipment.DefensiveEquipmentType.values()[typeId];
            switch (defensiveEquipmentType){
                case WOODSHIELD -> defensiveEquipment = new WoodShield(defense);
                case IRONSHIELD -> defensiveEquipment = new IronShield(defense);
                case SMOKEBOMB -> defensiveEquipment = new SmokeBomb(defense);
                case TELEPORTATION -> defensiveEquipment = new Teleportation(defense);
            }
        }
        persona.setDefensiveEquipment(defensiveEquipment);

        return persona;
    }

    @Override
    public List<Persona> getPersonas() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Persona persona) throws SQLException {

    }
}

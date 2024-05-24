package com.dnd.square;

import com.dnd.character.Persona;
import com.dnd.character.PersonaDaoImplementation;
import com.dnd.connection.DatabaseAccessSquare;
import com.dnd.connection.DatabaseConnection;
import com.dnd.equipment.Equipment;
import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.defensive.DefensiveEquipmentDaoImplementation;
import com.dnd.equipment.offensive.OffensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipmentDaoImplementation;
import com.dnd.square.enemy.Enemy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OpenableDaoImplementation implements DatabaseAccessSquare {

    static Connection con = DatabaseConnection.getConnection();
    @Override
    public void add(Openable openable, int gameId) throws SQLException {
        try (PreparedStatement psSquare = con.prepareStatement("INSERT INTO Square(game_id, position, content, persona_id, offensiveEquipment_id, defensiveEquipment_id, power) VALUES (?, ?, ?, ?, ?, ?, ?)");) {
            psSquare.setInt(1, gameId);
            if (openable instanceof Square){
                Square square = (Square) openable;
                psSquare.setInt(2,square.getPosition());
            } else if (openable instanceof Enemy){
                Enemy enemy = (Enemy) openable;
                psSquare.setInt(2, enemy.getPosition());
            } else if (openable instanceof Equipment) {
                Equipment equipment = (Equipment) openable;
                psSquare.setInt(2, equipment.getPosition());
            } else {
                psSquare.setString(2, null);
            }
            psSquare.setString(3, openable.getClass().getName());
            if (openable instanceof Persona){
                PersonaDaoImplementation personaDao = new PersonaDaoImplementation();
                Persona persona = (Persona) openable;
                int personaId = personaDao.add(persona, gameId);
                psSquare.setInt(4, personaId);
            } else {
                psSquare.setString(4, null);
            }
            if (openable instanceof OffensiveEquipment) {
                OffensiveEquipmentDaoImplementation offEquipDao = new OffensiveEquipmentDaoImplementation();
                OffensiveEquipment offEquip = (OffensiveEquipment) openable;
                int offEquipId = offEquipDao.add(offEquip, gameId);
                psSquare.setInt(5, offEquipId);
            } else {
                psSquare.setString(5, null);
            }
            if (openable instanceof DefensiveEquipment) {
                DefensiveEquipmentDaoImplementation defEquipDao = new DefensiveEquipmentDaoImplementation();
                DefensiveEquipment defEquip = (DefensiveEquipment) openable;
                int defEquipId = defEquipDao.add(defEquip, gameId);
                psSquare.setInt(6, defEquipId);
            } else {
                psSquare.setString(6, null);
            }
            if (openable instanceof Potion) {
                Potion potion = (Potion) openable;
                psSquare.setInt(7, potion.getLife());
            } else if (openable instanceof Surprise) {
                Surprise surprise = (Surprise) openable;
                psSquare.setInt(7, surprise.getSquarePower());
            } else {
                psSquare.setString(7, null);
            }
            psSquare.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Openable getSquare(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Openable> getSquares() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Openable openable) throws SQLException {

    }
}

package com.dnd.equipment.defensive;

import com.dnd.character.Persona;
import com.dnd.connection.DatabaseAccessEquipment;
import com.dnd.connection.DatabaseConnection;
import com.dnd.equipment.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefensiveEquipmentDaoImplementation implements DatabaseAccessEquipment {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Persona persona, int gameId) throws SQLException {
        int defEquipId = -1;
        try (PreparedStatement psDefensiveEquipment = con.prepareStatement("INSERT INTO DefensiveEquipment(type, heroType, defense, persona_id, created_at) VALUES(?,?,?,NOW())");){
            psDefensiveEquipment.setString(1, persona.getDefensiveEquipment().getType().getDefensiveEquipmentTypeName());
            psDefensiveEquipment.setInt(2, persona.getType().getId());
            psDefensiveEquipment.setInt(3,persona.getDefensiveEquipment().getDefense());
            psDefensiveEquipment.setInt(4,persona.getId());
            psDefensiveEquipment.executeUpdate();
        }
        try (PreparedStatement psDefEquipId = con.prepareStatement("SELECT id FROM DefensiveEquipment ORDER BY created_at DESC LIMIT 1");){
            ResultSet rsOffEquipId = psDefEquipId.executeQuery();
            while (rsOffEquipId.next()) {
                defEquipId = rsOffEquipId.getInt(1);
            }
        }
        return defEquipId;

    }

    public int add(DefensiveEquipment defensiveEquipment, int gameId) throws SQLException {
        int defEquipId = -1;
        try (PreparedStatement psDefensiveEquipment = con.prepareStatement("INSERT INTO DefensiveEquipment(type, heroType, defense, game_id, created_at) VALUES(?,?,?,NOW())");){
            psDefensiveEquipment.setString(1, defensiveEquipment.getType().getDefensiveEquipmentTypeName());
            psDefensiveEquipment.setInt(2, defensiveEquipment.getPlayerType().getId());
            psDefensiveEquipment.setInt(3,defensiveEquipment.getDefense());
            psDefensiveEquipment.setInt(4,gameId);
            psDefensiveEquipment.executeUpdate();
        }
        try (PreparedStatement psOffEquipId = con.prepareStatement("SELECT id FROM DefensiveEquipment ORDER BY created_at DESC LIMIT 1");){
            ResultSet rsOffEquipId = psOffEquipId.executeQuery();
            while (rsOffEquipId.next()) {
                defEquipId = rsOffEquipId.getInt(1);
            }
        }
        return defEquipId;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Equipment getEquipment(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Equipment> getEquipments() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Equipment equipment) throws SQLException {

    }
}

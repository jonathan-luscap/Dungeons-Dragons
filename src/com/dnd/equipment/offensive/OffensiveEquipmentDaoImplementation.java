package com.dnd.equipment.offensive;

import com.dnd.character.Persona;
import com.dnd.connection.DatabaseAccessEquipment;
import com.dnd.connection.DatabaseConnection;
import com.dnd.equipment.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OffensiveEquipmentDaoImplementation implements DatabaseAccessEquipment {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Persona persona, int gameId) throws SQLException {
        int offEquipId = -1;
        try (PreparedStatement psOffensiveEquipment = con.prepareStatement("INSERT INTO OffensiveEquipment(type, heroType, damage, persona_id, created_at) VALUES(?,?,?,NOW())");) {
            psOffensiveEquipment.setString(1, persona.getOffensiveEquipment().getType().getOffensiveEquipmentTypeName());
            psOffensiveEquipment.setInt(2, persona.getType().getId());
            psOffensiveEquipment.setInt(3,persona.getOffensiveEquipment().getDamage());
            psOffensiveEquipment.setInt(4,persona.getId());
            psOffensiveEquipment.executeUpdate();
        }
        try (PreparedStatement psDefEquipId = con.prepareStatement("SELECT id FROM OffensiveEquipment ORDER BY created_at DESC LIMIT 1");) {
            ResultSet rsDefEquipId = psDefEquipId.executeQuery();
            while (rsDefEquipId.next()) {
                offEquipId = rsDefEquipId.getInt(1);
            }
        }
        return offEquipId;
    }

    public int add(OffensiveEquipment offensiveEquipment, int gameId) throws SQLException {
        int offEquipId = -1;
        try (PreparedStatement psOffensiveEquipment = con.prepareStatement("INSERT INTO OffensiveEquipment(type, heroType, damage, game_id, created_at) VALUES(?,?,?,NOW())");) {
            psOffensiveEquipment.setString(1, offensiveEquipment.getType().getOffensiveEquipmentTypeName());
            psOffensiveEquipment.setInt(2, offensiveEquipment.getPlayerType().getId());
            psOffensiveEquipment.setInt(3,offensiveEquipment.getDamage());
            psOffensiveEquipment.setInt(4,gameId);
            psOffensiveEquipment.executeUpdate();
        }
        try (PreparedStatement psDefEquipId = con.prepareStatement("SELECT id FROM OffensiveEquipment ORDER BY created_at DESC LIMIT 1");) {
            ResultSet rsDefEquipId = psDefEquipId.executeQuery();
            while (rsDefEquipId.next()) {
                offEquipId = rsDefEquipId.getInt(1);
            }
        }
        return offEquipId;
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

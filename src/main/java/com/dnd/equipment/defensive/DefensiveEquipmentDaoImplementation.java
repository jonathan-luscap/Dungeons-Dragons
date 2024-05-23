package com.dnd.equipment.defensive;

import com.dnd.character.Persona;
import com.dnd.connection.DatabaseAccessEquipment;
import com.dnd.connection.DatabaseConnection;
import com.dnd.equipment.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DefensiveEquipmentDaoImplementation implements DatabaseAccessEquipment {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public void add(Persona persona, int gameId) throws SQLException {
        PreparedStatement psDefensiveEquipment = con.prepareStatement("INSERT INTO DefensiveEquipment(type, defense, persona_id) VALUES(?,?,?)");
        psDefensiveEquipment.setString(1, persona.getDefensiveEquipment().getType().getDefensiveEquipmentTypeName());
        psDefensiveEquipment.setInt(2,persona.getDefensiveEquipment().getDefense());
        psDefensiveEquipment.setInt(3,persona.getId());
        psDefensiveEquipment.executeUpdate();
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

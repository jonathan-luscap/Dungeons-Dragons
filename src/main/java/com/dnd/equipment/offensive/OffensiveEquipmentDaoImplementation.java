package com.dnd.equipment.offensive;

import com.dnd.character.Persona;
import com.dnd.connection.DatabaseAccessEquipment;
import com.dnd.connection.DatabaseConnection;
import com.dnd.equipment.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OffensiveEquipmentDaoImplementation implements DatabaseAccessEquipment {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public void add(Persona persona, int gameId) throws SQLException {
        PreparedStatement psOffensiveEquipment = con.prepareStatement("INSERT INTO OffensiveEquipment(type, damage, persona_id) VALUES(?,?,?)");
        psOffensiveEquipment.setString(1, persona.getOffensiveEquipment().getType().getOffensiveEquipmentTypeName());
        psOffensiveEquipment.setInt(2,persona.getOffensiveEquipment().getDamage());
        psOffensiveEquipment.setInt(3,persona.getId());
        psOffensiveEquipment.executeUpdate();
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

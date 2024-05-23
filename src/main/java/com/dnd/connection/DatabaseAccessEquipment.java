package com.dnd.connection;

import com.dnd.character.Persona;
import com.dnd.equipment.Equipment;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccessEquipment {

    void add(Persona persona, int gameId)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    Equipment getEquipment(int id)
            throws SQLException;
    List<Equipment> getEquipments()
            throws SQLException;
    void update(Equipment equipment)
            throws SQLException;
}

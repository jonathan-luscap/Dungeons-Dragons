package com.dnd.character;

import com.dnd.connection.DatabaseAccessPersona;
import com.dnd.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonaDaoImplementation implements DatabaseAccessPersona {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Persona persona) throws SQLException {
        String query = "INSERT INTO Hero(name, life, type) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, persona.getName());
        ps.setInt(2, persona.getLife());
        ps.setInt(3, persona.getType().getInd());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM Hero WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Persona getPersona(int id) throws SQLException {
        String query = "SELECT * FROM Hero WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        return null;
    }

    @Override
    public List<Persona> getPersonas() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Persona persona) throws SQLException {

    }
}

package com.dnd.connection;

import com.dnd.character.Persona;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccessPersona {

    public int add(Persona persona)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public Persona getPersona(int id)
        throws SQLException;
    public List<Persona> getPersonas()
        throws SQLException;
    public void update(Persona persona)
        throws SQLException;
}

package com.dnd.connection;

import com.dnd.character.Persona;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccessPersona {

    int add(Persona persona, int gameId)
        throws SQLException;
    void delete(int id)
        throws SQLException;
    Persona getPersona(int id)
        throws SQLException;
    List<Persona> getPersonas()
        throws SQLException;
    void update(Persona persona)
        throws SQLException;
}

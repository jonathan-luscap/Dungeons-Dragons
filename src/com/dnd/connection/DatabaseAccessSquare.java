package com.dnd.connection;

import com.dnd.square.Openable;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccessSquare {

    void add(Openable openable, int gameId)
            throws SQLException;
    void delete(int id)
            throws SQLException;
    Openable getSquare(int id)
            throws SQLException;
    List<Openable> getSquares()
            throws SQLException;
    void update(Openable openable)
            throws SQLException;
}

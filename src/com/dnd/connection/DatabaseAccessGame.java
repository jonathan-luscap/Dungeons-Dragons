package com.dnd.connection;

import com.dnd.game.Game;

import javax.management.openmbean.ArrayType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DatabaseAccessGame {

    void add()
            throws SQLException;
    void delete(int id)
            throws SQLException;
    Game getGame(int id)
            throws SQLException;
    List<Game> getGames()
            throws SQLException;
    void update(Game game)
            throws SQLException;
}

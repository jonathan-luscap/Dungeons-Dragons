package com.dnd.game;

import com.dnd.character.Persona;
import com.dnd.character.PersonaDaoImplementation;
import com.dnd.character.Player;
import com.dnd.connection.DatabaseAccessGame;
import com.dnd.connection.DatabaseConnection;
import com.dnd.equipment.defensive.DefensiveEquipment;
import com.dnd.equipment.defensive.DefensiveEquipmentDaoImplementation;
import com.dnd.equipment.offensive.OffensiveEquipment;
import com.dnd.equipment.offensive.OffensiveEquipmentDaoImplementation;
import com.dnd.square.Openable;
import com.dnd.square.OpenableDaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImplementation implements DatabaseAccessGame {

    static Connection con = DatabaseConnection.getConnection();
    @Override
    public void add() throws SQLException {
        //set game id
        int gameId = -1;
        try (PreparedStatement psGame = con.prepareStatement("INSERT INTO Game(created_at) VALUES(NOW())");) {
            psGame.executeUpdate();
            PreparedStatement psId = con.prepareStatement("SELECT id FROM Game ORDER BY created_at DESC LIMIT 1");
            ResultSet rs = psId.executeQuery();
            while (rs.next()) {
                gameId = rs.getInt(1);
            }
        }
        Game.setGameId(gameId);
        //save players
        ArrayList<Player> players = Game.getPlayers();
        PersonaDaoImplementation personaDao = new PersonaDaoImplementation();
        for (Player player : players) {
            int playerId = personaDao.add(player, gameId);
            player.setId(playerId);
        }
        //save gameboard
        ArrayList<Openable> gameboard = Game.getGameBoard();
        OpenableDaoImplementation opDaoImplementation = new OpenableDaoImplementation();
        for (Openable openable : gameboard) {
            opDaoImplementation.add(openable, gameId);
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Game getGame(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        try(PreparedStatement psGames = con.prepareStatement("SELECT * FROM Game");
            ResultSet rsGames = psGames.executeQuery()){
            while (rsGames.next()) {
                TempGame tempGame = new TempGame();
                tempGame.setTempGameId(rsGames.getInt("id"));
                tempGame.setTempGameCreatedAt(rsGames.getString("created_at"));
                games.add(tempGame);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors du chargement de la liste des parties.");
        }
        return games;
    }

    @Override
    public void update(Game game) throws SQLException {

    }
}

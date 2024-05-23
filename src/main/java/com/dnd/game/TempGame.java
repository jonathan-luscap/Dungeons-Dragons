package com.dnd.game;

public class TempGame extends Game {
    private int tempGameID;
    private String tempGameCreatedAt;

    public int getTempGameID() {
        return tempGameID;
    }

    public void setTempGameId(int tempGameID) {
        this.tempGameID = tempGameID;
    }

    public String getTempGameCreatedAt() {
        return tempGameCreatedAt;
    }

    public void setTempGameCreatedAt(String tempGameCreatedAt) {
        this.tempGameCreatedAt = tempGameCreatedAt;
    }

    @Override
    public String toString() {
        return "Partie n°" + tempGameID + " sauvegardée le " + tempGameCreatedAt;
    }
}

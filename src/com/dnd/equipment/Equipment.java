package com.dnd.equipment;

import com.dnd.square.Square;

public abstract class Equipment implements Square {
    protected String type;
    protected String playerType;

    public Equipment() {
        this.type = null;
        this.playerType = null;
    }

    public Equipment(String type, String playerType) {
        this.type = type;
        this.playerType = playerType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

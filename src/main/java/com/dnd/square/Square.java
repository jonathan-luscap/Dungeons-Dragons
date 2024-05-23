package com.dnd.square;

import com.dnd.character.Persona;
import com.dnd.character.Player;
import com.dnd.exception.DragonDiedException;
import com.dnd.exception.DragonPeaceException;
import com.dnd.exception.PlayerDiedException;

public interface Square {
    void interact(Player player) throws PlayerDiedException, DragonDiedException, DragonPeaceException;
}

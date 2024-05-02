import com.dnd.exception.*;
import com.dnd.game.Game;
import com.dnd.menu.MainMenu;
import com.dnd.character.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        ArrayList<Adventurer> players = new ArrayList<>();
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start(players);
            game.play(players);
        }
        catch (StopGameException stopGameException)
        {
            System.out.println("A bientôt !!!");
        }
    }
}
import com.dnd.exception.*;
import com.dnd.game.Game;
import com.dnd.menu.StartMenu;
import com.dnd.character.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        ArrayList<Adventurer> players = new ArrayList<>();
        try {
            try {
                while (true){
                    StartMenu startMenu = new StartMenu();
                    boolean entered = false;
                    while (!entered)
                    {
                        try
                        {
                            startMenu.displayChoices();
                            players = startMenu.handleUserChoice(players,startMenu.getIntResponse());
                            entered = true;
                        }
                        catch (ArrayIndexOutOfBoundsException e)
                        {
                            System.out.println("Ce choix n'est pas valide");
                        }
                    }
                }
            } catch (StartPlayingException startPlayingException) {
                System.out.println("*****    Ok, let's play folks !!   *****");
            }
            game.play(players);
        }
        catch (StopGameException stopGameException)
        {
            System.out.println("A bientôt !!!");
        }
    }
}
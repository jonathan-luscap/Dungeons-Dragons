import com.dnd.character.Character;
import com.dnd.game.Game;
import com.dnd.menu.Menu;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList players = menu.startMenu();
        if ( players == null)
        {
            return;
        }
        System.out.println("Ok, let's start the game !");
        Game game = new Game();
        game.play(players);
    }
}
import com.dnd.character.Character;
import com.dnd.game.Game;
import com.dnd.menu.Menu;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = new Game();
        boolean continu = true;
        while (continu)
        {
            ArrayList<Character> players = menu.startMenu();
            if ( players == null)
            {
                return;
            }
            continu = game.play(players, menu);
        }
    }
}
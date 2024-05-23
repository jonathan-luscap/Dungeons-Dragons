import com.dnd.exception.*;
import com.dnd.game.Game;

public class
Main {
    public static void main(String[] args){
        Game game = new Game();
        try {
            game.gameLoop();
        }
        catch (StopGameException stopGameException)
        {
            System.out.println("A bientôt !!!");
        }
    }
}
import board.Board;
import player.Player;
import game.Game;
public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Board b=new Board(3,'#');
        // b.printConfig();

        Player p1=new Player();
        p1.setAttributesOFPlayer("Malavika",1,"Pro",'x');
        p1.printPlayerDetails();
        Player p2=new Player();
        p2.setAttributesOFPlayer("Princilla",2,"Pro",'0');
        p2.printPlayerDetails();


        Game game=new Game(new Player[]{p1,p2},b);
        game.play();
    }
}

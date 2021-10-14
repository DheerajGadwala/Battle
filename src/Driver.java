import battle.HumanPlayer;
import battle.Player;

public class Driver {
  public static void main(String[] args) {
    Player a = new HumanPlayer("Dheeraj");
    Player b = new HumanPlayer("Dheeraj");
    System.out.println(a.toString());
  }
}

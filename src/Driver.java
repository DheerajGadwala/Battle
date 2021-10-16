import battle.Battle;
import battle.BattleArena;
import battle.BattlePlayer;
import battle.Player;

import java.util.Scanner;

/**
 * Driver of the Battle Scenario.
 */
public class Driver {

  /**
   * Main method.
   */
  public static void main(String[] args) {
    System.out.println("WELCOME TO FIGHT CLUB");
    System.out.println("Creating new players with random stats....\n");
    Player a = new BattlePlayer("Commodus");
    Player b = new BattlePlayer("Spartacus");
    System.out.println(a);
    System.out.println(b);
    Battle battle = new BattleArena();
    battle.addPlayers(a, b);
    Scanner obj = new Scanner(System.in);
    do {
      System.out.println(battle.fight());
      System.out.println("Do you want a rematch?[y/[anything else]]\n");
    }
    while (obj.next().equals("y"));
  }
}

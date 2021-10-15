import battle.Battle;
import battle.BattleArena;
import battle.BattlePlayer;
import battle.Player;

public class Driver {
  public static void main(String[] args) {
    Player a = new BattlePlayer("Me");
    Player b = new BattlePlayer("Myself");
    Battle battle = new BattleArena(a, b);
    battle.distributeGear();
    battle.grantWeapons();
    battle.startBattle();
  }
}

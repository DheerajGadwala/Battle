package battle;

/**
 * This represents a battle.
 * A battle can have two players.
 * A battle ends with a victory of one of the players or with a draw.
 * Gears and weapons are distributed to players inside the battle.
 * Players can fight as many times as they want, Their health regenerates after each
 * round and they are given new gear and weapons.
 */
public interface Battle {

  /**
   * Returns the name of the winner or 'draw'.
   * @return a string representing the winner.
   */
  String getWinnerNameOrDraw();

  /**
   * Add players to the battle.
   * @param one Player one
   * @param two Player two
   * @throws IllegalArgumentException When players are null or are not new players.
   */
  void addPlayers(Player one, Player two) throws IllegalArgumentException;

  /**
   * Distribute gear between the players.
   */
  void distributeGear();

  /**
   * Give one weapon each to the players.
   */
  void grantWeapons();

  /**
   * Start the fight between the players.
   * @return Description of the fight.
   */
  String fight();
}

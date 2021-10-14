package battle;

/**
 * This object represents a player.
 */
public interface Player {

  double effectiveStrength();

  double effectiveDexterity();

  String getAllAbilities();

  /**
   * Add gear to a player.
   * @param gear gear to be added.
   */
  void addGear(Gear gear);

}

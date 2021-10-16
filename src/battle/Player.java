package battle;

/**
 * This object represents a player.
 * This can participate in battles.
 * This can equip itself with gear.
 * This has a name.
 */
public interface Player {
  /**
   * Returns name of the player.
   * @return name
   */
  String getName();

  /**
   * Returns the effective charisma of the player.
   * It is the sum of charisma from his gear and his own personal stat.
   * @return a double
   */
  double effectiveCharisma();

  /**
   * Returns the effective dexterity of the player.
   * It is the sum of dexterity from his gear and his own personal stat.
   * @return a double
   */
  double effectiveDexterity();

  /**
   * Returns true if a player has no gear and full health.
   * @return boolean
   */
  boolean isNewPlayer();

  /**
   * Returns striking power of the player.
   * @return a double
   */
  double strikingPower();

  /**
   * Returns the avoidance ability of a player.
   * @return a double
   */
  double avoidanceAbility();

  /**
   * Gets damage from weapon.
   * @return a double
   */
  double getWeaponDamage();

  /**
   * Returns the max damage the player's weapon can deal.
   * @return a double
   */
  double getWeaponMaxDamage();

  /**
   * Returns the potential striking damage of the player.
   * @return a double
   */
  double potentialStrikingDamage();

  /**
   * Returns actual damage of the player on another player.
   * @param that the other player.
   * @return damage dealt
   */
  double actualDamage(Player that);

  /**
   * Returns the effective constitution of the player.
   * It is the sum of constitution from his gear and his own personal stat.
   * @return effective constitution.
   */
  double effectiveConstitution();

  /**
   * Returns effective strength of the player.
   * It is the sum of strength from his gear and his own personal stat.
   * @return a double.
   */
  double effectiveStrength();

  /**
   * Returns false if heath is greater than 0.
   * @return boolean
   */
  boolean isAlive();

  /**
   * Returns health of the player.
   * @return a double
   */
  double getHealth();

  /**
   * Returns the number of gears the player currently has equipped.
   * @return an integer representing the number of gear.
   */
  int getNumberOfGear();

  /**
   * Returns the number of head gears the player currently has.
   * [For testing purposes]
   * @return an integer representing the number of head gear.
   */
  int getNumberOfHeadGear();

  /**
   * Returns the number of foot gears the player currently has.
   * [For testing purposes]
   * @return an integer representing the number of foot gear.
   */
  int getNumberOfFootGear();

  /**
   * Returns the number of potions the player has consumed.
   * [For testing purposes]
   * @return an integer representing the number of potions.
   */
  int getNumberOfPotions();

  /**
   * Returns the number of belt units the player has with his belts.
   * [For testing purposes]
   * @return an integer representing the number of belt units.
   */
  int getNumberOfBeltUnits();
}

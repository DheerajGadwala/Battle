package battle;

/**
 * Weapons are wielded by players in battle.
 * They have names.
 * They are of six types: Two handed sword, Broad sword, katanas, Flail, Axe and Fists.
 * Two handed sword, Broad sword and katanas are classified as swords.
 */
public interface Weapon {
  /**
   * Returns name of the weapon.
   * @return name as a string.
   */
  String getName();

  /**
   * Damage dealt by the weapon.
   * @return a double.
   */
  double getDamage();

  /**
   * Maximum damage that can be dealt using this weapon.
   * @return a double
   */
  double getMaxDamage();

  /**
   * Checks if given weapon is an Axe.
   * @return boolean
   */
  default boolean isAxe() {
    return false;
  }

  /**
   * Checks if given weapon is a Flail.
   * @return boolean
   */
  default boolean isFlail() {
    return false;
  }

  /**
   * Checks if given weapon is a sword.
   * @return boolean
   */
  default boolean isSword() {
    return false;
  }

  /**
   * Checks if given weapon is a two handed sword.
   * @return boolean
   */
  default boolean isTwoHandedSword() {
    return false;
  }

  /**
   * Checks if given weapon is a broad sword.
   * @return boolean
   */
  default boolean isBroadSword() {
    return false;
  }

  /**
   * Checks if given weapon are katanas.
   * @return boolean
   */
  default boolean isKatanas() {
    return false;
  }

  /**
   * Checks if given weapon are fists.
   * @return boolean
   */
  default boolean isFists() {
    return false;
  }

}

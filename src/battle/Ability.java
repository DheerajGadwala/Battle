package battle;

/**
 * Represents abilities.
 * They are of four types.
 * They have magnitudes.
 */
public interface Ability {
  /**
   * returns the magnitude of the ability.
   * @return an integer representing the magnitude.
   */
  int getMagnitude();
  
  default boolean isCharisma() {
    return false;
  }

  default boolean isDexterity() {
    return false;
  }

  default boolean isStrength() {
    return false;
  }

  default boolean isConstitution() {
    return false;
  }
}

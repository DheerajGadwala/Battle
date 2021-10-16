package battle;

/**
 * This is a type of ability.
 */
public class Strength extends AbstractAbility {

  /**
   * Creates a Strength object with the given value.
   * @param value magnitude of the ability.
   */
  public Strength(int value) {
    super(value);
  }

  @Override
  public boolean isStrength() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Strength: %d", value);
  }
}

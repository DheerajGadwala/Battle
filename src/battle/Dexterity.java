package battle;

/**
 * This is a type of ability.
 */
public class Dexterity extends AbstractAbility {
  /**
   * Creates a dexterity object with the given magnitude.
   * @param value magnitude of the ability.
   */
  public Dexterity(int value) {
    super(value);
  }

  @Override
  public boolean isDexterity() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Dexterity: %d", value);
  }
}

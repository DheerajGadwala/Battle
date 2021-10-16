package battle;

/**
 * This is a type of ability.
 */
public class Charisma extends AbstractAbility {

  /**
   * Creates a Charisma object with the given value.
   * @param value magnitude of the ability.
   */
  public Charisma(int value) {
    super(value);
  }

  @Override
  public boolean isCharisma() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Charisma: %d", value);
  }
}

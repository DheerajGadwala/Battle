package battle;

import java.util.List;

/**
 * This is a type of gear.
 * This can give a player two abilities.
 */
public class Belt extends MultipleAbilityGear {

  private final BeltSize size;

  /**
   * Creates a belt object.
   * @param name name of the gear
   * @param beltSize size of the belt
   * @param isDetrimental if the belt has a detrimental ability or not
   * @throws IllegalArgumentException if name is null or empty.
   */
  public Belt(String name, BeltSize beltSize, boolean isDetrimental)
      throws IllegalArgumentException {
    super(name);
    if (beltSize == null) {
      throw new IllegalArgumentException("Belt size can not be null");
    }
    this.size = beltSize;
    this.setAbilities(
        randomizer.getBeltAbility(isDetrimental, beltSize),
        randomizer.getBeltAbility(isDetrimental, beltSize)
    );
  }

  /**
   * Creates a belt object that has pseudo random abilities and their magnitudes.
   * @param name name of the belt
   * @param beltSize size of the belt
   * @param isDetrimental if the belt has a detrimental ability or not
   * @param random pseudo random numbers
   * @throws IllegalArgumentException if name is null or empty
   */
  public Belt(String name, BeltSize beltSize, boolean isDetrimental, int... random)
      throws IllegalArgumentException {
    super(name, random);
    if (beltSize == null) {
      throw new IllegalArgumentException("Belt size can not be null");
    }
    this.size = beltSize;
    this.setAbilities(randomizer.getAbility(isDetrimental), randomizer.getAbility(isDetrimental));
  }

  /**
   * Creates a belt object that might be random or pseudo random depending on the given input.
   * @param name name of the belt
   * @param beltSize size of the belt
   * @param isDetrimental if the belt has a detrimental ability or not
   * @param randomizer a randomizer object
   * @throws IllegalArgumentException if name is null or empty
   */
  public Belt(String name, BeltSize beltSize, boolean isDetrimental, Randomizer randomizer)
      throws IllegalArgumentException {
    super(name, randomizer);
    if (beltSize == null) {
      throw new IllegalArgumentException("Belt size can not be null");
    }
    this.size = beltSize;
    this.setAbilities(randomizer.getAbility(isDetrimental), randomizer.getAbility(isDetrimental));
  }

  int getSize() {
    return size.getSize();
  }

  @Override
  public boolean isBelt() {
    return true;
  }

  @Override
  public int compareTo(Belt that) {
    return -this.getName().compareTo(that.getName());
  }

  @Override
  public int compareTo(Gear that) {
    if (this == that) {
      return 0;
    }
    return that.compareTo(this);
  }

  @Override
  public boolean givesCharisma() {
    List<Ability> abilities = this.getAbilities();
    return abilities.get(0).isCharisma() || abilities.get(1).isCharisma();
  }

  @Override
  public boolean givesStrength() {
    List<Ability> abilities = this.getAbilities();
    return abilities.get(0).isStrength() || abilities.get(1).isStrength();
  }

  @Override
  public boolean givesConstitution() {
    List<Ability> abilities = this.getAbilities();
    return abilities.get(0).isConstitution() || abilities.get(1).isConstitution();
  }

  @Override
  public boolean givesDexterity() {
    List<Ability> abilities = this.getAbilities();
    return abilities.get(0).isDexterity() || abilities.get(1).isDexterity();
  }

  @Override
  public String toString() {
    return String.format(
        "%s [Belt], Size: %s, Abilities: #1: %s, #2: %s",
        this.name,
        this.size.toString(),
        this.abilities.get(0).toString(),
        this.abilities.get(1).toString()
    );
  }
}

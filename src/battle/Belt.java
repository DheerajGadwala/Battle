package battle;

import java.util.List;

public class Belt extends MultipleAbilityGear {

  private final BeltSize size;

  public Belt(String name, BeltSize beltSize, boolean isDetrimental)
      throws IllegalArgumentException {
    super(name);
    this.size = beltSize;
    this.setAbilities(
        randomizer.getBeltAbility(isDetrimental, beltSize),
        randomizer.getBeltAbility(isDetrimental, beltSize)
    );
  }

  Belt(String name, BeltSize beltSize, boolean isDetrimental, int ...random)
      throws IllegalArgumentException {
    super(name, random);
    this.size = beltSize;
    this.setAbilities(randomizer.getAbility(isDetrimental), randomizer.getAbility(isDetrimental));
  }

  public int getSize() {
    return size.getSize();
  }

  @Override
  public boolean isBelt () {
    return true;
  }

  @Override
  public int compareTo(Belt that) {
    return -this.getName().compareTo(that.getName());
  }

  @Override
  public int compareTo(Gear o) {
    if (this == o) {
      return 0;
    }
    AbstractGear that = (AbstractGear) o;
    return that.compareTo(this);
  }

  @Override
  public boolean givesCharisma() {
    List<AbstractAbility> abilities = this.getAbilities();
    return abilities.get(0).isCharisma() || abilities.get(1).isCharisma();
  }

  @Override
  public boolean givesStrength() {
    List<AbstractAbility> abilities = this.getAbilities();
    return abilities.get(0).isStrength() || abilities.get(1).isStrength();
  }

  @Override
  public boolean givesConstitution() {
    List<AbstractAbility> abilities = this.getAbilities();
    return abilities.get(0).isConstitution() || abilities.get(1).isConstitution();
  }

  @Override
  public boolean givesDexterity() {
    List<AbstractAbility> abilities = this.getAbilities();
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

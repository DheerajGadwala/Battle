package battle;

class Belt extends MultipleAbilityGear {

  private final BeltSize size;

  public Belt(String name, BeltSize beltSize, boolean isDetrimental)
      throws IllegalArgumentException {
    super(name);
    this.size = beltSize;
    this.setAbilities(
        randomizer.getAbility(isDetrimental),
        randomizer.getAbility(isDetrimental)
    );
  }

  public Belt(String name, BeltSize beltSize, boolean isDetrimental, int ...random)
      throws IllegalArgumentException {
    super(name, random);
    this.size = beltSize;
    this.setAbilities(randomizer.getAbility(isDetrimental), randomizer.getAbility(isDetrimental));
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
  public String toString() {
    return String.format(
        "%s [Belt], Abilities: #1: %s, #2: %s",
        this.name,
        this.abilities.get(0).toString(),
        this.abilities.get(1).toString()
    );
  }
}

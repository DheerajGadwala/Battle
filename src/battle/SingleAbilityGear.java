package battle;

import java.util.ArrayList;
import java.util.List;

abstract class SingleAbilityGear extends AbstractGear {

  protected Ability ability;

  protected SingleAbilityGear(String name)
      throws IllegalArgumentException {
    super(name);
  }

  protected SingleAbilityGear(String name, int ...random) {
    super(name, random);
  }

  public SingleAbilityGear(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  protected void setAbility(Ability ability) {
    this.ability = ability;
  }

  @Override
  public boolean hasOnlyOneAbility() {
    return true;
  }

  @Override
  public List<Ability> getAbilities() {
    List<Ability> ret = new ArrayList<>();
    ret.add(ability);
    return ret;
  }

}

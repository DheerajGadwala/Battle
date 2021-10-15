package battle;

import java.util.ArrayList;
import java.util.List;

abstract class SingleAbilityGear extends AbstractGear {

  protected AbstractAbility ability;

  protected SingleAbilityGear(String name)
      throws IllegalArgumentException {
    super(name);
  }

  protected SingleAbilityGear(String name, int ...random) {
    super(name, random);
  }

  protected void setAbility(AbstractAbility ability) {
    this.ability = ability;
  }

  abstract int getAbilityMagnitude();

  @Override
  public List<AbstractAbility> getAbilities() {
    List<AbstractAbility> ret = new ArrayList<>();
    ret.add(ability);
    return ret;
  }

  public String getName() {
    return this.name;
  }

  protected boolean givesCharisma() {
    return false;
  }

  protected boolean givesStrength() {
    return false;
  }

  protected boolean givesConstitution() {
    return false;
  }

  protected boolean givesDexterity() {
    return false;
  }
}

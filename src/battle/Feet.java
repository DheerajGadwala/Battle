package battle;

import Gear.AbstractGear;
import ability.AbstractAbility;

import java.util.ArrayList;
import java.util.List;

public class Feet extends AbstractOrgan {

  private AbstractGear gear;

  public Feet() {
    gear = new NoGear();
  }

  @Override
  public void addGear(AbstractGear gear) throws IllegalStateException{
    if (!this.gear.isNoGear()) {
      throw new IllegalStateException("Feet can only have one foot gear");
    }
    else if (!gear.isFootGear()) {
      throw new IllegalArgumentException("Feet can have only foot gear");
    }
    else {
      this.gear = (FootGear) gear;
    }
  }

  @Override
  public List<AbstractGear> getGears() {
    List<AbstractGear> ret = new ArrayList<>();
    if(gear.isFootGear()) {
      ret.add(gear);
    }
    return ret;
  }

  @Override
  public List<AbstractAbility> getGearAbilities() {
    return gear.getAbilities();
  }

  @Override
  public boolean isFeet() {
    return true;
  }

  @Override
  public String toString() {
    String ret = String.format("Feet:\n %s\n", gear.toString());
    return ret;
  }

}

package battle;

import Gear.AbstractGear;
import ability.AbstractAbility;

import java.util.ArrayList;
import java.util.List;

class Head extends AbstractOrgan {

  private AbstractGear gear;

  public Head() {
    gear = new NoGear();
  }

  @Override
  public void addGear(AbstractGear gear) throws IllegalStateException{
    if (!this.gear.isNoGear()) {
      throw new IllegalStateException("A head can have only one headGear");
    }
    else if (!gear.isHeadGear()) {
      throw new IllegalArgumentException("A head can only have headGears.");
    }
    else {
      this.gear = gear;
    }
  }

  @Override
  public List<AbstractGear> getGears() {
    List<AbstractGear> ret = new ArrayList<>();
    if(gear.isHeadGear()) {
      ret.add(gear);
    }
    return ret;
  }

  @Override
  public List<AbstractAbility> getGearAbilities() {
    return gear.getAbilities();
  }

  @Override
  public boolean isHead() {
    return true;
  }

  @Override
  public String toString() {
    String ret = String.format("Head:\n %s\n", gear.toString());
    return ret;
  }
}

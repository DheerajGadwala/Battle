package battle;

import Gear.AbstractGear;
import ability.AbstractAbility;

import java.util.ArrayList;
import java.util.List;

class Torso extends AbstractOrgan {

  List<Belt> belts;

  public Torso() {
    belts = new ArrayList<>();
  }

  private int findTotalBeltSizes() {
    int sum = 0;
    for(Belt k: belts) {
      sum += k.getSize();
    }
    return sum;
  }

  @Override
  public void addGear(AbstractGear gear) throws IllegalArgumentException {
    if(!gear.isBelt()) {
      throw new IllegalArgumentException("Torso can have only belts");
    }
    else if(((Belt)gear).getSize()+findTotalBeltSizes()>10) {
      throw new IllegalStateException("Torso can not fit more belts");
    }
    else {
      belts.add((Belt)gear);
    }
  }

  @Override
  public List<AbstractGear> getGears() {
    List<AbstractGear> ret = new ArrayList<>();
    for (AbstractGear g: belts) {
      ret.add(g);
    }
    return ret;
  }

  @Override
  public List<AbstractAbility> getGearAbilities() {
    List<AbstractAbility> ret = new ArrayList<>();
    for (AbstractGear g: belts) {
      ret.addAll((g.getAbilities()));
    }
    return ret;
  }

  @Override
  public boolean isTorso() {
    return true;
  }

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder("Torso: \n");
    if (belts.isEmpty()) {
      ret.append(" No Belts.");
      ret.append("\n");
    }
    else {
      for (Belt k : belts) {
        ret.append(" "+k.toString());
        ret.append("\n");
      }
    }
    return new String(ret);
  }
}

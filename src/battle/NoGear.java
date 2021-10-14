package battle;

import Gear.AbstractGear;
import ability.AbstractAbility;

import java.util.ArrayList;
import java.util.List;

public class NoGear extends AbstractGear {
  protected NoGear() {
    super("No Name");
  }

  @Override
  public String getName() {
    return "No Gear.";
  }

  @Override
  public String toString() {
    return "No Gear.";
  }

  @Override
  public boolean isNoGear() {
    return true;
  }

  @Override
  public List<AbstractAbility> getAbilities() {
    return new ArrayList<AbstractAbility>();
  }

  @Override
  public int compareTo(Gear o) {
    return -1;
  }
}

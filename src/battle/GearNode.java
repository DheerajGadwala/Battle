package battle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class GearNode implements GearList{
  private final AbstractGear gear;
  private final GearList rest;

  public GearNode(Gear gear, GearList rest) {
    this.gear = (AbstractGear)gear;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public Gear get(int i) {
    if (i < 0) {
      throw new IndexOutOfBoundsException("No such dog: " + i);
    }
    if (i == 0) {
      return gear;
    } else {
      try {
        return rest.get(i - 1);
      } catch (IndexOutOfBoundsException e) {
        throw new IndexOutOfBoundsException("No such dog: " + i);
      }
    }
  }

  @Override
  public boolean contains(AbstractGear gear) {
    return this.gear.compareTo(gear) == 0 || rest.contains(gear);
  }

  @Override
  public boolean containsHeadGear() {
    return this.gear.isHeadGear() || rest.containsHeadGear();
  }

  @Override
  public boolean containsFootGear() {
    return this.gear.isFootGear() || rest.containsFootGear();
  }

  @Override
  public int totalBeltUnits() {
    return (this.gear.isBelt() ? ((Belt)gear).getSize() : 0) + rest.totalBeltUnits();
  }

  @Override
  public List<AbstractAbility> getAllAbilitiesHelper(List<AbstractAbility> abilities) {
    abilities.addAll(this.gear.getAbilities());
    rest.getAllAbilitiesHelper(abilities);
    return abilities;
  }

  @Override
  public List<AbstractAbility> getAllAbilities() {
    List<AbstractAbility> ret = new ArrayList<>();
    getAllAbilitiesHelper(ret);
    return ret;
  }

  @Override
  public GearList sort(Comparator<AbstractGear> comp) {
    return rest.sort(comp).insert(gear, comp);
  }

  @Override
  public GearList insert(AbstractGear gear, Comparator<AbstractGear> comp) {
    if (comp.compare(this.gear, gear) >= 0) {
      return new GearNode(gear, this);
    } else {
      return new GearNode(this.gear, rest.insert(gear, comp));
    }
  }

  @Override
  public StringBuilder toStringHelper() {
    return new StringBuilder(gear+"\n").append(rest.toStringHelper());
  }

  @Override
  public String toString() {
    return new String(toStringHelper());
  }

}

package battle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class GearNode implements GearList {
  private final Gear gear;
  private final GearList rest;

  public GearNode(Gear gear, GearList rest) {
    this.gear = (Gear)gear;
    this.rest = rest;
  }

  @Override
  public boolean isGearNode() {
    return true;
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
  public boolean contains(Gear gear) {
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
  public int totalHeadGears() {
    return (this.gear.isHeadGear() ? 1 : 0) + rest.totalHeadGears();
  }

  @Override
  public int totalFootGears() {
    return (this.gear.isFootGear() ? 1 : 0) + rest.totalFootGears();
  }

  @Override
  public int totalPotions() {
    return (this.gear.isPotion() ? 1 : 0) + rest.totalPotions();
  }

  @Override
  public List<Ability> getAllAbilitiesHelper(List<Ability> abilities) {
    abilities.addAll(this.gear.getAbilities());
    rest.getAllAbilitiesHelper(abilities);
    return abilities;
  }

  @Override
  public List<Ability> getAllAbilities() {
    List<Ability> ret = new ArrayList<>();
    getAllAbilitiesHelper(ret);
    return ret;
  }

  @Override
  public GearList sort(Comparator<Gear> comp) {
    return rest.sort(comp).insert(gear, comp);
  }

  @Override
  public GearList insert(Gear gear, Comparator<Gear> comp) {
    if (comp.compare(this.gear, gear) >= 0) {
      return new GearNode(gear, this);
    } else {
      return new GearNode(this.gear, rest.insert(gear, comp));
    }
  }

  @Override
  public StringBuilder toStringHelper() {
    return new StringBuilder(gear + "\n").append(rest.toStringHelper());
  }

  @Override
  public String toString() {
    return new String(toStringHelper());
  }

}

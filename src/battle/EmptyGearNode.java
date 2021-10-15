package battle;

import java.util.Comparator;
import java.util.List;

class EmptyGearNode implements GearList{

  @Override
  public Gear get(int i) {
    throw new IndexOutOfBoundsException("No such gear: " + i);
  }

  @Override
  public boolean contains(AbstractGear gear) {
    return false;
  }

  @Override
  public boolean containsHeadGear() {
    return false;
  }

  @Override
  public boolean containsFootGear() {
    return false;
  }

  @Override
  public int totalBeltUnits() {
    return 0;
  }

  @Override
  public List<AbstractAbility> getAllAbilitiesHelper(List<AbstractAbility> abilities) {
    return null;
  }

  @Override
  public List<AbstractAbility> getAllAbilities() {
    return null;
  }

  @Override
  public int count() {
    return 0;
  }

  @Override
  public GearList sort(Comparator<AbstractGear> comp) {
    return this;
  }

  @Override
  public GearList insert(AbstractGear gear, Comparator<AbstractGear> comp) {
    return new GearNode(gear, this);
  }

  @Override
  public StringBuilder toStringHelper() {
    return new StringBuilder("");
  }

  @Override
  public String toString() {
    return "";
  }

}

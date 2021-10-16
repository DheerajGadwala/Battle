package battle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class EmptyGearNode implements GearList {

  @Override
  public boolean isEmptyNode() {
    return true;
  }

  @Override
  public Gear get(int i) {
    throw new IndexOutOfBoundsException("No such gear: " + i);
  }

  @Override
  public boolean contains(Gear gear) {
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
  public int totalHeadGears() {
    return 0;
  }

  @Override
  public int totalFootGears() {
    return 0;
  }

  @Override
  public int totalPotions() {
    return 0;
  }

  @Override
  public List<Ability> getAllAbilitiesHelper(List<Ability> abilities) {
    return null;
  }

  @Override
  public List<Ability> getAllAbilities() {
    return new ArrayList<Ability>();
  }

  @Override
  public int count() {
    return 0;
  }

  @Override
  public GearList sort(Comparator<Gear> comp) {
    return this;
  }

  @Override
  public GearList insert(Gear gear, Comparator<Gear> comp) {
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

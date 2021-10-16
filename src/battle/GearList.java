package battle;

import java.util.Comparator;
import java.util.List;

interface GearList {

  int count();

  Gear get(int i);

  boolean contains(Gear gear);

  boolean containsHeadGear();

  boolean containsFootGear();

  int totalBeltUnits();

  int totalHeadGears();

  int totalFootGears();

  int totalPotions();

  List<Ability> getAllAbilitiesHelper(List<Ability> abilities);

  List<Ability> getAllAbilities();

  GearList sort(Comparator<Gear> comp);

  GearList insert(Gear gear, Comparator<Gear> comp);

  StringBuilder toStringHelper();

  default boolean isGearNode() {
    return false;
  }

  default boolean isEmptyNode() {
    return false;
  }
}

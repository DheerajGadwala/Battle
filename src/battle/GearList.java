package battle;

import java.util.List;
import java.util.Comparator;

interface GearList {

  int count();
  Gear get(int i);
  boolean contains(AbstractGear gear);
  boolean containsHeadGear();
  boolean containsFootGear();
  int totalBeltUnits();
  List<AbstractAbility> getAllAbilitiesHelper(List<AbstractAbility> abilities);
  List<AbstractAbility> getAllAbilities();
  GearList sort(Comparator<AbstractGear> comp);
  GearList insert(AbstractGear gear, Comparator<AbstractGear> comp);
  StringBuilder toStringHelper();
}

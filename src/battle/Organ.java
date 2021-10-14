package battle;

import Gear.AbstractGear;
import ability.AbstractAbility;

import java.util.List;

interface Organ {

  void addGear(AbstractGear gear);

  List<AbstractGear> getGears();

  List<AbstractAbility> getGearAbilities();
}

package battle;

import java.util.List;

interface Gear extends Comparable<Gear> {

  String getName();

  List<AbstractAbility> getAbilities();


}

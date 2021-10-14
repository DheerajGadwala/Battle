package battle;

import java.util.List;

public interface Gear extends Comparable<Gear> {

  String getName();

  List<AbstractAbility> getAbilities();
}

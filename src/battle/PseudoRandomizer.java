package battle;

import ability.*;

class PseudoRandomizer implements Randomizer {

  int[] fakeRandom;
  int pointer;

  PseudoRandomizer(int ...random) {
    this.fakeRandom = random;
    this.pointer = 0;
  }

  @Override
  public int getIntBetween(int a, int b) {
    return fakeRandom[pointer++];
  }

  @Override
  public int getPlayerAbilityValue() {
    return fakeRandom[pointer++];
  }

  @Override
  public AbstractAbility getAbility(boolean isDetrimental) {
    int r = fakeRandom[pointer++];
    int val = fakeRandom[pointer++];
    if (r == 1) {
      return new Charisma(val);
    }
    else if (r == 2) {
      return new Constitution(val);
    }
    else if (r == 3) {
      return new Dexterity(val);
    }
    else {
      return new Strength(val);
    }
  }
}

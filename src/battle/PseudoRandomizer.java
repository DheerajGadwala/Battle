package battle;

import java.util.List;

/**
 * This can be given to other objects to act as a random number generator.
 * Ths has been used extensively for testing purposes.
 */
public class PseudoRandomizer implements Randomizer {

  int[] fakeRandom;
  int pointer;

  /**
   * Creates a PseudoRandomizer object.
   * @param random numbers to be returned.
   */
  public PseudoRandomizer(int... random) {
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
  public Ability getAbility(boolean isDetrimental) {
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

  @Override
  public void shuffle(List<Object> list) {
    return;
  }

  @Override
  public Ability getBeltAbility(boolean isDetrimental, BeltSize beltSize) {
    return getAbility(isDetrimental);
  }
}

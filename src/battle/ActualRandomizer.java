package battle;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This can be used to generate random number and random abilities with random magnitudes.
 */
public class ActualRandomizer implements Randomizer {

  Random rand = new Random();

  @Override
  public int getIntBetween(int a, int b) {
    int randomNumber = rand.nextInt(b - a + 1) + a;
    return randomNumber;
  }

  @Override
  public int getPlayerAbilityValue() {
    int value = 0;
    int count = 0;
    while (count < 3) {
      int r = getIntBetween(1, 6);
      if (r != 1) {
        value += r;
        count++;
      }
    }
    return value;
  }

  @Override
  public Ability getAbility(boolean isDetrimental) {
    int r = getIntBetween(1, 4);
    int sign = (isDetrimental ? -1 : 1);
    if (r == 1) {
      return new Charisma(sign * getIntBetween(1, 4));
    }
    else if (r == 2) {
      return new Constitution(sign * getIntBetween(1, 4));
    }
    else if (r == 3) {
      return new Dexterity(sign * getIntBetween(1, 4));
    }
    else {
      return new Strength(sign * getIntBetween(1, 4));
    }
  }

  @Override
  public void shuffle(List<Object> list) {
    Collections.shuffle(list);
  }

  @Override
  public Ability getBeltAbility(boolean isDetrimental, BeltSize beltSize) {
    int r = getIntBetween(1, 4);
    int sign = (isDetrimental ? -1 : 1);
    int x = beltSize == BeltSize.LARGE ? 3 : beltSize == BeltSize.MEDIUM ? 2 : 1;
    int y = beltSize == BeltSize.LARGE ? 5 : beltSize == BeltSize.MEDIUM ? 4 : 3;
    if (r == 1) {
      return new Charisma(sign * getIntBetween(x, y));
    }
    else if (r == 2) {
      return new Constitution(sign * getIntBetween(x, y));
    }
    else if (r == 3) {
      return new Dexterity(sign * getIntBetween(x, y));
    }
    else {
      return new Strength(sign * getIntBetween(x, y));
    }
  }
}

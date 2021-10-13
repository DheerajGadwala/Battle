package battle;

import java.util.Random;

/**
 * This can be used in various randomization scenarios.
 * Generating numbers for player abilities.
 * Generating numbers for item abilities.
 * Generating random damage values.
 */
class ActualRandomizer implements Randomizer {

  public int getIntBetween(int a, int b) {
    Random rand = new Random();
    return rand.nextInt(b - a + 1) + a;
  }

  /**
   * Generates abilities values for players.
   * @return an integer
   */
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

  /**
   * Generates a random ability.
   * Used to create random potions.
   * @param isDetrimental if the ability should be detrimental or not.
   * @return An abstract ability
   */
  public AbstractAbility getAbility(boolean isDetrimental) {
    int r = (isDetrimental ? -1 : 1) * getIntBetween(1, 4);
    if (r == 1) {
      return new Charisma(getIntBetween(1, 3));
    }
    else if (r == 2) {
      return new Constitution(getIntBetween(1, 3));
    }
    else if (r == 3) {
      return new Dexterity(getIntBetween(1, 3));
    }
    else {
      return new Strength(getIntBetween(1, 3));
    }
  }
}

package battle;

import java.util.List;

interface Randomizer {

  /**
   * Generates a random integer between a and b [inclusive].
   * @param a left boundary
   * @param b right boundary
   * @return an integer
   */
  int getIntBetween(int a, int b);

  /**
   * Generates abilities values for players.
   * @return an integer
   */
  int getPlayerAbilityValue();

  /**
   * Generates a random ability.
   * Used to create random potions.
   * @param isDetrimental if the ability should be detrimental or not.
   * @return An abstract ability.
   */
  AbstractAbility getAbility(boolean isDetrimental);

  /**
   * Shuffles the given list of objects.
   * @param list of shuffled objects.
   */
  void shuffle(List<Object> list);

  /**
   * Returns  a random ability for specifically for belts.
   * @param isDetrimental if the ability should be detrimental or not.
   * @param beltSize size of the belt.
   * @return a random ability.
   */
  AbstractAbility getBeltAbility(boolean isDetrimental, BeltSize beltSize);
}

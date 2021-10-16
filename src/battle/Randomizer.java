package battle;

import java.util.List;

/**
 * This can be used to generate random or pseudo random numbers for objects which need them.
 * This can generate numbers in a range.
 * This can generate abilities with random values.
 */
public interface Randomizer {

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
  Ability getAbility(boolean isDetrimental);

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
  Ability getBeltAbility(boolean isDetrimental, BeltSize beltSize);
}

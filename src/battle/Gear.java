package battle;

import java.util.List;

/**
 * Gear give abilities to players.
 * They are of four types: Head gear, Potion, Belt, Foot gear.
 */
public interface Gear extends Comparable<Gear> {
  /**
   * Gives name of the gear.
   * @return name of the player.
   */
  String getName();

  /**
   * Returns all abilities of a gear.
   * @return all abilities.
   */
  List<Ability> getAbilities();

  /**
   * Checks if gear is a belt.
   * @return boolean
   */
  default boolean isBelt() {
    return false;
  }

  /**
   * checks if given gear is foot gear.
   * @return boolean
   */
  default boolean isFootGear() {
    return false;
  }

  /**
   * checks if given gear is head gear.
   * @return boolean
   */
  default boolean isHeadGear() {
    return false;
  }

  /**
   * checks if given gear is a potion.
   * @return boolean
   */
  default boolean isPotion() {
    return false;
  }

  /**
   * For comparing types of gears. Headgear is always first.
   * @param that the other gear.
   * @return 1 if greater -1 if smaller. compares name if equal.
   */
  default int compareTo(HeadGear that) {
    return -1;
  }

  /**
   * For comparing types of gears. Potion is always second.
   * @param that the other gear.
   * @return 1 if greater -1 if smaller. compares name if equal.
   */
  default int compareTo(Potion that) {
    return -1;
  }

  /**
   * For comparing types of gears. Belt is always second from last.
   * @param that the other gear.
   * @return 1 if greater -1 if smaller. compares name if equal.
   */
  default int compareTo(Belt that) {
    return 1;
  }

  /**
   * For comparing types of gears. Foot gear is always last.
   * @param that the other gear.
   * @return 1 if greater -1 if smaller. compares name if equal.
   */
  default int compareTo(FootGear that) {
    return 1;
  }

  /**
   * checks if given gear gives charisma.
   * @return boolean
   */
  default boolean givesCharisma() {
    return false;
  }

  /**
   * checks if given gear gives strength.
   * @return boolean
   */
  default boolean givesStrength() {
    return false;
  }

  /**
   * checks if given gear gives constitution.
   * @return boolean
   */
  default boolean givesConstitution() {
    return false;
  }

  /**
   * checks if given gear gives dexterity.
   * @return boolean
   */
  default boolean givesDexterity() {
    return false;
  }

  /**
   * checks if given gear gives a single ability.
   * @return boolean
   */
  default boolean hasOnlyOneAbility() {
    return false;
  }

  /**
   * checks if given gear gives more than one ability.
   * @return boolean
   */
  default boolean hasMultipleAbilities() {
    return false;
  }

}

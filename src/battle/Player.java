package battle;

/**
 * This object represents a player.
 * This can participate in battles.
 * This can equip itself with gear.
 * This has a name.
 */
public interface Player {

  /**
   * Returns name of the player.
   * @return name as a string.
   */
  String getName();

  /**
   * Equips this player with the given gear.
   * @param gear new gear for the player to be equipped with
   * @throws IllegalArgumentException when gear is null
   * @throws IllegalStateException when the player can not fit any more gear of this type.
   */
  void equipGear(Gear gear) throws IllegalArgumentException, IllegalStateException;

}

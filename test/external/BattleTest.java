package external;

import battle.Battle;
import battle.BattleArena;
import battle.BattlePlayer;
import battle.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test suite for Battles.
 */
public class BattleTest {

  private Battle sample1;

  /**
   * Set up for this test suite.
   */
  @Before
  public void setUp() {
    sample1 = new BattleArena();
  }

  /**
   * Test showing that nulls can not be added as players to Battles.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayers_1() {
    sample1.addPlayers(null, null);
  }

  /**
   * Test showing that null can not be added as players to Battles.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayers_2() {
    sample1.addPlayers(null, new BattlePlayer("Kratos"));
  }

  /**
   * Test if all the expected gear is added to the players after they join the battle.
   */
  @Test
  public void testPlayerGearsAfterTheirAdditionToBattle() {
    Battle sample = new BattleArena(8,3,2,3,2,1,3,2,3,6,1,1,1,3,1,1,25,2,1,4,1,3,2,2,4,1,2,1,3,
        4,1,2,2,3,1,1,4,2,3,2,1,3,1,3,2,4,2,0,2,2,3,2,0,2,4,3,1,2,1,1,2,3,1,4,3,1,4,1,4,2,3,4,0,3,
        1,4,3,2,1,4,3,3,1,4,2,4,4,2,2,2,2,1,0,3,1,3,4,0,4,1,1,2,1,4,1,2,1,2,3,4,1,1,2,4,3,1,2,0,
        1,2,1,4,2,4,4,3,4,1,2,4,3,2,2,4,4,2,1,0,1,4,2,3,16,1,1,2,4,2,3,1,1,2,2,2,2,3,4,4,3,2,2,3,
        2,3,3,2,3,2,2,2,3,3,4,4,2,2,2,1,2,1,1);
    Player one = new BattlePlayer("A", 14, 12, 17, 7);
    Player two = new BattlePlayer("B", 12, 11, 18, 15);
    Assert.assertEquals("Player: A\n"
        + "Abilities: \n"
        + "Strength: 12 Charisma: 7 Dexterity: 14 Constitution: 17\n"
        + "Weapon: \n"
        + "Name: knuckle duster, Type: Fists\n"
        + "Health: 50.0\n", one.toString());
    Assert.assertEquals("Player: B\n"
        + "Abilities: \n"
        + "Strength: 11 Charisma: 15 Dexterity: 12 Constitution: 18\n"
        + "Weapon: \n"
        + "Name: knuckle duster, Type: Fists\n"
        + "Health: 56.0\n", two.toString());
    sample.addPlayers(one, two);
    Assert.assertEquals("Player: A\n"
        + "Base Abilities: \n"
        + "Strength: 12 Charisma: 7 Dexterity: 14 Constitution: 17 \n"
        + "Weapon: \n"
        + "Name: knuckle duster, Type: Fists\n"
        + "Gear: \n"
        + "HeadGear0 [HeadGear], Ability: Constitution: -3\n"
        + "belt0 [Belt], Size: SMALL, Abilities: #1: Charisma: 4, #2: Charisma: 3\n"
        + "belt1 [Belt], Size: SMALL, Abilities: #1: Constitution: 4, #2: Charisma: 2\n"
        + "belt2 [Belt], Size: MEDIUM, Abilities: #1: Dexterity: 4, #2: Charisma: 2\n"
        + "belt3 [Belt], Size: SMALL, Abilities: #1: Dexterity: 1, #2: Charisma: 4\n"
        + "belt4 [Belt], Size: SMALL, Abilities: #1: Dexterity: 2, #2: Charisma: 3\n"
        + "belt5 [Belt], Size: MEDIUM, Abilities: #1: Dexterity: 2, #2: Strength: 2\n"
        + "FootGear0 [FootGear], Ability: Dexterity: -1\n"
        + "Effective Abilities: \n"
        + "Strength: 14.0 Charisma: 25.0 Dexterity: 22.0 Constitution: 18.0\n"
        + "Health: 79.0\n", one.toString());
    Assert.assertEquals("Player: B\n"
        + "Base Abilities: \n"
        + "Strength: 11 Charisma: 15 Dexterity: 12 Constitution: 18 \n"
        + "Weapon: \n"
        + "Name: knuckle duster, Type: Fists\n"
        + "Gear: \n"
        + "potion0 [Potion], Ability: Charisma: 1\n"
        + "belt12 [Belt], Size: SMALL, Abilities: #1: Charisma: 4, #2: Dexterity: 3\n"
        + "belt6 [Belt], Size: LARGE, Abilities: #1: Constitution: 2, #2: Dexterity: 2\n"
        + "belt7 [Belt], Size: LARGE, Abilities: #1: Constitution: 4, #2: Dexterity: 1\n"
        + "belt8 [Belt], Size: SMALL, Abilities: #1: Charisma: 1, #2: Constitution: 3\n"
        + "Effective Abilities: \n"
        + "Strength: 11.0 Charisma: 21.0 Dexterity: 18.0 Constitution: 27.0\n"
        + "Health: 77.0\n", two.toString());
  }

  /**
   * Test if athe players added to arena get a valid set of gears.
   */
  @Test
  public void testPlayerGearsAfterAdditionToBattle() {
    Battle sample = new BattleArena(8,3,2,3,2,1,3,2,3,6,1,1,1,3,1,1,25,2,1,4,1,3,2,2,4,1,2,1,3,
        4,1,2,2,3,1,1,4,2,3,2,1,3,1,3,2,4,2,0,2,2,3,2,0,2,4,3,1,2,1,1,2,3,1,4,3,1,4,1,4,2,3,4,0,3,
        1,4,3,2,1,4,3,3,1,4,2,4,4,2,2,2,2,1,0,3,1,3,4,0,4,1,1,2,1,4,1,2,1,2,3,4,1,1,2,4,3,1,2,0,
        1,2,1,4,2,4,4,3,4,1,2,4,3,2,2,4,4,2,1,0,1,4,2,3,16,1,1,2,4,2,3,1,1,2,2,2,2,3,4,4,3,2,2,3,
        2,3,3,2,3,2,2,2,3,3,4,4,2,2,2,1,2,1,1);
    Player one = new BattlePlayer("A", 14, 12, 17, 7);
    Player two = new BattlePlayer("B", 12, 11, 18, 15);
    Assert.assertEquals("Player: A\n"
        + "Abilities: \n"
        + "Strength: 12 Charisma: 7 Dexterity: 14 Constitution: 17\n"
        + "Weapon: \n"
        + "Name: knuckle duster, Type: Fists\n"
        + "Health: 50.0\n", one.toString());
    Assert.assertEquals("Player: B\n"
        + "Abilities: \n"
        + "Strength: 11 Charisma: 15 Dexterity: 12 Constitution: 18\n"
        + "Weapon: \n"
        + "Name: knuckle duster, Type: Fists\n"
        + "Health: 56.0\n", two.toString());
    sample.addPlayers(one, two);
    Assert.assertTrue(one.getNumberOfPotions() >= 0);
    Assert.assertTrue(one.getNumberOfHeadGear() == 0 || one.getNumberOfHeadGear() == 1);
    Assert.assertTrue(one.getNumberOfFootGear() == 0 || one.getNumberOfFootGear() == 1);
    Assert.assertTrue(one.getNumberOfBeltUnits() <= 10);
    Assert.assertTrue(two.getNumberOfPotions() >= 0);
    Assert.assertTrue(two.getNumberOfHeadGear() == 0 || two.getNumberOfHeadGear() == 1);
    Assert.assertTrue(two.getNumberOfFootGear() == 0 || two.getNumberOfFootGear() == 1);
    Assert.assertTrue(two.getNumberOfBeltUnits() <= 10);
  }

  /**
   * Must end in a win of one of the players or as a draw.
   * Test if rounds are executed correctly.
   */
  @Test
  public void testWinnerDraw() {
    Battle sample = new BattleArena();
    Player a = new BattlePlayer("Dheeraj");
    Player b = new BattlePlayer("Gadwala");
    sample.addPlayers(a, b);
    sample.fight();
    Assert.assertTrue(
        sample.getWinnerNameOrDraw() == a.getName()
            || sample.getWinnerNameOrDraw() == b.getName()
            || sample.getWinnerNameOrDraw() == "draw");
  }
}
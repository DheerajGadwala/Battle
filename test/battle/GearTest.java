package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GearTest {

  Gear sample1;
  Gear sample2;
  Gear sample3;
  Gear sample4;
  Gear sample5;


  @Before
  public void setUp() {
    sample1 = new FootGear("footGear1", false);
    sample2 = new HeadGear("headGear1", false);
    sample3 = new Potion("potion1", false);
    sample4 = new Belt("belt1", BeltSize.LARGE, false);
    sample5 = new HeadGear("headGear2", false, 3);

  }

  @Test
  public void testValidIsHeadGear() {
    AbstractGear sample = (AbstractGear) sample2;
    assertTrue(sample.isHeadGear());
  }

  @Test
  public void testValidIsFootGear() {
    AbstractGear sample = (AbstractGear) sample1;
    assertTrue(sample.isFootGear());
  }

  @Test
  public void testValidIsPotion() {
    AbstractGear sample = (AbstractGear) sample3;
    assertTrue(sample.isPotion());
  }

  @Test
  public void testValidIsBelt() {
    AbstractGear sample = (AbstractGear) sample4;
    assertTrue(sample.isBelt());
  }

  @Test
  public void testInValidIsHeadGear() {
    AbstractGear sample = (AbstractGear) sample1;
    assertFalse(sample.isHeadGear());
  }

  @Test
  public void testInValidIsFootGear() {
    AbstractGear sample = (AbstractGear) sample3;
    assertFalse(sample.isFootGear());
  }

  @Test
  public void testInValidIsPotion() {
    AbstractGear sample = (AbstractGear) sample4;
    assertFalse(sample.isPotion());
  }

  @Test
  public void testInValidIsBelt() {
    AbstractGear sample = (AbstractGear) sample2;
    assertFalse(sample.isBelt());
  }

  /**
   * Head gear always gives constitution.
   */
  @Test
  public void testHeadGearGivesConstitution() {
    SingleAbilityGear sample = (SingleAbilityGear) sample5;
    assertTrue(sample.getAbilities().get(0).isConstitution());
    assertTrue(sample.givesConstitution());
    assertEquals(3, sample.getAbilities().get(0).getValue());
  }

  /**
   * Foot gear always gives dexterity.
   */
  @Test
  public void testFootGearGivesDexterity() {
    SingleAbilityGear sample = (SingleAbilityGear) sample5;
    assertTrue(sample.getAbilities().get(0).isConstitution());
    assertTrue(sample.givesConstitution());
    assertEquals(3, sample.getAbilities().get(0).getValue());
  }

}
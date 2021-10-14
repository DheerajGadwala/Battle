package battle;

import java.util.Arrays;
import java.util.List;

abstract class MultipleAbilityGear extends AbstractGear {

  protected List<AbstractAbility> abilities;

  protected MultipleAbilityGear(String name)
      throws IllegalArgumentException {
    super(name);
  }

  protected MultipleAbilityGear(String name, int ...random)
      throws IllegalArgumentException {
    super(name, random);
  }

  @Override
  public String getName() {
    return this.name;
  }

  protected void setAbilities(AbstractAbility ...abilities) {
    this.abilities = Arrays.asList(abilities);
  }

  private void checkI(int i) throws IllegalArgumentException {
    int size = this.abilities.size();
    if (i > size) {
      throw new IllegalArgumentException("This object contains only "
          + size + " elements, you asked for the "
          + i + " th index.");
    }
  }


  @Override
  public List<AbstractAbility> getAbilities() {
    return abilities;
  }

  public int getMagnitude(int i) throws IllegalArgumentException {
    this.checkI(i);
    return this.abilities.get(i).getValue();
  }

  protected boolean givesCharisma(int i) {
    this.checkI(i);
    return this.abilities.get(i).isCharisma();
  }

  protected boolean givesStrength(int i) {
    this.checkI(i);
    return this.abilities.get(i).isStrength();
  }

  protected boolean givesConstitution(int i) {
    this.checkI(i);
    return this.abilities.get(i).isConstitution();
  }

  protected boolean givesDexterity(int i) {
    this.checkI(i);
    return this.abilities.get(i).isDexterity();
  }
}

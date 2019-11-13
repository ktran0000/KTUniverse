package RPG;

public class Archer extends Human {

	public Archer(Human hero) {
		// Inherit from old character
		super(hero.getName(), hero.getSex(), hero.getLevel(), hero.getHP(), hero.getEquippedWeapon(),
				hero.getEquippedArmor(), hero.getStrength(), hero.getDexterity(), hero.getIntelligence());
	}

	@Override
	public int calculateAttackBonus() {
		if (this.getEquippedWeapon() instanceof Bow) {
			return this.getDexterity();
		} else {
			return 0;
		}

	}

	@Override
	public int calculateDefenseBonus() {
		if (this.getEquippedArmor() instanceof Leather) {
			return this.getDexterity();
		} else {
			return 0;
		}

	}
}
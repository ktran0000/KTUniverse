package RPG;

public class Warrior extends Human {

	public Warrior(Human hero) {

		// Inherit stats from old character
		super(hero.getName(), hero.getSex(), hero.getLevel(), hero.getHP(), hero.getEquippedWeapon(),
				hero.getEquippedArmor(), hero.getStrength(), hero.getDexterity(), hero.getIntelligence());
	}

	@Override
	public int calculateAttackBonus() {
		if (this.getEquippedWeapon() instanceof Axe) {
			return this.getStrength();
		} else {
			return 0;
		}

	}

	@Override
	public int calculateDefenseBonus() {
		if (this.getEquippedArmor() instanceof Chainmail) {
			return this.getStrength();
		} else {
			return 0;
		}

	}

}
package RPG;

public class Mage extends Human {

	// Inherit stats from old character
	public Mage(Human hero) {
		super(hero.getName(), hero.getSex(), hero.getLevel(), hero.getHP(), hero.getEquippedWeapon(),
				hero.getEquippedArmor(), hero.getStrength(), hero.getDexterity(), hero.getIntelligence());
	}

	@Override
	public int calculateAttackBonus() {
		if (this.getEquippedWeapon() instanceof Staff) {
			return this.getIntelligence();
		} else {
			return 0;
		}

	}

	@Override
	public int calculateDefenseBonus() {
		if (this.getEquippedArmor() instanceof Robe) {
			return this.getIntelligence();
		} else {
			return 0;
		}

	}
}

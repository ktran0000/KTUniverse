package RPG;

public class Bow extends Weapon {

	public Bow() {
		super();
	}

	@Override
	public String getCombatLine() {
		return "attacks with a bow";

	}

	@Override
	public String getCombatEffectiveLine() {
		return "uses their dexterity to power the attack of the bow";

	}

}

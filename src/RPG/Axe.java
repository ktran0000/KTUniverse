package RPG;

public class Axe extends Weapon {

	public Axe() {
		super();
	}

	@Override
	public String getCombatLine() {
		return "attacks with an axe";

	}

	@Override
	public String getCombatEffectiveLine() {
		return "uses their strength to power the attack of the axe";

	}

}

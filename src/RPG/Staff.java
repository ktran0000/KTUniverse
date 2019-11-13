package RPG;

public class Staff extends Weapon {

	@Override
	public String getCombatLine() {
		return "attacks with a staff";

	}

	@Override
	public String getCombatEffectiveLine() {
		return "uses their intelligence to power the attack of the staff";

	}

}

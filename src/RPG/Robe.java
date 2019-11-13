package RPG;

public class Robe extends Armor {

	@Override
	public String getCombatLine() {
		return "'s magical robe protected them from some of the attack";

	}

	@Override
	public String getCombatEffectiveLine() {
		return "uses their intelligence to resist some of the attack";

	}

}

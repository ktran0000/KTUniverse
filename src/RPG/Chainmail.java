package RPG;

public class Chainmail extends Armor {

	@Override
	public String getCombatLine() {
		return "'s mighty chainmail absorbs the attack";

	}

	@Override
	public String getCombatEffectiveLine() {
		return "uses their strength to absorb the attack";

	}
}
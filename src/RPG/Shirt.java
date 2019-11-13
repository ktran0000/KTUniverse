package RPG;

public class Shirt extends Armor {

	@Override
	public String getCombatLine() {
		return "'s normal clothes absorbs some of the damage";

	}

	@Override
	public String getCombatEffectiveLine() {
		return null;

	}
}

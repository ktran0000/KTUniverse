package RPG;

public class Leather extends Armor {

	@Override
	public String getCombatLine() {
		return "'s sneaky armor allows them to dodge some of the attack";

	}

	@Override
	public String getCombatEffectiveLine() {
		return "uses their dexterity to dodge some of the attack";

	}

}

package RPG;

public class Stick extends Weapon {
	public Stick() {
		super();
	}

	@Override
	public String getCombatLine() {
		return "attacks with a stick";

	}

	@Override
	public String getCombatEffectiveLine() {
		return "Nothing to bonus";

	}
}

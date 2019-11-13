package RPG;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author katietran
 */

abstract public class Equipment implements Serializable {

	private int level;

	public Equipment() {
		Random rng = new Random();
		this.setLevel(rng.nextInt(5) + 1);
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public String getCombatLine() {
		return "No weapon, hand fight";

	}

	public String getCombatEffectiveLine() {
		return "No armor, nothing to defend";

	}
}
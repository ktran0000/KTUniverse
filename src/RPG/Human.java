package RPG;

import java.io.Serializable;
import java.util.Random;

class Human implements Serializable {
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	private String name;
	private String sex;
	private int HP;
	private int level;
	private int strength;
	private int dexterity;
	private int intelligence;
	Random rng = new Random();

	// Declare new Human
	public Human(String name, String sex) {
		setName(name);
		setSex(sex);
		setLevel(rng.nextInt(5) + 1);
		setHP((rng.nextInt(5) + 1) + this.getLevel() * 2);
		setStrength(this.getLevel() + (rng.nextInt(5) + 1));
		setDexterity(this.getLevel() + (rng.nextInt(5) + 1));
		setIntelligence(this.getLevel() + (rng.nextInt(5) + 1));
	}

	// New human with old stats
	public Human(String name, String sex, int level, int HP, Weapon equippedWeapon, Armor equippedArmor, int strength,
			int dexterity, int intelligence) {
		setName(name);
		setSex(sex);
		setLevel(level);
		setHP(HP);
		setStrength(strength);
		setDexterity(dexterity);
		setIntelligence(intelligence);
		setEquippedWeapon(equippedWeapon);
		setEquippedArmor(equippedArmor);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}

	public Armor getEquippedArmor() {
		return equippedArmor;
	}

	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}

	public void takeDamage(int damage) {
		this.HP = this.HP - damage;
	}

	public int calculateAttackBonus() {
		return 0;
	}

	public int calculateDefenseBonus() {
		return 0;

	}
}
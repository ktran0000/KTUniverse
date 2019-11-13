package RPG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static Human hero;
	public static Scanner keyboard;

	public static void main(String[] args) {
		int choice;
		boolean quitLoop = false;
		keyboard = new Scanner(System.in);
		System.out.println("Welcome to Kween T Adventure game!");

		do {
			System.out.println(
					"\n1.Create a Character\n2.Change Class\n3.Discover a Weapon\n4.Discover an Armor\n5.See current character\n6.Fight\n7.Save character\n8.Load character\n9.Exit");
			System.out.print("Choose one of the following: ");
			choice = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println();
			switch (choice) {
			case 1:
				createCharacter();
				break;
			case 2:
				changeClass();
				break;
			case 3:
				discoverWeapon();
				break;
			case 4:
				discoverArmor();
				break;
			case 5:
				viewCharacter(hero);
				break;
			case 6:
				fight();
				break;
			case 7:
				saveCharacter();
				break;
			case 8:
				hero = loadCharacter();
				break;
			case 9:
				quitLoop = true;
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice, please try again");
				break;
			}
		} while (quitLoop == false);
	}

	// Create a new character. Allow user to choose name and gender
	private static void createCharacter() {
		String name, sex = null;
		int choice;
		Scanner kb = new Scanner(System.in);

		System.out.println("Please enter your name");
		name = kb.nextLine();
		System.out.println("Please choose gender");
		System.out.println("1. Female");
		System.out.println("2. Male");
		choice = kb.nextInt();
		kb.nextLine();
		switch (choice) {
		case 1:
			sex = "Female";
			break;
		case 2:
			sex = "Male";
			break;
		default:
			System.out.println("Invalid choice, please try again");
			break;
		}

		hero = new Human(name, sex);
		hero.setName(name);
		hero.setSex(sex);
		System.out.println("Welcome to Kween T Universe");
		System.out.println("Your name is " + hero.getName());
		System.out.println("Class: " + hero.getClass().getSimpleName());
		System.out.println("You are a " + hero.getSex());
		System.out.println("Your level is " + hero.getLevel());
		System.out.println("Your HP is " + hero.getHP());
	}

	// Change character's class
	private static void changeClass() {
		int choice;
		Scanner kb = new Scanner(System.in);

		if (hero != null) {
			System.out.println("Choose your new class");
			System.out.println("1. Warrior");
			System.out.println("2. Archer");
			System.out.println("3. Mage");
			choice = kb.nextInt();
			kb.nextLine();
			switch (choice) {
			case 1:
				hero = new Warrior(hero);
				System.out.println("You're now a " + hero.getClass().getSimpleName());
				break;
			case 2:
				hero = new Archer(hero);
				System.out.println("You're now a " + hero.getClass().getSimpleName());
				break;
			case 3:
				hero = new Mage(hero);
				System.out.println("You're now a " + hero.getClass().getSimpleName());
				break;
			default:
				System.out.println("Invalid choice, please try again");
				break;
			}
		} else {
			System.out.println("No character to change");
		}
	}

	// Discover new armor. Decide to equip it or not
	private static void discoverArmor() {
		int choice;
		int dice;
		Scanner kb = new Scanner(System.in);
		Armor newArmor = null;

		if (hero != null) {
			System.out.println("You found a new amor");

			Random rng = new Random();
			dice = rng.nextInt(4) + 1;

			switch (dice) {
			case 1:
				newArmor = new Shirt();
				break;
			case 2:
				newArmor = new Robe();
				break;
			case 3:
				newArmor = new Chainmail();
				break;
			case 4:
				newArmor = new Leather();
				break;
			}

			System.out.println("It is a " + newArmor.getClass().getSimpleName());
			System.out.println("Lv " + newArmor.getLevel());

			System.out.println("Do you want to equip it?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = kb.nextInt();
			kb.nextLine();
			switch (choice) {
			case 1:
				hero.setEquippedArmor(newArmor);
				System.out.println("Congrats! Your new armor is " + newArmor.getClass().getSimpleName());
				break;
			case 2:
				System.out.println("Goodbye you picky!");
				hero.setEquippedArmor(null);
				break;
			default:
				System.out.println("Invalid choice, please try again");
				break;
			}
		} else {
			System.out.println("No character");
		}

	}

	// Discover new weapon. Decide to equip it or not
	private static void discoverWeapon() {
		int choice;
		int dice;
		Scanner kb = new Scanner(System.in);
		Weapon newWeapon = null;

		if (hero != null) {
			System.out.println("You found a new Weapon");

			Random rng = new Random();
			dice = rng.nextInt(4) + 1;

			switch (dice) {
			case 1:
				newWeapon = new Stick();
				break;
			case 2:
				newWeapon = new Axe();
				break;
			case 3:
				newWeapon = new Bow();
				break;
			case 4:
				newWeapon = new Staff();
				break;
			}

			System.out.println("It is a " + newWeapon.getClass().getSimpleName());
			System.out.println("Lv " + newWeapon.getLevel());

			System.out.println("Do you want to equip it?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = kb.nextInt();
			kb.nextLine();
			switch (choice) {
			case 1:
				hero.setEquippedWeapon(newWeapon);
				System.out.println("Congrats! Your new Weapon is " + newWeapon.getClass().getSimpleName());
				break;
			case 2:
				System.out.println("Goodbye you picky!");
				hero.setEquippedWeapon(null);
				break;
			default:
				System.out.println("Invalid choice, please try again");
				break;
			}
		}

		else {
			System.out.println("No character");
		}
	}

	// Display everything about the character
	private static void viewCharacter(Human character) {
		if (character != null) {
			System.out.println("Name: " + character.getName());
			System.out.println("Gender: " + character.getSex());
			System.out.println("Class: " + character.getClass().getSimpleName());
			System.out.println("Lv. " + character.getLevel());
			System.out.println("HP: " + character.getHP());
			System.out.println("Strength: " + character.getStrength());
			System.out.println("Dexterity: " + character.getDexterity());
			System.out.println("Intelligence: " + character.getIntelligence());

			if (character.getEquippedArmor() != null) {
				System.out.println("Armor: " + character.getEquippedArmor().getClass().getSimpleName() + "      Lv. "
						+ character.getEquippedArmor().getLevel());
			} else {
				System.out.println("No Armor");
			}
			if (character.getEquippedWeapon() != null) {
				System.out.println("Weapon: " + character.getEquippedWeapon().getClass().getSimpleName() + "      Lv. "
						+ character.getEquippedWeapon().getLevel());
			} else {
				System.out.println("No Weapon");
			}
		} else {
			System.out.println("No character to view");
		}
	}

	// Fight
	// Load a saved character to fight
	private static void fight() {
		Human attacker, defender, buffer;
		boolean swap = true;

		if (hero != null) {
			attacker = hero;
			viewCharacter(attacker);
			System.out.println();
			System.out.println("Loaded another character to fight");
			if (fightLoaded() != null) {
				defender = fightLoaded();
				viewCharacter(defender);
				System.out.println();
				while (swap) {
					takeAction(defender, attacker);
					swap = false;
					if (defender.getHP() > 0) {
						buffer = attacker;
						attacker = defender;
						defender = buffer;
						swap = true;
					}
				}

				// Check defender's status
				if (defender.getHP() <= 0) {
					System.out.println(defender.getName() + " LOSE!");
					defender = null;
				}
			}

			else {
				System.out.println("No enemy");
			}

		} else {
			System.out.println("Nothing to fight");
		}
	}

	// Return a saved hero(Human)
	private static Human fightLoaded() {
		Human newEnemy;
		newEnemy = loadCharacter();
		return newEnemy;
	}

	// Fight
	private static void takeAction(Human defense, Human attack) {
		int dice;
		int damage = 0;
		int regular;
		int weaponLv, armorLv;
		Random rng = new Random();
		dice = rng.nextInt(100);

		System.out.println(attack.getName() + " is attacking " + defense.getName());

		// Check weapon/armor
		if (attack.getEquippedWeapon() == null) {
			weaponLv = 0;
		} else {
			weaponLv = attack.getEquippedWeapon().getLevel();
		}
		if (defense.getEquippedArmor() == null) {
			armorLv = 0;
		} else {
			armorLv = defense.getEquippedArmor().getLevel();
		}

		regular = attack.getLevel() + weaponLv + attack.calculateAttackBonus() - defense.getLevel() - armorLv
				- defense.calculateDefenseBonus();
		if (regular <= 0) {
			regular = 1;
		}

		// Chance
		if (dice <= 10) {
			damage = 0;
			System.out.println("Miss!");
			defense.takeDamage(damage);

		} else if (dice <= 80) {
			damage = regular;
			System.out.println("Regular Hit");
			defense.takeDamage(damage);
		} else if (dice >= 90 && dice <= 100) {
			damage = regular * 2;
			System.out.println("Critical x2");
			defense.takeDamage(damage);
		}

		// Print Combat Lines
		System.out.println(attack.getName() + " base damage: " + attack.getLevel());
		if (attack.getEquippedWeapon() != null) {
			System.out.println(attack.getName() + " " + attack.getEquippedWeapon().getCombatLine() + " +" + weaponLv);
			System.out.println("Bonus: " + attack.getName() + " " + attack.getEquippedArmor().getCombatEffectiveLine()
					+ " -" + attack.calculateDefenseBonus());
		} else {
			System.out.println("No weapon");
		}
		System.out.println(attack.getName() + "'s total damage: "
				+ (attack.getLevel() + weaponLv + attack.calculateDefenseBonus()));
		System.out.println(attack.getName() + "'s Current HP: " + attack.getHP());

		System.out.println();
		System.out.println();

		System.out.println(defense.getName() + " base defense: " + defense.getLevel());
		if (defense.getEquippedArmor() != null) {
			System.out.println(defense.getName() + " " + defense.getEquippedArmor().getCombatLine() + " -" + armorLv);
			System.out.println("Bonus: " + defense.getName() + " " + defense.getEquippedArmor().getCombatEffectiveLine()
					+ " -" + defense.calculateDefenseBonus());
		} else {
			System.out.println("No armor");
		}
		System.out.println(defense.getName() + "'s total defense: "
				+ (defense.getLevel() + armorLv + defense.calculateDefenseBonus()));
		System.out.println(defense.getName() + "'s Current HP: " + defense.getHP());

	}

	// Save hero to file on desktop
	private static void saveCharacter() {
		String location = "/Users/katietran/Desktop/hero.data";

		try {
			ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(location));
			save.writeObject(hero);
			System.out.println("Save Successfully!");
		} catch (Exception e) {
			System.out.println("Can't save");
		}
	}

	// Load hero from file on desktop
	private static Human loadCharacter() {
		String location = "/Users/katietran/Desktop/hero.data";

		try {
			ObjectInputStream load = new ObjectInputStream(new FileInputStream(location));
			hero = (Human) load.readObject();
			System.out.println("Load Successfully!");
		} catch (Exception e) {
			System.out.println("Can't load");
		}
		return hero;
	}

}

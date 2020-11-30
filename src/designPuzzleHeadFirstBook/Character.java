package designPuzzleHeadFirstBook;

public abstract class Character {
	WeaponBehavior weapon;
	abstract void fight();
	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}

}

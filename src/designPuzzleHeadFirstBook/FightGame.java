package designPuzzleHeadFirstBook;

public class FightGame {
	
	public static void main(String[] args) {
		
		Character king = new King();
		AxeBehavior axe = new AxeBehavior();
		SwordBehavior sword = new SwordBehavior();
		
		axe.useWeapon();
		king.setWeapon(axe);
		king.fight();
		sword.useWeapon();
		king.setWeapon(sword);
		king.fight();
		
		king = new Queen();
		
		axe.useWeapon();
		king.setWeapon(axe);
		king.fight();
		sword.useWeapon();
		king.setWeapon(sword);
		king.fight();
		
		king = new Knight();
		
		axe.useWeapon();
		king.setWeapon(axe);
		king.fight();
		sword.useWeapon();
		king.setWeapon(sword);
		king.fight();
	}

}

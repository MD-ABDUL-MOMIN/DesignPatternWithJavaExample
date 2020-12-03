package designpattern.decoratorPattern;

abstract class Beverage{
	
	String description="Unknown Beverage";
	public String getDescription() {
		return description;
	}
	public abstract double cost();
}

abstract class CondimentDecorator extends  Beverage{
	public abstract String getDescription();
}

class Espresso extends Beverage{

	Espresso(){
		description = "Espresso";
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}
	
}

class HouseBlend extends Beverage{

	public HouseBlend() {
		// TODO Auto-generated constructor stub
		description = "House blend cofee";
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 2.00;
	}
	
}

class DarkRoast extends Beverage{

	public DarkRoast() {
		// TODO Auto-generated constructor stub
		description = "Dark Roast with ";
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	
}

class Mocha extends CondimentDecorator{

	Beverage beverage;
	public double mochaPrice = 4;
	public String desc=", mocha";
	
	public Mocha(Beverage beverage) {
		// TODO Auto-generated constructor stub
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+desc;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+mochaPrice;
	}
	
}

class Milk extends CondimentDecorator{

	Beverage beverage;
	public double milkPrice = 4;
	public String desc=", milk";
	
	public Milk(Beverage beverage) {
		// TODO Auto-generated constructor stub
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+desc;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+milkPrice;
	}
}

class Soy extends CondimentDecorator{

	Beverage beverage;
	public double soyPrice = 4;
	public String desc=", soy";
	
	public Soy(Beverage beverage) {
		// TODO Auto-generated constructor stub
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+desc;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+soyPrice;
	}
}


class Whip extends CondimentDecorator{

	Beverage beverage;
	public double whipPrice = 4;
	public String desc=", whip";
	
	public Whip(Beverage beverage) {
		// TODO Auto-generated constructor stub
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+desc;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+whipPrice;
	}
}

public class StarBuzzWIthDecorator {
	
	public static void main(String[] args) {
		
		Beverage coffee1 = new Espresso();
		System.out.println("description "+coffee1.getDescription()+" "+coffee1.cost());
		
		Beverage darkRoastCofee = new DarkRoast();
		darkRoastCofee = new Whip(darkRoastCofee);
		System.out.println("description "+darkRoastCofee.getDescription()+" "+darkRoastCofee.cost());
		darkRoastCofee = new Milk(darkRoastCofee);
		System.out.println("description "+darkRoastCofee.getDescription()+" "+darkRoastCofee.cost());
		darkRoastCofee = new Mocha(darkRoastCofee);
		System.out.println("description "+darkRoastCofee.getDescription()+" "+darkRoastCofee.cost());
		
		Beverage houseBlend = new HouseBlend();
		
		houseBlend = new Mocha(houseBlend);
		System.out.println("description "+houseBlend.getDescription()+" "+houseBlend.cost());
		houseBlend = new Milk(houseBlend);
		System.out.println("description "+houseBlend.getDescription()+" "+houseBlend.cost());
	}

}

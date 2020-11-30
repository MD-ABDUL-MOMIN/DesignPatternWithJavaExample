package polymorphism;

public class DuckFactory {
	
	public static void main(String[] args) {
		Duck mallardDuck = new MallardDuck();

		//mallardDuck.quackBehavior.quack();
		//mallardDuck.flyBehavior.fly();
		
		//mallardDuck.display();
		ModelDuck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	
		
	}

}

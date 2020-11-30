package polymorphism;

public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void performQuack() {
		quackBehavior.quack();
	}

	public void performFly() {
		flyBehavior.fly();
	}

	public abstract void display();

	public void swim() {
		System.out.println("all ducks float, even dcoys");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

}

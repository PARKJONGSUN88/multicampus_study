package exercise.overall.hero;

public abstract class Hero implements CanFly, CanFight, CanSwim {

	@Override
	public void swim() {
		System.out.println(this+"이 헤엄친다.");
	}

	@Override
	public void fight() {
		System.out.println(this+"이 싸운다.");
	}

	@Override
	public void fly() {
		System.out.println(this+"이 난다.");
	}
	protected abstract void action();

}

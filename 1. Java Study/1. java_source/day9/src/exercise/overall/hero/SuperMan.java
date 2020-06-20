package exercise.overall.hero;

public class SuperMan extends Hero {

	@Override
	protected void action() {
		fly();
		swim();
		fight();
	}

	@Override
	public String toString() {
		return "¼öÆÛ¸Ç";
	}
	

}

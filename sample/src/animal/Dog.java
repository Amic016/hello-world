package animal;

public class Dog extends Animal {

	public Dog(String name, int age) {
		super(name, age);
	}

	@Override
	public String getSpeceis() {
		return "イヌ";
	}

	@Override
	public String getCry() {
		return "ワン!";
	}
}

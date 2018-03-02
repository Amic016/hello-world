package animal;

public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);
	}

	@Override
	public String getSpeceis() {
		return "ネコ";
	}

	@Override
	public String getCry() {
		return "にゃー";
	}
}

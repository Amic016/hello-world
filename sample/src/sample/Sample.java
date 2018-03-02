package sample;

import static java.util.Comparator.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import animal.Animal;
import animal.Cat;
import animal.Dog;

public class Sample {

	public static void main(String[] args) {
		List<Animal> animals = Arrays.asList(
				new Cat("シロ", 2),
				new Dog("ポチ", 5),
				new Dog("ハチ", 13),
				new Cat("タマ", 6));
		for (Animal animal : animals) {
			System.out.println(animal.toString());
		}
		System.out.println("--------------------------------------------");
		animals.stream()
				.filter(animal -> "ネコ".equals(animal.getSpeceis()))
				.forEach(animal -> System.out.println(animal.toString()));

		System.out.println("--------------------------------------------");
		List<Animal> sortedAnimals = animals.stream()
				.sorted((animal1, animal2) -> animal1.getAge() - animal2.getAge())
				.collect(Collectors.toList());
		for (Animal animal : sortedAnimals) {
			System.out.println(animal.toString());
		}

		System.out.println("--------------------------------------------");
		animals.stream().sorted(comparing(Animal::getAge, reverseOrder()))
				.forEach(animal -> System.out.println(animal.toString()));

		System.out.println("--------------------------------------------");
		Map<String, List<Animal>> map = animals.stream()
				.collect(Collectors.groupingBy(animal -> animal.getSpeceis()));
		for (Map.Entry<String, List<Animal>> mapAnimal : map.entrySet()) {
			System.out.println(mapAnimal.getKey());
			mapAnimal.getValue().stream()
					.forEach(animal -> System.out.println("	" + animal.toString()));
		}

		System.out.println("--------------------------------------------");
		map.forEach((speceis, list) -> {
			System.out.println(speceis);
			list.stream().forEach(animal -> System.out.println("	" + animal.toString()));
		});
	}

}

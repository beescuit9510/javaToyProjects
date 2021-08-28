

import java.util.Arrays;
import java.util.Comparator;

public class MyComparator {
	
	public static void main(String[] args) {
		Animal[] animals = {
		new Animal("bunny", 1),     
		new Animal("cat", 2),    
		new Animal("dog", 2),    
		new Animal("hamster", 3),
		new Animal("lion", 4),
		new Animal("panda", 4),
		new Animal("sparrow", 9),
		new Animal("parrot", 9),
		new Animal("monkey", 10),
		new Animal("tiger", 11),};
		
		int i = Arrays.binarySearch(animals, new Animal("ham", 9), Animal.AGE_ORDER_COMPARATOR);
		System.out.println(animals[i]);
		
	}

	public static class Animal {
		String species;
		int age;
		
		public Animal(String species, int age) {
			super();
			this.species = species;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Animals [species=" + species + ", age=" + age + "]";
		}

		
		public static final Comparator<Animal> AGE_ORDER_COMPARATOR = new Comp();

		private static class Comp implements Comparator<Animal> {

			@Override
			public int compare(Animal o1, Animal o2) {
				if(o1.age<o2.age)
					return -1;				
				if(o1.age<o2.age)
					return 1;
				
				return 0;
			}

		}

	}

}
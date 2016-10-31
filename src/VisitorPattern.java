// Example for visitor pattern design
// Read more: https://en.wikipedia.org/wiki/Visitor_pattern

public class Main {

    abstract static class Animal {
        abstract String meet(Animal a) ;
        abstract String meet(Cat c);
        abstract String meet(Dog d);
    }

    static class Cat extends Animal {
        // Cat doesn't need to know the class of a,
        // it just calls the right method of a
        @Override
        String meet (Animal a) {
            return a.meet (this);
        }

        // Called when a cat meets a cat
        @Override
        String meet (Cat c) {
            return "miau";
        }

        // Called when a dog meets a cat
        @Override
        String meet (Dog d) {
            return "fight";
        }
    }

    static class Dog extends Animal {
        // Dog doesn't need to know the class of a,
        // it just calls the right method of a
        @Override
        String meet (Animal a) {
            return a.meet(this);
        }

        // Called when a cat meets a dog
        @Override
        String meet (Cat c) {
            return "run";
        }

        // Called when a dog meets a dog
        @Override
        String meet (Dog d) {
            return "play";
        }
    }

    // for example
    static String whatHappensWith (Animal a, Animal b) {
        return a.meet(b);
    }


    // working example
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
	      System.out.println(whatHappensWith(cat, dog));
        System.out.println(whatHappensWith(dog, cat));
        System.out.println(whatHappensWith(cat, cat));
        System.out.println(whatHappensWith(dog, dog));
    }
}

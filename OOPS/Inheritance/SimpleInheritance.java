package OOPS.Inheritance;

public class SimpleInheritance {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.eat();
        d1.bark();
    }
}

class Animal {
    void eat() {
        System.out.println("this animal should eat");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dogs bark");
    }
}
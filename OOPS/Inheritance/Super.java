package OOPS.Inheritance;

class Animal {
    void eat() {
        System.out.println("eating");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("dog eating..");
        super.eat();
    }

}

public class Super {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.eat();

    }

}

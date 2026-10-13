package OOPS.Inheritance;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + "\n" + age;
    }

}

class Inhuman extends Person {
    String powers;

    Inhuman(String name, int age, String powers) {
        super(name, age);
        this.powers = powers;

    }

    public String toString() {
        return super.toString() + "\n" + powers;
    }

}

class Main {
    public static void main(String[] args) {
        Inhuman in = new Inhuman("batman", 24, "fly");
        System.out.println(in.toString());
    }
}
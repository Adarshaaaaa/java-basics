package OOPS.Relationships;

class Address {
    String city;
    String state;
    int pincode;

    Address(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;

    }

    void displayAddress() {
        System.out.println(city + "\n" + state + "\n" + pincode);
    }
}

class Student {
    private Address address;
    String name;
    int rollno;

    Student(String name, int rollno, Address address) {
        this.name = name;
        this.rollno = rollno;
        this.address = address;
    }

    Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
        this.address = new Address("Alappuzha", "kerala", 6890);

    }

    void display() {
        System.out.println(name + "\n" + rollno);
        address.displayAddress();
    }
}

public class HasRelationship {
    public static void main(String[] args) {
        Student stu = new Student("adarsh", 3, new Address("alappuzha", "kerala", 689));
        stu.display();
        Student stu1 = new Student("adarsh", 3);
        stu1.display();
    }

}

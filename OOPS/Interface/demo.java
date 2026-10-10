package OOPS.Interface;

interface Mother {
    void message();
}

interface Father {
    void message();
}

class Child implements Mother, Father {
    public void message() {
        System.out.println("bot mothe and father love son ");
    }
}

public class demo {
    public static void main(String[] args) {
        Child c = new Child();
        c.message();
        Mother m = new Child();
        m.message();
        Father f = new Child();
        f.message();
    }

}

package OOPS.Inheritance;

public class MultilevelInheritance {
    public static void main(String[] args) {
        Samsung s23 = new Samsung();
        s23.powerOn();
        s23.calling();
        s23.camera();

    }
}

class Device {
    void powerOn() {
        System.out.println(" power on...");
    }
}

class SmartPhone extends Device {
    void calling() {
        System.out.println(" calling....");
    }
}

class Samsung extends SmartPhone {
    void camera() {
        System.out.println(" taking telescopic picture");
    }
}
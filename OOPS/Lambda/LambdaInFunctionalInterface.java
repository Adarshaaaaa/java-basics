package OOPS.Lambda;

@FunctionalInterface
interface greeting {
    void greetings(String name);
}

public class LambdaInFunctionalInterface {
    public static void main(String[] args) {
        greeting g = name -> {
            System.out.println(name);
        };

        g.greetings("susheela");
    }
}

package OOPS.Exception.ThreadsFolder;

public class DefaultThreadConstructor extends Thread {

    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        String name = t1.getName();
        System.out.println(name);
    }
}

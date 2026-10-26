package OOPS.Generics;

class Box<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}

public class GenericClass {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println(intBox.get());
    }
}
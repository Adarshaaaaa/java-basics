package OOPS.Generics;

public class Locker<T> {
    private T item;

    void put(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public static void main(String[] args) {
        Locker<String> lock = new Locker<>();
        lock.put("c++book");
        System.out.println("book is" + lock.getItem());
        Locker<String> lock1 = new Locker<>();
        lock1.put("password" + 21233);
        System.out.println("book is" + lock1.getItem());

        Locker<String> lock2 = new Locker<>();
        lock2.put("price" + 123.44);
        System.out.println("book is" + lock2.getItem());

    }
}

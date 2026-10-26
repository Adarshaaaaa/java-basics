package OOPS.Generics;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class GenericMultipleParameter {
    public static void main(String[] args) {

        Pair<String, Integer> studentAge = new Pair<>("Alice", 21);
        System.out.println(studentAge.getKey() + " is " + studentAge.getValue() + " years old.");

        Pair<Integer, Double> employeeSalary = new Pair<>(101, 75000.50);
        System.out.println("ID " + employeeSalary.getKey() + " earns $" + employeeSalary.getValue());
    }
}

package OOPS.Inheritance;

public class HirarchielInheritance {
    public static void main(String[] args) {
        Triangle tr = new Triangle();
        Rectangle rec = new Rectangle();
        tr.drawTriangle();
        rec.drawRectangle();
    }
}

class Shape {
    String colour = "blue";
}

class Triangle extends Shape {
    void drawTriangle() {
        System.out.println("drawing" + colour + "triangle");
    }
}

class Rectangle extends Shape {
    void drawRectangle() {
        System.out.println("drawing" + colour + "reactangle");
    }
}
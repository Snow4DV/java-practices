public class ShapeTest {
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape class
        System.out.println(s1); // toString method call that was overridden in Circle class
        System.out.println(s1.getArea()); // Calling getArea abstract method that was overridden in class Circle
        System.out.println(s1.getPerimeter()); // Calling getPerimeter abstract method that was overridden in class Circle
        System.out.println(s1.getColor()); // Calling getColor method that is defined in parent class Shape
        System.out.println(s1.isFilled()); // Calling getColor method that is defined in parent class Shape
        // System.out.println(s1.getRadius());
        // Compilation error - method getRadius is not defined in class Shape to which newly created Circle object was
        // upcasted (however Circle class has it so downcast to Circle in order to call getRadius method is required)

        Circle c1 = (Circle) s1; // Downcast back to Circle
        System.out.println(c1); // Calling toString method that was overridden in class Circle
        System.out.println(c1.getArea()); // Calling toString method that was overridden in class Circle
        System.out.println(c1.getPerimeter()); // Calling getPerimeter method that was overridden in class Circle
        System.out.println(c1.getColor()); // Calling getColor method that was defined in parent class Shape
        System.out.println(c1.isFilled()); // Calling isFilled method that was defined in parent class Shape
        System.out.println(c1.getRadius()); // Calling getRadius method that was defined in class Circle

        // Shape s2 = new Shape(); // Compilation error - can't create instance of abstract class

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
        System.out.println(s3); // Calling toString method that was overridden in class Rectangle
        System.out.println(s3.getArea()); // Calling getArea method that was overridden in class Rectangle
        System.out.println(s3.getPerimeter()); // Calling getPerimeter method that was overridden in class Rectangle
        System.out.println(s3.getColor()); // Calling getColor method that was defined in parent class Shape
        // System.out.println(s3.getLength());
        // Compilation error - method getLength is not defined in class Shape to which newly created Rectangle object
        // was upcasted (however Rectangle class has it so downcast to Rectangle in order to call getLength method
        // is required)

        Rectangle r1 = (Rectangle)s3;   // Downcast
        System.out.println(r1); // Calling toString method that was overridden in Rectangle class
        System.out.println(r1.getArea()); // Calling getArea method that was overridden in Rectangle calss
        System.out.println(r1.getColor()); // Calling getColor method that was defined in parent class Shape
        System.out.println(r1.getLength()); // Calling getLength method that was defined in Rectangle class

        Shape s4 = new Square(6.6);     // Upcast
        System.out.println(s4); // toString's redefined in class Square
        System.out.println(s4.getArea()); // getArea's redefined in Squaere
        System.out.println(s4.getColor()); //getColor's defined in Shape
        // System.out.println(s4.getSide()); // Compilation error - no method defined in Shape with name getSide

        // Take note that we downcast Shape s4 to Rectangle,
        //  which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2); // toString's redefined in class square
        System.out.println(r2.getArea()); // getArea's redefined in square
        System.out.println(r2.getColor()); // getColor is defined in Shape
        // System.out.println(r2.getSide());//compilation error - getSide's not defined in rectangle(downcast to square)
        System.out.println(r2.getLength()); // getLength is defined in rectangle

        // Downcast Rectangle r2 to Square
        Square sq1 = (Square) r2;
        System.out.println(sq1); //toString's redefined in rectangle
        System.out.println(sq1.getArea()); // getArea's redefined in square
        System.out.println(sq1.getColor()); // getColor's defined in Shape
        System.out.println(sq1.getSide()); // getSide is defined in Square
        System.out.println(sq1.getLength()); // getLength is defined in Rectangle
    }

}

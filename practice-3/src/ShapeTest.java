import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {



    @Test
     void testUpcast() {
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        assertThrowsExactly(NoSuchMethodException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Shape.class.getMethod("getRadius");
            }
        });
    }

    @Test
    void testDowncast() {
        Shape s1 = new Circle(5.5, "RED", false);
        Circle c1 = (Circle) s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        assertThrowsExactly(NoSuchMethodException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Shape.class.getMethod("getRadius");
            }
        });
    }

    @Test
    void testAbstractObjectInit() {
        
    }

    @org.junit.jupiter.api.Test
    void getPerimeter() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}
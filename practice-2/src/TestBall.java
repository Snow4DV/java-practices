import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBall {

    Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(1.5, 2.6);
    }

    @Test
    void getX() {
        assertEquals(ball.getX(), 1.5);
    }

    @Test
    void getY() {
        assertEquals(ball.getY(), 2.6);
    }

    @Test
    void setX() {
        ball.setX(3.3);
        assertEquals(ball.getX(), 3.3);
    }

    @Test
    void setY() {
        ball.setY(4.4);
        assertEquals(ball.getY(), 4.4);
    }

    @Test
    void setXY() {
        ball.setXY(1.1, 2.2);
        assertEquals(ball.getX(), 1.1);
        assertEquals(ball.getY(), 2.2);
    }

    @Test
    void move() {
        ball.setXY(1.1, 2.2);
        ball.move(0.1, 0.2);
        assertTrue(Math.abs(all.getX() - 1.2000000000000002 <= 0.0000001));
        assertTrue(Math.abs(ball.getY() - 2.4000000000000004 <= 0.0000001));
    }

    @Test
    void testToString() {
        assertEquals(ball.toString(), "Ball @(1.5 , 2.6)");
    }

    @Test
    void testDefaultConstructor() {
        ball = new Ball();
        assertEquals(ball.getX(), 0.0);
        assertEquals(ball.getY(), 0.0);
    }
}

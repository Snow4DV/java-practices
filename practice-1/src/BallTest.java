import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball("Ecos", "MOTION BL-2001", 700, 280,
                "polyvinylpyrrolidone", Ball.BallType.FOOTBALL, Color.WHITE);
    }

    @Test
    void getProductName() {
        assertEquals(ball.getMaterial(), "polyvinylpyrrolidone");
    }

    @Test
    void getRadius() {
        assertEquals(ball.getRadius(), 700);
    }

    @Test
    void getWeight() {
        assertEquals(ball.getWeight(), 280);
    }

    @Test
    void getMaterial() {
        assertEquals(ball.getMaterial(), "polyvinylpyrrolidone");
    }

    @Test
    void getType() {
        assertEquals(ball.getType(), Ball.BallType.FOOTBALL);
    }

    @Test
    void toStringTest() {
        assertEquals(ball.toString(), "Ball{" +
                "manufacturer='" + ball.getManufacturer() + '\'' +
                ", productName='" + ball.getProductName() + '\'' +
                ", radius=" + ball.getRadius() +
                ", weight=" + ball.getWeight() +
                ", material='" + ball.getMaterial() + '\'' +
                ", type=" + ball.getType() +
                ", color=" + ball.getColor().toString() +
                '}', ball.toString());
        System.out.println("Print test");
        System.out.println(ball.toString());
    }

    @Test
    void wear() {
        ball.wear();
        assertEquals(ball.getRadius(), 699);
    }

}
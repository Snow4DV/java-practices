import java.awt.*;

public class Ball {

    public enum BallType {
        FOOTBALL, HANDBALL, BANDY, BASEBALL,
        BASKETBALL, BILLIARD, BOWLING, CRICKET,
        GOLF, LACROSSE, RINKBALL, ROLLER_HOCKEY,
        RUBBER_BAND, SQUASH, TABLE_TENNIS, TENNIS,
        VOLLEYBALL, WATER_POLO, SUPER
    }
    private final String manufacturer;
    private final String productName;
    private int radius; // unit - millimeters
    private final int weight; // unit - grams
    private final String material;
    private final BallType type;
    private final Color color;
    public Ball(String manufacturer, String productName, int radius, int weight, String material, BallType type,
                Color color) {
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.radius = radius;
        this.weight = weight;
        this.material = material;
        this.type = type;
        this.color = color;
    }

    public String getProductName() {
        return productName;
    }

    public int getRadius() {
        return radius;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String getMaterial() {
        return material;
    }

    public BallType getType() {
        return type;
    }

    public void wear() {
        radius--;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "manufacturer='" + manufacturer + '\'' +
                ", productName='" + productName + '\'' +
                ", radius=" + radius +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", type=" + type +
                ", color=" + color.toString() +
                '}';
    }
}

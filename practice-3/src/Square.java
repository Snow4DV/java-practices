public class Square extends Rectangle {
    public Square(double size) {
        super(size, size);
    }

    public Square() {
    }

    public Square(String color, boolean filled, double side) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return width;
    }
    public void setSide(double side) {
        super.width = side;
        super.length = side;
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + width +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

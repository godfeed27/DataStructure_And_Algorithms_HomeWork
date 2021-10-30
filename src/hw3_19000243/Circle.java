package hw3_19000243;

public class Circle extends Shape {

    private double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    protected double getPerimeter() {
        return this.radius * 2 * Math.PI;
    }

}

package hw3_19000243;

public class Sphere extends Shape {
    private double radius = 0;

    public Sphere(double radius) {
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
        return Math.pow(this.radius, 3) * Math.PI * 4 / 3;
    }

    @Override
    protected double getArea() {
        return 4 * Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    protected double getPerimeter() {
        return 0;
    }
}

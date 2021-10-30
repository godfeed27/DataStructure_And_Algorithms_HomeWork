package hw3_19000243;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShapeTest {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        // thêm các hình vào danh sách
        Rectangle rectangle1 = new Rectangle(10, 6);
        Rectangle rectangle2 = new Rectangle(5, 7);
        Rectangle rectangle3 = new Rectangle(4, 4);

        Circle circle1 = new Circle(2);
        Circle circle2 = new Circle(4);
        Circle circle3 = new Circle(6);

        Sphere sphere1 = new Sphere(2);
        Sphere sphere2 = new Sphere(4);
        Sphere sphere3 = new Sphere(6);

        shapes.add(rectangle1);
        shapes.add(rectangle2);
        shapes.add(rectangle3);
        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(circle3);
        shapes.add(sphere1);
        shapes.add(sphere2);
        shapes.add(sphere3);

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " có diện tích là " + shape.getArea());
            if (shape.getClass().getSimpleName().equals("Sphere")) {
                System.out.println("Thể tích là " + shape.getVolume());
            } else
                System.out.println("Chu vi là " + shape.getPerimeter());
            System.out.println();
        }

        // sắp xếp danh sách theo sự tăng dần của diện tích

        Collections.sort(shapes, new Comparator<Shape>() {

            @Override
            public int compare(Shape o1, Shape o2) {
                return Double.compare(o1.getArea(), o2.getArea());
            }

        });

        for (Shape shape : shapes) {
            System.out.print(shape.getClass().getSimpleName() + " S = " + shape.getArea() + ", ");
        }

    }
}

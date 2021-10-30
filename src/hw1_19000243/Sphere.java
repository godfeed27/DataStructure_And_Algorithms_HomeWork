package hw1_19000243;

public class Sphere {
    double r, x, y, z;

    public Sphere(double r, double x, double y, double z) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static double getArea(Sphere a) {
        return 4 * Math.PI * Math.pow(a.r, 2);
    }

    public static double getVolume(Sphere a) {
        return 4/3 * Math.PI * Math.pow(a.r, 3);
    }

    public static double getDistance(Sphere a, Sphere b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
    }

    public static Boolean isCovered(Sphere a, Sphere b) {
        return getDistance(a, b) < Math.abs(a.r - b.r);
    }

    public static Boolean isIntersecting(Sphere a, Sphere b) {
        return getDistance(a, b) >= Math.abs(a.r - b.r) && getDistance(a, b) <= a.r + b.r;
    }

    public static String checkStaus(Sphere a, Sphere b) {
        String str;
        if (isCovered(a, b)) {
            str = "Hai đường tròn lồng nhau";
        }
        else if (isIntersecting(a, b)) {
            str = "Hai đường tròn cắt nhau";
        }
        else {
            str = "Hai đường tròn không lồng nhau cũng không cắt nhau";
        }
        return str;
    }

    public static void main(String[] args) {
        Sphere a = new Sphere(5, 0, 0, 0);
        Sphere b = new Sphere(1.5, 1, 2, 2);
        // Sphere c = new Sphere(3, 1, 2, 2);
        System.out.println(checkStaus(a, b));
    }

}

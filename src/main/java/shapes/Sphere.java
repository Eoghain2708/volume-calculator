package shapes;

public final class Sphere implements Calculable {
    private final double radius;

    private Sphere(double radius) {
        validateRadius(radius);
        this.radius = radius;
    }

    public static Sphere ofRadius(double radius) {
        return new Sphere(radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateVolume() {
        double volume = (4.0d / 3.0d) * Math.PI * Math.pow(radius, 3);
        if (Double.isInfinite(volume)) {
            throw new ArithmeticException("Volume exceeds representational limit");
        }
        return volume;
    }


    private static void validateRadius(double radius) {
        if (!(radius > 0)) {
            throw new IllegalArgumentException("Radius must be more than zero");
        }
    }
}

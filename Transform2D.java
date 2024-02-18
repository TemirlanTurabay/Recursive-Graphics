public class Transform2D {
    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= alpha;
        }
        for (int i = 0; i < y.length; i++) {
            y[i] *= alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] += dx;
        }
        for (int i = 0; i < y.length; i++) {
            y[i] += dy;
        }
    }

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] temp = new double[array.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }
        return temp;
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        double[] savedx = copy(x);
        double[] savedy = copy(y);
        double radians = Math.toRadians(theta);
        for (int i = 0; i < x.length; i++) {
            x[i] = savedx[i] * Math.cos(radians) - savedy[i] * Math.sin(radians);
        }
        for (int i = 0; i < y.length; i++) {
            y[i] = savedy[i] * Math.cos(radians) + savedx[i] * Math.sin(radians);
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        int choice = Integer.parseInt(args[0]);
        if (choice == 1) {
            // Test for the "scale" function
            StdDraw.setScale(-5.0, +5.0);
            double[] x1 = { 0, 1, 1, 0 };
            double[] y1 = { 0, 0, 2, 1 };
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.polygon(x1, y1);
            scale(x1, y1, 2.0);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.polygon(x1, y1);
        }
        else if (choice == 2) {
            // Test for the "translate" function
            StdDraw.setScale(-5.0, +5.0);
            double[] x2 = { 0, 1, 1, 0 };
            double[] y2 = { 0, 0, 2, 1 };
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.polygon(x2, y2);
            translate(x2, y2, 2.0, 1.0);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.polygon(x2, y2);
        }
        else if (choice == 3) {
            // Test the "copy" function
            StdDraw.setScale(-5.0, 5.0);
            double[] x3 = { 0, 1, 1, 0 };
            double[] y3 = { 0, 0, 2, 1 };
            double[] cx = Transform2D.copy(x3);
            double[] cy = Transform2D.copy(y3);
            Transform2D.rotate(cx, cy, -45.0);
            Transform2D.translate(cx, cy, 1.0, 2.0);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.polygon(cx, cy);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.polygon(x3, y3);
        }
        else if (choice == 4) {
            // Test the "rotate" function
            StdDraw.setScale(-5.0, +5.0);
            double[] x4 = { 0, 1, 1, 0 };
            double[] y4 = { 0, 0, 2, 1 };
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.polygon(x4, y4);
            rotate(x4, y4, 45.0);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.polygon(x4, y4);
        }
    }
}

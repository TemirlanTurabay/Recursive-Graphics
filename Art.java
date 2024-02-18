import java.awt.Color;

public class Art {
    private static void Heart(double x, double y, double length, double angle1, double angle2) {
        double radius = length / 4;
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.arc(x + radius, y + radius, radius, angle1, angle2);
        StdDraw.arc(x - radius, y + radius, radius, angle1, angle2);
        StdDraw.line(x, y - length / 2, x + length / 2, y + length / 4);
        StdDraw.line(x, y - length / 2, x - length / 2, y + length / 4);
    }

    private static void SierpinskiCarpet(int n, double x, double y, double length, double angle1,
                                         double angle2) {
        if (n == 0) return;
        if (n % 2 == 0) StdDraw.setPenColor(Color.PINK);
        if (n % 2 == 1) StdDraw.setPenColor(Color.RED);
        StdDraw.filledSquare(x, y, length / 2.0);
        Heart(x, y, length, angle1, angle2);
        SierpinskiCarpet(n - 1, x - length, y - length, length / 3.0, angle1, angle2);
        SierpinskiCarpet(n - 1, x, y - length, length / 3.0, angle1, angle2);
        SierpinskiCarpet(n - 1, x + length, y - length, length / 3.0, angle1, angle2);
        SierpinskiCarpet(n - 1, x + length, y, length / 3.0, angle1, angle2);
        SierpinskiCarpet(n - 1, x + length, y + length, length / 3.0, angle1, angle2);
        SierpinskiCarpet(n - 1, x, y + length, length / 3.0, angle1, angle2);
        SierpinskiCarpet(n - 1, x - length, y + length, length / 3.0, angle1, angle2);
        SierpinskiCarpet(n - 1, x - length, y, length / 3.0, angle1, angle2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5;
        double y = 0.5;
        double length = 1.0 / 3.0;
        double angle1 = 0.0;
        double angle2 = 180.0;
        SierpinskiCarpet(n, x, y, length, angle1, angle2);
    }
}

package geometry;

public class SegmentIntersectionChecker {

    private static final double EPS = 1e-9;

    public static boolean intersects(Segment s1, Segment s2) {

        double x1 = s1.getX1(), y1 = s1.getY1();
        double x2 = s1.getX2(), y2 = s1.getY2();
        double x3 = s2.getX1(), y3 = s2.getY1();
        double x4 = s2.getX2(), y4 = s2.getY2();

        double d1 = direction(x3, y3, x4, y4, x1, y1);
        double d2 = direction(x3, y3, x4, y4, x2, y2);
        double d3 = direction(x1, y1, x2, y2, x3, y3);
        double d4 = direction(x1, y1, x2, y2, x4, y4);

        // --- общий случай ---
        if (d1 * d2 < 0 && d3 * d4 < 0) {
            return true;
        }

        // --- коллинеарность (через EPS) ---
        if (isZero(d1) && onSegment(x3, y3, x4, y4, x1, y1)) return true;
        if (isZero(d2) && onSegment(x3, y3, x4, y4, x2, y2)) return true;
        if (isZero(d3) && onSegment(x1, y1, x2, y2, x3, y3)) return true;
        if (isZero(d4) && onSegment(x1, y1, x2, y2, x4, y4)) return true;

        return false;
    }

    private static boolean isZero(double val) {
        return Math.abs(val) < EPS;
    }

    private static double direction(double xi, double yi,
                                    double xj, double yj,
                                    double xk, double yk) {
        return (xk - xi) * (yj - yi) - (xj - xi) * (yk - yi);
    }

    private static boolean onSegment(double xi, double yi,
                                     double xj, double yj,
                                     double xk, double yk) {
        return Math.min(xi, xj) <= xk && xk <= Math.max(xi, xj) &&
                Math.min(yi, yj) <= yk && yk <= Math.max(yi, yj);
    }
}



package geometry;

public class Main {

    public static void main(String[] args) {

        Segment s1;
        Segment s2;

        if (args.length == 8) {
            // --- CLI режим ---
            double x1 = Double.parseDouble(args[0]);
            double y1 = Double.parseDouble(args[1]);
            double x2 = Double.parseDouble(args[2]);
            double y2 = Double.parseDouble(args[3]);

            double x3 = Double.parseDouble(args[4]);
            double y3 = Double.parseDouble(args[5]);
            double x4 = Double.parseDouble(args[6]);
            double y4 = Double.parseDouble(args[7]);

            s1 = new Segment(x1, y1, x2, y2);
            s2 = new Segment(x3, y3, x4, y4);

        } else {
            // --- дефолтный сценарий (для простого запуска) ---
            System.out.println("Используются координаты по умолчанию");

            s1 = new Segment(0, 0, 5, 5);
            s2 = new Segment(0, 5, 5, 0);
        }

        boolean result = SegmentIntersectionChecker.intersects(s1, s2);

        System.out.println("Segments intersect: " + result);
    }
}
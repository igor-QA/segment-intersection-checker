package geometry;

public class Main {

    public static void main(String[] args) {

        if (args.length != 0 && args.length != 8) {
            System.out.println("Ошибка: нужно передать ровно 8 чисел (x1 y1 x2 y2 x3 y3 x4 y4)");
            return;
        }

        Segment s1;
        Segment s2;

        try {
            if (args.length == 8) {
                System.out.println("Используются координаты из аргументов");

                double[] values = parseArgs(args);

                s1 = new Segment(values[0], values[1], values[2], values[3]);
                s2 = new Segment(values[4], values[5], values[6], values[7]);

            } else {
                System.out.println("Используются координаты по умолчанию");

                s1 = new Segment(0, 0, 5, 5);
                s2 = new Segment(0, 5, 5, 0);
            }

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: все аргументы должны быть числами");
            return;
        }

        boolean result = SegmentIntersectionChecker.intersects(s1, s2);

        System.out.println("Segments intersect: " + result);
    }

    //--- helper-метод ---
    private static double[] parseArgs(String[] args) {
        double[] values = new double[8];
        for (int i = 0; i < args.length; i++) {
            values[i] = Double.parseDouble(args[i]);
        }
        return values;
    }
}
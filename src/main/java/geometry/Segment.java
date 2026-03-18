package geometry;

import lombok.Data;

@Data
public class Segment {
    private final Point start;
    private final Point end;

    public Segment(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public double getX1() {return start.getX();}

    public double getY1() {return start.getY();}

    public double getX2() {return end.getX();}

    public double getY2() {return end.getY();}
}
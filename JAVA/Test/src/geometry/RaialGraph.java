package geometry;

import java.util.ArrayList;
import java.util.List;

public class RaialGraph extends Shape {

    public Point center;
    public List<Point> SquarePoints;

    @Override
    public Point center() {
        return this.center; // TODO: part of the assignment
    }

    @Override
    public RaialGraph rotateBy(int degrees) {
        double radian = Math.toRadians(degrees);
        if (this.center != null) {
            if (!this.SquarePoints.isEmpty()) {
                ArrayList<Point> newPoints = new ArrayList<Point>();
                for (Point p : this.SquarePoints) {
                    double rotated_x = Math.cos(radian) * (p.x- this.center.x) -Math.sin(radian) * (p.y -this.center.y);
                    double rotated_y = Math.sin(radian) * (p.x-this.center.x) + Math.cos(radian) * (p.y-this.center.y) ;
                    p = new Point(p.name, Math.round(1000.0*(rotated_x + this.center.x))/1000.0, Math.round((rotated_y + this.center.y)*1000.0)/1000.0);
                    newPoints.add(p);
                }
                return new RaialGraph(newPoints.get(0),newPoints.get(1),newPoints.get(2),newPoints.get(3));
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    @Override
    public Shape translateBy(double x, double y) {
        if (this.center != null) {
            if (!this.SquarePoints.isEmpty()) {
                ArrayList<Point> newPoints = new ArrayList<Point>();
                for (Point p : this.SquarePoints) {
                    double translated_x = p.x + x;
                    double translated_y = p.y + y;
                    p = new Point(p.name, translated_x, translated_y);
                    newPoints.add(p);
                }
                return new RaialGraph(newPoints.get(0),newPoints.get(1),newPoints.get(2),newPoints.get(3));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        ArrayList<String> array = new ArrayList<String>();
        if (this.center == null) {
            return "There is No Center";
        } else {
            String res = "[" + this.center.toString();
            if (!(this.SquarePoints == null)) {
                for (Point p : this.SquarePoints) {
                    res = res + "; " + p.toString();
                }
            }
            return res + "]";
        }
    }

    public RaialGraph(Point a, Point b, Point c, Point d) {
        this.SquarePoints = new ArrayList<>();
        this.center = new Point("Center",
                (a.x + b.x + c.x + d.x) / 4,
                (a.y + b.y + c.y + d.y) / 4);
        if (!a.equals(b) && !a.equals(c) && !a.equals(d) && !b.equals(c) && !b.equals(d) && !c.equals(d)) {
            double ab = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
            double bc = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2));
            double cd = Math.sqrt(Math.pow(c.x - d.x, 2) + Math.pow(c.y - d.y, 2));
            double da = Math.sqrt(Math.pow(d.x - a.x, 2) + Math.pow(d.y - a.y, 2));
            if (ab == bc && bc == cd && cd == da && da == ab) {
                SquarePoints.add(a);
                SquarePoints.add(b);
                SquarePoints.add(c);
                SquarePoints.add(d);
            }
            else {
                throw new IllegalArgumentException("Not enough Points");
            }
        } else {
            throw new IllegalArgumentException("Not enough Points");
        }
    }

    public static void main(String... args) {
        Point fst = new Point("A", 3, 3);
        Point snd = new Point("B", 2, 3);
        Point trd = new Point("C", 2, 2);
        Point fth = new Point("D", 3, 2);

        // This will run Illegal ArgumentException
        //Shape wrongG = new Square(fst, snd, fth, trd);
        Shape g  = new RaialGraph(fst, snd, trd, fth);
        System.out.println(g);
        Shape g2 = new RaialGraph(fst, fth, trd, snd);
        System.out.println(g2);


        g.rotateBy(90);
        System.out.println( g.rotateBy(90));

        g.translateBy(1,1);
        System.out.println(g);

        System.out.println(g.center());

    }
}

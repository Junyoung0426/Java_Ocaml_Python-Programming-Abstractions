package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadialGraph extends Shape {

    public Point center;
    public List<Point> neighbors;

    public RadialGraph(Point center, List<Point> neighbors) {
        // TODO: part of assignment
        this.center = center;
        ArrayList<Double> distList = new ArrayList<>();
        for (Point p : neighbors) {
            double dist = Math.round(Math.sqrt(Math.pow(p.x - center.x, 2) + Math.pow(p.y - center.y, 2)));
            distList.add(dist);
        }
        if (distList.get(0).equals(distList.get(1))  && distList.get(1).equals(distList.get(2)) && distList.get(2).equals(distList.get(3))) {
            this.neighbors = neighbors;
        } else {
            throw new IllegalArgumentException("Not Enough Points");
        }
    }

    public RadialGraph(Point center) {
        // TODO: part of assignment
        this.center = center;

    }

    @Override
    public RadialGraph rotateBy(int degrees) {
        double radian = Math.toRadians(degrees);
        if (this.center != null) {
            if (!this.neighbors.isEmpty()) {
                ArrayList<Point> newPoints = new ArrayList<Point>();
                for (Point p : this.neighbors) {
                    double rotated_x = Math.cos(radian) * (p.x - this.center.x) - Math.sin(radian) * (p.y - this.center.y);
                    double rotated_y = Math.sin(radian) * (p.x - this.center.x) + Math.cos(radian) * (p.y - this.center.y);
                    p = new Point(p.name, Math.round(rotated_x + this.center.x) * 1000.0 / 1000.0, Math.round(rotated_y + this.center.y) * 1000.0 / 1000.0);
                    newPoints.add(p);
                }
                return new RadialGraph(this.center, Arrays.asList(newPoints.get(0),newPoints.get(1),newPoints.get(2),newPoints.get(3)));
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    @Override
    public RadialGraph translateBy(double x, double y) {

        if (this.center != null) {

            if (!this.neighbors.isEmpty()) {
                ArrayList<Point> newPoints = new ArrayList<Point>();
                for (Point p : this.neighbors) {
                    double translated_x = p.x + x;
                    double translated_y = p.y + y;
                    p = new Point(p.name, translated_x, translated_y);
                    newPoints.add(p);
                }
                return new RadialGraph(this.center, Arrays.asList(newPoints.get(0),newPoints.get(1),newPoints.get(2),newPoints.get(3)));
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
            if (!(this.neighbors == null)) {
                for (Point p : this.neighbors) {
                    res = res + "; " + p.toString();
                }
            }
            return res + "]";
        }
    }

    @Override
    public Point center() {
        return this.center; // TODO: part of assignment
    }

    /* Driver method given to you as an outline for testing your code. You can modify this as you want, but please keep
     * in mind that the lines already provided here as expected to work exactly as they are (some lines have additional
     * explanation of what is expected) */
    public static void main(String... args) {
        Point center = new Point("center", 0, 0);
        Point east = new Point("east", 1, 0);
        Point west = new Point("west", -1, 0);
        Point north = new Point("north", 0, 1);
        Point south = new Point("south", 0, -1);
        Point toofarsouth = new Point("south", 0, -2);

        // A single node is a valid radial graph.
        RadialGraph lonely = new RadialGraph(center);

        // Must print: [(center, 0.0, 0.0)]
        System.out.println(lonely);


        // This line must throw IllegalArgumentException, since the edges will not be of the same length
        //RadialGraph nope = new RadialGraph(center, Arrays.asList(north, toofarsouth, east, west));

        Shape g = new RadialGraph(center, Arrays.asList(north, south, east, west));

        // Must follow the documentation in the Shape abstract class, and print the following string:
        // [(center, 0.0, 0.0); (east, 1.0, 0.0); (north, 0.0, 1.0); (west, -1.0, 0.0); (south, 0.0, -1.0)]
        System.out.println(g);

        // After this counterclockwise rotation by 90 degrees, "north" must be at (-1, 0), and similarly for all the
        // other radial points. The center, however, must remain exactly where it was.
        g = g.rotateBy(90);
        System.out.println(g);


        // you should similarly add tests for the translateBy(x, y) method
        g = g.translateBy(-1, -1);
        System.out.println(g);
    }
}

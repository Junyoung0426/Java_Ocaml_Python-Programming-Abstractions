package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadialGraphSymmetries implements Symmetries<RadialGraph> {

    @Override
    public boolean areSymmetric(RadialGraph s1, RadialGraph s2) {
        List<RadialGraph> col = symmetriesOf(s1);
        List<Double> x = new ArrayList<>(4);
        List<Double> y = new ArrayList<>(4);
        for (Point p : s2.neighbors) {
            x.add(p.x);
            y.add(p.y);
        }
        for (RadialGraph sq : col) {
            List<Double> xs = new ArrayList<>(4);
            List<Double> ys = new ArrayList<>(4);
            for (Point p : sq.neighbors) {
                xs.add(p.x);
                ys.add(p.y);
            }
            if (x.equals(xs) && y.equals(ys)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public List<RadialGraph> symmetriesOf(RadialGraph s) {

        List<RadialGraph> symmetries = new ArrayList<>();
        symmetries.add(s.rotateBy(0));
        symmetries.add(s.rotateBy(90));
        symmetries.add(s.rotateBy(180));
        symmetries.add(s.rotateBy(270));
        Point p1 = new Point(s.neighbors.get(0).name,s.neighbors.get(1).x,s.neighbors.get(1).y);
        Point p2 = new Point(s.neighbors.get(1).name,s.neighbors.get(0).x,s.neighbors.get(0).y);
        Point p3 = new Point(s.neighbors.get(2).name,s.neighbors.get(2).x,s.neighbors.get(2).y);
        Point p4 = new Point(s.neighbors.get(3).name,s.neighbors.get(3).x,s.neighbors.get(3).y);
        symmetries.add(new RadialGraph(s.center, Arrays.asList(p1, p2, p3, p4)));

        p1 = new Point(s.neighbors.get(0).name, s.neighbors.get(0).x, s.neighbors.get(0).y);
        p2 = new Point(s.neighbors.get(1).name,s.neighbors.get(1).x,s.neighbors.get(1).y);
        p3 = new Point(s.neighbors.get(2).name,s.neighbors.get(3).x,s.neighbors.get(3).y);
        p4 = new Point(s.neighbors.get(3).name,s.neighbors.get(2).x,s.neighbors.get(2).y);
        symmetries.add(new RadialGraph(s.center, Arrays.asList(p1, p2, p3, p4)));

        p1 = new Point(s.neighbors.get(0).name,s.neighbors.get(3).x,s.neighbors.get(3).y);
        p2 = new Point(s.neighbors.get(1).name,s.neighbors.get(4).x,s.neighbors.get(4).y);
        p3 = new Point(s.neighbors.get(2).name,s.neighbors.get(1).x,s.neighbors.get(1).y);
        p4 = new Point(s.neighbors.get(3).name,s.neighbors.get(2).x,s.neighbors.get(2).y);
        symmetries.add(new RadialGraph(s.center, Arrays.asList(p1, p2, p3, p4)));

        p1 = new Point(s.neighbors.get(0).name,s.neighbors.get(3).x,s.neighbors.get(3).y);
        p2 = new Point(s.neighbors.get(1).name,s.neighbors.get(2).x,s.neighbors.get(2).y);
        p3 = new Point(s.neighbors.get(2).name,s.neighbors.get(1).x,s.neighbors.get(1).y);
        p4 = new Point(s.neighbors.get(3).name,s.neighbors.get(0).x,s.neighbors.get(0).y);
        symmetries.add(new RadialGraph(s.center, Arrays.asList(p1, p3, p2, p1)));




        return symmetries;
    }
}

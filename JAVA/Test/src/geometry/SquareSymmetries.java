package geometry;

import java.util.ArrayList;
import java.util.List;


public class SquareSymmetries implements Symmetries<RaialGraph> {
    @Override
    public boolean areSymmetric(RaialGraph s1, RaialGraph s2) {
        List<RaialGraph> col = symmetriesOf(s2);
        List<Double> x = new ArrayList<>(4);
        List<Double> y = new ArrayList<>(4);
        for (Point p : s1.SquarePoints) {
            x.add(p.x);
            y.add(p.y);
        }
        for (RaialGraph sq : col) {
            List<Double> xs = new ArrayList<>(4);
            List<Double> ys = new ArrayList<>(4);
            for (Point p : sq.SquarePoints) {
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
    public List<RaialGraph> symmetriesOf(RaialGraph s) {

        List<RaialGraph> symmetries = new ArrayList<>();
        symmetries.add(s.rotateBy(0));
        symmetries.add(s.rotateBy(90));
        symmetries.add(s.rotateBy(180));
        symmetries.add(s.rotateBy(270));

        Point p1 = new Point(s.SquarePoints.get(0).name,s.SquarePoints.get(3).x,s.SquarePoints.get(3).y);
        Point p2 = new Point(s.SquarePoints.get(1).name,s.SquarePoints.get(2).x,s.SquarePoints.get(2).y);
        Point p3 = new Point(s.SquarePoints.get(2).name,s.SquarePoints.get(1).x,s.SquarePoints.get(1).y);
        Point p4 = new Point(s.SquarePoints.get(3).name,s.SquarePoints.get(0).x,s.SquarePoints.get(0).y);
        symmetries.add(new RaialGraph(p1, p2, p3, p4));

        p1 = new Point(s.SquarePoints.get(0).name, s.SquarePoints.get(2).x, s.SquarePoints.get(2).y);
        p2 = new Point(s.SquarePoints.get(1).name,s.SquarePoints.get(1).x,s.SquarePoints.get(1).y);
        p3 = new Point(s.SquarePoints.get(2).name,s.SquarePoints.get(0).x,s.SquarePoints.get(0).y);
        p4 = new Point(s.SquarePoints.get(3).name,s.SquarePoints.get(3).x,s.SquarePoints.get(3).y);
        symmetries.add(new RaialGraph(p1, p2, p3, p4));

        p1 = new Point(s.SquarePoints.get(0).name,s.SquarePoints.get(1).x,s.SquarePoints.get(1).y);
        p2 = new Point(s.SquarePoints.get(1).name,s.SquarePoints.get(0).x,s.SquarePoints.get(0).y);
        p3 = new Point(s.SquarePoints.get(2).name,s.SquarePoints.get(3).x,s.SquarePoints.get(3).y);
        p4 = new Point(s.SquarePoints.get(3).name,s.SquarePoints.get(2).x,s.SquarePoints.get(2).y);
        symmetries.add(new RaialGraph(p1, p2, p3, p4));

        p1 = new Point(s.SquarePoints.get(0).name,s.SquarePoints.get(0).x,s.SquarePoints.get(0).y);
        p2 = new Point(s.SquarePoints.get(1).name,s.SquarePoints.get(3).x,s.SquarePoints.get(3).y);
        p3 = new Point(s.SquarePoints.get(2).name,s.SquarePoints.get(2).x,s.SquarePoints.get(2).y);
        p4 = new Point(s.SquarePoints.get(3).name,s.SquarePoints.get(1).x,s.SquarePoints.get(1).y);
        symmetries.add(new RaialGraph(p1, p2, p3, p4));

        return symmetries;
    }
}

package geometry;

import java.util.*;

public class SquareSymmetries implements Symmetries<Square> {
    @Override
    public boolean areSymmetric(Square s1, Square s2) {
        for (Square symm : symmetriesOf(s1)) {
            List<Point> square1 = symm.SquarePoints;
            List<Point> square2 = s2.SquarePoints;
            if (square1.get(0).x == square2.get(0).x && square1.get(0).y == square2.get(0).y &&
                    square1.get(1).x == square2.get(1).x && square1.get(1).y == square2.get(1).y &&
                    square1.get(2).x == square2.get(2).x && square1.get(2).y == square2.get(2).y &&
                    square1.get(3).x == square2.get(3).x && square1.get(3).y == square2.get(3).y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Square> symmetriesOf(Square s) {

        List<Square> symmetries = new ArrayList<>();
        int n = s.SquarePoints.size();
        for (int i = 0; i < n; i++) {
            symmetries.add(s.rotateBy(i * 360 / n));
        }

        List<Point> lst = s.SquarePoints;
        Point p1 = new Point(lst.get(0).name, lst.get(3).x, lst.get(3).y);
        Point p2 = new Point(lst.get(1).name, lst.get(2).x, lst.get(2).y);
        Point p3 = new Point(lst.get(2).name, lst.get(1).x, lst.get(1).y);
        Point p4 = new Point(lst.get(3).name, lst.get(0).x, lst.get(0).y);

        Square t1 = new Square(p1, p2, p3, p4);
        for (int i = 0; i < 4; i++) {
            symmetries.add(t1.rotateBy(i * 90));
        }
        return symmetries;
    }
}

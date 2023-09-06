package geometry;

import java.util.*;

public class RadialGraphSymmetries implements Symmetries<RadialGraph> {

    @Override
    public boolean areSymmetric(RadialGraph s1, RadialGraph s2) {
        boolean res = false;
        for (RadialGraph symt : symmetriesOf(s1)) {
            List<Point> radial1 = symt.neighbors;
            List<Point> radial2 = s2.neighbors;
            for (int i = 0; i < radial2.size(); i++) {
                res = res || (radial1.get(i).x == radial2.get(i).x && radial1.get(i).y == radial2.get(i).y);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<RadialGraph> symmetriesOf(RadialGraph s) {

        List<RadialGraph> symmetries = new ArrayList<>();
        int n = s.neighbors.size();
        for (int i = 0; i < n; i++) {
            symmetries.add(s.rotateBy(i * 360 / n));
        }
        if (n % 2 == 0) {
            for (int i = 1; i < n / 2; i++) {
                Collections.swap(s.neighbors, 2 * i, 2 * i + 1);
                String name1 = s.neighbors.get(2 * i + 1).name;
                String name2 = s.neighbors.get(2 * i).name;
                s.neighbors.set(2 * i, new Point(name1, s.neighbors.get(2 * i).x, s.neighbors.get(2 * i).y));
                s.neighbors.set(2 * i + 1, new Point(name2, s.neighbors.get(2 * i + 1).x, s.neighbors.get(2 * i + 1).y));
            }
            for (int i = 0; i < n; i++) {
                symmetries.add(s.rotateBy(i * 360 / n));
            }
        } else {
            for (int i = 1; i < n / 2 + 1; i++) {
                Collections.swap(s.neighbors, 2 * i, 2 * i - 1);
                String name1 = s.neighbors.get(2 * i - 1).name;
                String name2 = s.neighbors.get(2 * i).name;
                s.neighbors.set(2 * i - 1, new Point(name2, s.neighbors.get(2 * i - 1).x, s.neighbors.get(2 * i - 1).y));
                s.neighbors.set(2 * i, new Point(name1, s.neighbors.get(2 * i).x, s.neighbors.get(2 * i).y));
            }
            for (int i = 0; i < n; i++) {
                symmetries.add(s.rotateBy(i * 360 / n));
            }
        }
        return symmetries;
    }
}

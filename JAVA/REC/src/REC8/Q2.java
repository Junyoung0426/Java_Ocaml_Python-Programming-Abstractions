package REC8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Q2 {

    public static int sum(Collection<Integer> ints){
        return ints.stream().reduce(0, (total,x) -> total+x);
        //return ints.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> inList = new ArrayList<>(Arrays.asList(1,2,3,4));
        int res = sum(inList) ;
        System.out.println(res);
    }
}

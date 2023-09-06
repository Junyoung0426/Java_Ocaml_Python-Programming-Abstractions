package REC8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            lst.add(i);
        }
        System.out.println(lst);
        List<Integer> newlst = lst.stream().filter(x-> x>0 &&(x&(x-1))==0 ).collect(Collectors.toList());
        System.out.println(newlst);
    }
}

package REC8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static String shortestString(List<String> strs){
       // return strs.stream().reduce(strs.get(0), (shortest,x) ->x.length() <shortest.length() ?x : shortest);
        return strs.stream().reduce( (shortest,x) ->x.length() <shortest.length() ? x : shortest).orElse("");

    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>(Arrays.asList("abc","a","abcde"));
        System.out.println(shortestString(lst));
    }
}

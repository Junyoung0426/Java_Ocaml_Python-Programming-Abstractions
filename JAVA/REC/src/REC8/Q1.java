package REC8;

import java.util.function.Predicate;

public class Q1 {
    public static boolean compute(final int number) {
        return number > 5 ? true : false;
    }
    public static boolean process(final int number) {
        return number % 3 == 0 ? true : false;
    }


    public static void main1() {
        final int number = 4;
        if (compute(number) && process(number)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
    public static void main2() {
        final int number = 4;
        Predicate<Integer> compute = x ->x >5;
        Predicate<Integer> process = x ->x % 3 ==0 ;
        if (compute.test(number) && process.test(number)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
    public static void main(String[] args){
        main1();
        main2();
    }

}

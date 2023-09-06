import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BijectionGroup {
    // your methods go here
    public static <T> ArrayList<ArrayList<T>> helper(int domain_length,ArrayList<T> domain_lst, ArrayList<ArrayList<T>> res_list) {
        if (domain_length == 0) {
            res_list.add(new ArrayList<>(domain_lst));
        } else {
            for (int i = 0; i < domain_length; i++) {
                Collections.swap(domain_lst, i, domain_length - 1);
                helper( domain_length - 1, domain_lst, res_list);
                Collections.swap(domain_lst, i, domain_length - 1);
            }
        }
        return res_list;
    }

    public static <T> Set<Function<T, T>> bijectionsOf(Set<T> domain) {
        ArrayList<T> domain_list = new ArrayList<>(domain);
        return helper(domain.size(), domain_list, new ArrayList<>())
                .stream()
                .map(list -> (Function<T, T>) t -> list.get(domain_list.indexOf(t)))
                .collect(Collectors.toSet());
    }
    public static <T> Group<Function<T,T>> bijectionGroup(Set<Integer> a_few) {
        Group<Function<T,T>> group = new Group<Function<T,T>>(){
            @Override
            public Function<T, T> binaryOperation(Function<T, T> x, Function<T, T> y) {
                 Function<T,T> function = new Function<T, T>() {
                    @Override
                    public T apply(T t) {
                        return x.apply(y.apply(t));
                    }
                };
                return function;
            }

            @Override
            public Function<T, T> identity() {
                Function<T,T> function = new Function<T, T>() {
                    @Override
                    public T apply(T t) {
                        return t;
                    }
                };
                return function;
            }

            @Override
            public Function<T, T> inverseOf(Function<T, T> ttFunction) {
                Function<T,T> function = new Function<T, T>() {
                    @Override
                    public T apply(T t) {
                        T res =  ttFunction.apply(t);
                        for(int i =1; i < a_few.size()-1;i++){
                           res = ttFunction.apply(res);
                            if(i == a_few.size()-1){
                                break;
                            }
                        }
                        return res;
                    }
                };
                return function;
            }
        };
        return group;
    }



    public static void main(String... args) {
        Set<Integer> a_few = Stream.of(1, 2, 3).collect(Collectors.toSet());
// you have to figure out the data type in the line below
        Set<Function<Integer, Integer>> bijections = bijectionsOf(a_few);
        bijections.forEach(aBijection -> {
            a_few.forEach(n -> System.out.printf("%d --> %d; ", n, aBijection.apply(n)));
            System.out.println();
        });
        Group<Function<Integer, Integer>> g = bijectionGroup(a_few);
        Function<Integer, Integer> f1 = bijectionsOf(a_few).stream().skip(2).findFirst().get();
        Function<Integer, Integer> f2 = g.inverseOf(f1);
        Function<Integer, Integer> id = g.identity();
        System.out.println("f1");
        a_few.forEach(n -> System.out.printf("%d --> %d; ", n, f1.apply(n)));
        System.out.println("\nInverse of f1");
        a_few.forEach(n -> System.out.printf("%d --> %d; ", n, f2.apply(n)));
        System.out.println("\nIdentity");
        a_few.forEach(n -> System.out.printf("%d --> %d; ", n, id.apply(n)));

    }
}
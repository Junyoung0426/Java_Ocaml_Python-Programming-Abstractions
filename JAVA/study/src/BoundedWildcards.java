import java.util.ArrayList;
import java.util.Collection;

public class BoundedWildcards {
    interface Output<T> {
        void print(T t);
    }

    static class OutputImpl<T> implements Output<T> {
        public void print(T t) {
            System.out.println(t.toString());
        }
    }

    static <T> String writeAll(Collection<String> collection, Output<Object> out) {
        String first = null;
        for (String t : collection) {
            if (first == null) first = t;
            out.print(t);
        }
        return (String) first;
    }

    public static void main(String... args) {
        Output<Object> output = new OutputImpl<>();
        Collection<String> strings = new ArrayList<>();
// neither String nor Object is appropriate for the type T
// The collection and the type parameter of output must be the same type
        String s = writeAll(strings, output);
    }
}
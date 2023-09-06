import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class HigherOrderUtils {
    public static interface NamedBiFunction<T, U, R> extends BiFunction<T, U, R> {
        String name();
    }

    public static NamedBiFunction<Double, Double, Double> add = new NamedBiFunction<Double, Double, Double>() {
        @Override
        public String name() {
            return "add";
        }
        @Override
        public Double apply(Double x, Double y) {
            return x + y;
        }
    };

    public static NamedBiFunction<Double, Double, Double> subtract = new NamedBiFunction<Double, Double, Double>() {
        @Override
        public String name() {
            return "minus";
        }
        @Override
        public Double apply(Double x, Double y) {
            return x - y;
        }
    };

    public static NamedBiFunction<Double, Double, Double> multiply = new NamedBiFunction<Double, Double, Double>() {
        @Override
        public String name() {
            return "mult";
        }
        @Override
        public Double apply(Double x, Double y) {
            return x * y;
        }
    };

    public static NamedBiFunction<Double, Double, Double> divide = new NamedBiFunction<Double, Double, Double>() {
        @Override
        public String name() {
            return "div";
        }
        @Override
        public Double apply(Double x, Double y) {
            if (y == 0) {
                throw new ArithmeticException("Division by zero is not possible");
            }
            return x / y;
        }
    };

    public static <T> T zip(List<T> args, List<? extends  BiFunction<T, T, T>> bifunctions) {
        if (bifunctions.size() != args.size() - 1) {
            throw new IllegalArgumentException("The number of bifunction elements and the number of argument elements do not match up as required.");
        }
        for (int i = 0; i < bifunctions.size(); i++) {
            T res = bifunctions.get(i).apply(args.get(i), args.get(i + 1));
            args.set(i + 1, res);
        }
        return args.get(args.size() - 1);
    }

    public static void main(String... args) {
        List<Double> numbers = Arrays.asList(-0.5, 2d, 3d, 0d, 4d); // documentation example
        List<NamedBiFunction<Double, Double, Double>> operations = Arrays.asList(add, multiply, add, divide);
        Double d = zip(numbers, operations); // expected correct value: 1.125
        System.out.println(d);
// different use case, not with NamedBiFunction objects
        List<String> strings = Arrays.asList("a", "n", "t");
// note the syntax of this lambda expression
        BiFunction<String, String, String> concat = (s, t) -> s + t;
        String s = zip(strings, Arrays.asList(concat, concat)); // expected correct value: "ant"
        System.out.println(s);
    }
}
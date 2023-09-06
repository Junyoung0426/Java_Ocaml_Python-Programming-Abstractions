import java.util.Arrays;
import java.util.List;

public class lazystrams {static String toUpper(final String name) {
    System.out.println("to uppercase: " + name);
    return name.toUpperCase();
}

    public static void main(final String[] args) {
        List<String> names = Arrays.asList("brad","kate","kim");

        final String aShortName =
                names.stream()

                        .filter(n -> n.length() == 3)
                        .map(lazystrams::toUpper)
                        .findFirst().orElse("N/A");

        System.out.println(aShortName);
    }
}

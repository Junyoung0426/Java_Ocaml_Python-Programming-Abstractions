public class any {
    public static void main(String[] args) {
        String[] strings = {"foo"};
        Object[] objects = strings;
        objects[0] = new Integer(5);

        System.out.print(objects);
    }
}


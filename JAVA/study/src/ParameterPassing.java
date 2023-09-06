public class ParameterPassing {

    static int r = 0;

    static int add(int x, int y) {
        return r + x + y;
    }

    static int setR() {
        r = 3;
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(add(setR(), 2));
    }
}
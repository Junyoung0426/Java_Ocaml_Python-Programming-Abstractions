package arithmetic;

public class PlusOrMinusOne {
    public int val;
    public PlusOrMinusOne(int val) {
        this.val =val;
    }
    public int getValue(){
        return this.val;
    }
    public static PlusOrMinusOne[] values(){
        return new PlusOrMinusOne[]{new PlusOrMinusOne(1),new PlusOrMinusOne(-1)};
    }
    public String toString(){
        return String.valueOf(this.val);
    }

}

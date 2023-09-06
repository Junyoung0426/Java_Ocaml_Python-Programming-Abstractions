package arithmetic;

import core.Group;

public class FiniteGroupOfOrderTwo implements Group<PlusOrMinusOne> {

    public PlusOrMinusOne binaryOperation(PlusOrMinusOne u , PlusOrMinusOne v){
        return new PlusOrMinusOne(u.getValue() * v.getValue());
    }
    public PlusOrMinusOne identity() {
        return new PlusOrMinusOne(1);
    }

    @Override
    public PlusOrMinusOne inverseOf(PlusOrMinusOne u) {
        return new PlusOrMinusOne(u.getValue());
    }
    @Override
    public PlusOrMinusOne exponent(PlusOrMinusOne plusOrMinusOne, int k) {
        return Group.super.exponent(plusOrMinusOne, k);
    }

}

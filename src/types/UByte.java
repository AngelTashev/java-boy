package types;

import exceptions.UByteNotInRangeException;
import exceptions.UShortNotInRangeException;

public class UByte implements UnsignedIntType {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 255;

    private int value;

    public UByte(int value) {
        setValue(value);
    }

    @Override
    public void setValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new UByteNotInRangeException();
        }
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

}

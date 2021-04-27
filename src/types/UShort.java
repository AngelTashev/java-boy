package types;

import exceptions.UShortNotInRangeException;

public class UShort implements UnsignedIntType {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 65535;

    private int value;

    public UShort(int value) {
        setValue(value);
    }

    @Override
    public void setValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new UShortNotInRangeException();
        }
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

}

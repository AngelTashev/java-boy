package cpu;

import types.UByte;
import types.UShort;
import types.UnsignedIntType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Registers {

    private final Map<String, UnsignedIntType> registers;

    Registers() {

        this.registers = new HashMap<>() {{
            // 8-bit registers
            put("a", new UByte(0));
            put("b", new UByte(0));
            put("c", new UByte(0));
            put("d", new UByte(0));
            put("e", new UByte(0));
            put("h", new UByte(0));
            put("l", new UByte(0));
            put("f", new UByte(0));

            // 16-bit registers
            put("pc", new UShort(0));
            put("sp", new UShort(0));

            // Time clocks
            put("m", new UByte(0));
            put("t", new UByte(0));
        }};

    }

    Map<String, UnsignedIntType> getRegisters() {
        return Collections.unmodifiableMap(registers);
    }

    int getRegister(String key) {
        return this.getRegisters().get(key).getValue();
    }

    void setRegister(String key, int value) {
        this.getRegisters().get(key).setValue(value);
    }
}

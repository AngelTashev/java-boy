package cpu;

import types.UnsignedIntType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CPU {

    private final Registers registers;

    public CPU() {
        this.registers = new Registers();

        setReg("b", 100);
        setReg("l", 100);
    }

    /** Opcode table **/
    public void opcode(String opcode) {

        // ADD
        switch (opcode){
            case "80": addToA("b"); break;
            case "81": addToA("c"); break;
            case "82": addToA("d"); break;
            case "83": addToA("e"); break;
            case "84": addToA("h"); break;
            case "85": addToA("l"); break;
            case "86": addToA("(HL))"); break;
            case "87": addToA("a"); break;
        }
    }

    private void addToA(String regToAdd) {

        final int sumReg = getReg("a") + getReg(regToAdd);

        try {
            setReg("a", sumReg);
            setFlag(0x00);
        } catch (RuntimeException error) {
            setReg("a", sumReg & 255);
            setFlag(0x10);
        }

        setTime(1, 4);
    }

    private void setTime(int m, int t) {
        setReg("m", m);
        setReg("t", t);
    }

    private void setFlag(int value) {
        setReg("f", value);
    }

    private int getReg(String key) {
        return this.registers.getRegister(key);
    }

    private void setReg(String key, int value) {
        this.registers.setRegister(key, value);
    }

    public Map<String, UnsignedIntType> getRegisters() {
        return this.registers.getRegisters();
    }
}

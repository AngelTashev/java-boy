package cpu;

import memory.Memory;
import types.UnsignedIntType;

import java.util.Map;

public class CPU {

    private final Registers registers;

    private final Memory memory;

    public CPU() {
        this.registers = new Registers();
        this.memory = new Memory();

        setReg("b", 100);
        setReg("l", 100);

    }

    /** Opcode table **/
    public void opcode(String opcode, String value) {

        // ADD
        switch (opcode){
            case "00": noOperation(); break;
            case "10": stop(); break;

            case "77":

            case "80": addRegToA("b"); break;
            case "81": addRegToA("c"); break;
            case "82": addRegToA("d"); break;
            case "83": addRegToA("e"); break;
            case "84": addRegToA("h"); break;
            case "85": addRegToA("l"); break;
            case "86": addRegToA("(HL))"); break; // TODO
            case "87": addRegToA("a"); break;

            case "C6": addD8ToA(value);

            default:
                // In case an invalid instruction is passed -> no error should be shown
                System.out.println("No instruction set");
                break;
        }
    }

    private void noOperation() {
        setTime(1, 4);
    }

    private void stop() {
        setTime(2, 4); // TODO
    }

    private void addRegToA(String regToAdd) {
        final int sumReg = getReg("a") + getReg(regToAdd);
        sum(sumReg);
        setTime(1, 4);
    }

    private void addD8ToA(String d8) {
        int sumReg= getReg("a") + Integer.parseInt(d8);
        sum(sumReg);
        setTime(2, 4);
    }

    private void sum(int sumReg) {
        try {
            setReg("a", sumReg);
            setFlag(0x00);
        } catch (RuntimeException error) {
            setReg("a", sumReg & 255);
            setFlag(0x10);
        }
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

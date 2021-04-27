package cpu;

public class CPU {

    private final Registers registers;

    public CPU() {
        this.registers = new Registers();
    }

    public void ADDr_e() {
        final int sum_a_e = getReg("a") + getReg("e");

        try {
            setReg("a", sum_a_e);
            setFlag(0x00);
        } catch (RuntimeException error) {
            setReg("a", sum_a_e & 255);
            setFlag(0x10);
        }
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
}

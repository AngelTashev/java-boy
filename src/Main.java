import cpu.CPU;
import utils.DebugWindow;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU();
        DebugWindow debugWindow = new DebugWindow();

        cpu.opcode("80");
        cpu.opcode("85");
        cpu.opcode("87");

        debugWindow.showRegisters(cpu.getRegisters());
    }

}

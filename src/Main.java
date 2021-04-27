import cpu.CPU;
import memory.Memory;
import utils.DebugWindow;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        DebugWindow debugWindow = new DebugWindow();

        cpu.opcode("80");
//        cpu.opcode("85");
//        cpu.opcode("87");

        memory.write(0x4000, 120);


//        debugWindow.showRegisters(cpu.getRegisters());
        debugWindow.showMemoryAddress(0x4000, memory.read(0x4000));
    }

}

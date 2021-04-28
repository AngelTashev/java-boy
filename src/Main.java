import assembler.Assembler;
import cpu.CPU;
import memory.Memory;
import utils.DebugWindow;

import java.io.FileNotFoundException;

public class Main {

    private static Assembler assembler;

    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        DebugWindow debugWindow = new DebugWindow();
        try {
            assembler = new Assembler("src/code/test.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        assembler.readFile();



//        cpu.opcode("80", null);
//        cpu.opcode("85", null);
//        cpu.opcode("87", null);


//        debugWindow.showRegisters(cpu.getRegisters());
//        debugWindow.showMemoryAddress(0x4000, memory.read(0x4000));
    }

}

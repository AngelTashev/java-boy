package memory;

import types.UByte;

public class Memory {

    /**
     * [0000-3FFF] Cartridge ROM, bank 0
     * [0000-00FF] BIOS
     * [0100-014F] Cartridge header
     * [4000-7FFF] Cartridge ROM, other banks
     * [8000-9FFF] Graphics RAM
     * [A000-BFFF] Cartridge (External) RAM
     * [C000-DFFF] Working RAM
     * [E000-FDFF] Working RAM (shadow)
     * [FE00-FE9F] Graphics: sprite information
     * [FF00-FF7F] Memory-mapped I/O
     * [FF80-FFFF] Zero-page RAM
     * **/

    private static final int MEMORY_SIZE = 65536;

    private final UByte[] memory;

    public Memory() {
        this.memory = new UByte[MEMORY_SIZE];
        for (int i = 0; i < this.memory.length; i++) {
            this.memory[i] = new UByte(0);
        }


        // TESTS

        this.memory[0x4000].setValue(200);
    }

    public void write(int address, int value) {
        this.memory[address].setValue(value);
    }

    public int read(int address) {
        return this.memory[address].getValue();
    }

}

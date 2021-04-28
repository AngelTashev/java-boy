package assembler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assembler {

    private final Scanner fileReader;

    private final File codeFile;

    public Assembler(String filePath) throws FileNotFoundException {
        this.codeFile = new File(filePath);
        this.fileReader = new Scanner(codeFile);
    }

    public void readFile() {
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine().trim();
            if (line.equals("")) continue;

            readInstruction(line);
        }
    }

    private void readInstruction(String instruction) {
        String opcode = "00";

        String[] code = instruction.split("\\s+");

        if (code.length > 1) {
            String[] codeParams = code[1].split(",");
            if (codeParams.length > 1) {

            } else {

            }
        }
    }

}

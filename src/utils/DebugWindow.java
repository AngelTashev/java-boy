package utils;

import types.UnsignedIntType;

import javax.swing.*;
import java.util.Map;

public class DebugWindow {

    public void showRegisters(Map<String, UnsignedIntType> registers) {
        StringBuilder registerInfo = new StringBuilder();

        registers.entrySet().forEach(x -> registerInfo
                .append(x.getKey() + ": " + x.getValue().getValue())
                .append(System.lineSeparator())
        );

        JOptionPane.showMessageDialog(null, registerInfo.toString());
    }

    public void showMemoryAddress(int address, int value) {

        JOptionPane.showMessageDialog(null, String.format("0x%04X: %d", address, value));
    }


}

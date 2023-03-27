package com.example.numeralconvertergui;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class Convert {
    // Your conversion function(s) go here
    @NotNull
    @Contract(pure = true)
    static String doconvert(String inputNum, String fromNumeralSystem, String toNumeralSystem) {
        int fromBase = getBase(fromNumeralSystem);
        int toBase = getBase(toNumeralSystem);
        BigInteger number = new BigInteger(inputNum, fromBase);
        return number.toString(toBase);
    }
    private static int getBase(String numeralSystem) {
        switch (numeralSystem) {
            case "Binary":
                return 2;
            case "Decimal":
                return 10;
            case "Octal":
                return 8;
            case "Hexadecimal":
                return 16;
            default:
                throw new UnsupportedOperationException("Invalid numeral system: " + numeralSystem);
        }
    }
}

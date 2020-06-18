package ru.daleshin.spring.service;

import java.io.PrintStream;
import java.util.Scanner;

public class InputOutputServiceImpl implements InputOutputService {
    private final Scanner scanner;
    private final PrintStream printStream;
    private final Scanner scannerConsole;
    
    public InputOutputServiceImpl(Scanner scanner, PrintStream printStream, Scanner scannerConsole) {
        this.scanner = scanner;
        this.printStream = printStream;
        this.scannerConsole = scannerConsole;
    }
    
    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
    
    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
    
    @Override
    public void print(String str) {
        printStream.print(str);
    }

    @Override
    public void println(String str) {
        printStream.println(str);
    }
    
    @Override
    public String nextLineConsole() {
        return scannerConsole.nextLine();
    }
    
}

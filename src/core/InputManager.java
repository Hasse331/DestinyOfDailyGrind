package core;

import java.util.Scanner;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Closing scanner...");
            scanner.close();  
        }));
    }

    public static Scanner getScanner() {
        return scanner;
    }
}

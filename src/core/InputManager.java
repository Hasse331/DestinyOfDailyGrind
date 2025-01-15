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

    public static void continueInput() {
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
    }

    public static void continueInputDouble() {
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        scanner.nextLine();
    }
}

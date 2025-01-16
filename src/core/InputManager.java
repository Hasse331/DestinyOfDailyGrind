package core;

import java.util.Random;
import java.util.Scanner;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            scanner.close();  
        }));
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Double getRandomDouble() {
        double randomDouble = random.nextDouble();
        return randomDouble;
    }

    public static int getRandomInt(int bound) {
        int randomInt = random.nextInt(bound);
        return randomInt;
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

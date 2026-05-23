package utils;

import java.io.Console;
//import java.io.IOException;

public class ConsolUtils {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * pause the program for a given amount of time
     * @param millisecond
     */
    public static void pause(long millisecond)
    {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * clears the screen
     */
    public static void clearScreen() {
    try {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public  static String colorize(String text, String color)
    {
        return color + text + ANSI_RESET;

    }

    public static void waitForEnter() {
        Console c = System.console();
        if (c != null) {
            c.format("\n\n\nPress ENTER to proceed.\n");
            c.readLine();
        }
    }

    public static String line(int len) {
        String line ="";
        for (int i = 0; i < len; i++) {
            line += "-";
        }
        return line;
    }
}
package dev.mhproject.service;

public class TerminalClearService {

    /**
     * Identifica que terminar esta usando el usuario
     */
    public static void clearConsole() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.printf("\033c");
            }
        } catch (Exception e) {
            System.err.println("Error al limpiar la consola: " + e.getMessage());
        }
    }
}

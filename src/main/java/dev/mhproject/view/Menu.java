package dev.mhproject.view;
import dev.mhproject.service.ConversionService;
import dev.mhproject.service.TerminalClearService;
import java.util.Scanner;
import static dev.mhproject.view.BannerMHProject.banner;
import static dev.mhproject.view.ColorsAndEmojis.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ConversionService conversionService = new ConversionService();

    String base, chance, cant, cont;
    boolean flag;

    public void continuar() {
        System.out.println("¿Deseas continuar? (S/N): ");
        cont = sc.nextLine();
        if (cont.equalsIgnoreCase("N")) {
            flag = false;
        } else if (cont.equalsIgnoreCase("S")) {
            flag = true;
        } else {
            System.out.println( AMARILLO + ADVERTENCIA + "Opcion no valida.");
            continuar();
        }
    }

    public void showMenu () {
        System.out.flush();
        flag = true;
        int opc = -1;

        do {
            TerminalClearService.clearConsole();
            banner();

            System.out.println(
                    VERDE + """
                -----------------------------------
                \t1) Consultar moneda
                \t2) Consultar historial
                \t0) Salir
                -----------------------------------
                """ + RESET);

            System.out.println("Ingrese su opcion: ");

            if (sc.hasNextInt()) {
                opc = sc.nextInt();
                sc.nextLine();

            } else {
                System.out.println(ROJO + ADVERTENCIA + "Opcion no valida, vuelve a intentarlo" + RESET);
            }

            if (opc == 0) {
                break;
            } else if (opc == 1) {
                TerminalClearService.clearConsole();
                banner();
                convertCurrency();
            } else if (opc == 2) {
                TerminalClearService.clearConsole();
                banner();
                System.out.println("opcion 2");
            } else {
                TerminalClearService.clearConsole();
                banner();
                System.out.println(" ");
                System.out.println(AMARILLO + ADVERTENCIA + "Opcion no valida" + RESET);
            }

            continuar();
        } while (flag);
        sc.close();
    }

    public void convertCurrency() {
        try {

            System.out.println("Moneda de partida");
            base = sc.nextLine().toUpperCase();

            System.out.println("Cantidad");
            cant = sc.nextLine().toLowerCase();

            System.out.println("Moneda a comparar");
            chance = sc.nextLine().toUpperCase();

            TerminalClearService.clearConsole();
            banner();

            conversionService
                    .currencyMappingConversor(
                            base,
                            chance,
                            cant);
        } catch (RuntimeException e) {
            System.out.println("\n " + ERROR + ROJO + " Opcion no valida, \n" +
                    " vuelve a intentarlo.\n" + RESET);
            System.out.println(e.getMessage());
        }
    }
}
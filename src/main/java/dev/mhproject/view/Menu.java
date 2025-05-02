package dev.mhproject.view;

import dev.mhproject.service.ApiService;
import dev.mhproject.service.ConversionService;
import dev.mhproject.service.TerminalClearService;
import dev.mhproject.service.ValidadorService;

import java.io.IOException;
import java.util.Scanner;

import static dev.mhproject.view.BannerMHProject.banner;
import static dev.mhproject.view.ColorsAndEmojis.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ConversionService conversionService = new ConversionService();
    ValidadorService validar = new ValidadorService();
    ApiService api = new ApiService();

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
            System.out.println(ADVERTENCIA + "Opcion no valida.");
            continuar();
        }
    }

    public void showMenu () {
        System.out.flush();

        do {
            flag = false;
            int opc = -1;

            TerminalClearService.clearConsole();
            banner();
            do {

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
                    TerminalClearService.clearConsole();
                    banner();
                    flag = false;

                } else {
                    System.out.println(ROJO + ADVERTENCIA + "Opcion no valida, vuelve a intentarlo" + RESET);
                }

            } while (flag);

            switch (opc) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    convertCurrency();
                    break;
                case 2:
                    System.out.println("opcion 2");
                default:
                    System.out.println(ADVERTENCIA + AMARILLO + "Opcion no valida" + RESET);
                    sc.next();
            }


        } while (flag);
        sc.close();
    }

    public void convertCurrency() {
        try {
            System.out.println("");

            do {
                TerminalClearService.clearConsole();
                banner();

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

                continuar();

            } while (flag);

        } catch (IOException | InterruptedException e) {
            System.out.println("\n " + ERROR + ROJO + " Opcion no valida, \n" +
                    " vuelve a intentarlo.\n" + RESET);
            System.out.println(e.getMessage());
        }
    }
}

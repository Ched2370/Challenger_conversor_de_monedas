package dev.mhproject.view;

import dev.mhproject.service.ConversionService;
import dev.mhproject.service.ValidadorService;

import java.util.Scanner;

import static dev.mhproject.view.ColorsAndEmojis.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ConversionService conversionService = new ConversionService();
    ValidadorService validar = new ValidadorService();

    String base, chance, cant;
    boolean flag;

    public void continuar() {
        System.out.println("desea continuar? S/N");
        String opc = sc.nextLine();

        if (!opc.equalsIgnoreCase("s")) {
            flag = false;
        }
    }

    public void showMenu () {
        flag = true;
        do {
            System.out.println(
                    VERDE + """
                -----------------------------------
                \t1) Consultar moneda
                \t2) Consultar historial
                \t0) Salir
                -----------------------------------
                """ + RESET);
            int opc = -1;

            do {
                System.out.println("Ingrese su opcion: ");
                if (sc.hasNextInt()) {
                    opc = sc.nextInt();
                    sc.nextLine();
                    if (opc >= 0 && opc < 4) {
                        break;
                    } else {
                        System.out.println(ROJO + ADVERTENCIA + "Opcion no valida, vuelve a intentarlo" + RESET);
                    }
                } else {
                    System.out.println(ROJO + ADVERTENCIA + "Opcion no valida, vuelve a intentarlo" + RESET);
                    sc.next();
                }

            } while (true);

            switch (opc) {
                case 0:
                    System.out.println("Vuelva pronto!!! " + SALUDO);
                    flag = false;
                    break;
                case 1:
                    convertCurrency();
                    break;
                case 2:
                    System.out.println("opcion 2");
            }

        } while (flag);
        sc.close();
    }

    public void convertCurrency() {
        try {
            System.out.println("");// colocar valiraciones a este
            flag = true;

            do {
                flag = true;

                System.out.println("Moneda de partida");
                base = sc.nextLine().toUpperCase();

                System.out.println("Cantidad");
                cant = sc.nextLine().toLowerCase();

                System.out.println("Moneda a comparar");
                chance = sc.nextLine().toUpperCase();

                conversionService
                        .currencyMappingConversor(
                                base,
                                chance,
                                cant);
            } while (!flag);

            continuar();

        } catch (Exception e) {
            System.out.println("\n " + ERROR + ROJO + " Opcion no valida, \n" +
                    " vuelve a intentarlo.\n" + RESET);
            System.out.println(e.getMessage());
            System.out.println("Presiona Enter para continuar...");
            sc.nextLine();
        }
    }
}

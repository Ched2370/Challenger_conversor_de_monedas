package dev.mhproject.view;

import dev.mhproject.model.CurrencyModel;

import java.util.InputMismatchException;
import java.util.Scanner;

import static dev.mhproject.view.ColorsAndEmojis.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    int opc = -1;

    /**
     * Realiza la conversion de las monedas
     * @param currency
     * @param multiplier
     */
    public void conversionCurrency (CurrencyModel currency, float multiplier) {

    }

    public void showMenu () {
        do {
            System.out.println(
                VERDE + """
                --------------------------
                1) Dolar => Peso Argentino
                2) Peso Argentino => Dolar
                3) Dolar => Real Brasileño
                4) Real Brasileño => Dolar
                5) Dolar => Peso Colombiano
                6) Peso Colombiano => Dolar
                7) Salir
                ---------------------------
                """ + RESET);

            try {

                System.out.printf("Elija una opcion: ");
                opc = sc.nextInt();
                System.out.println("");

                switch (opc) {
                    case 1:
                        System.out.println("Dolar => Peso Argentino");
                        break;
                    case 2:
                        System.out.println("Peso Argentino => Dolar");
                        break;
                    case 3:
                        System.out.println("Dolar => Peso Brasilero");
                        break;
                    case 4:
                        System.out.println("Dolar => Peso Brasilero");
                        break;
                    case 5:
                        System.out.println("Dolar => Peso Brasilero");
                        break;
                    case 6:
                        System.out.println("Dolar => Peso Brasilero");
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println(AMARILLO + """
                                Has seleccionado una opcion 
                                incorrecta, vuelve a 
                                intentarlo.
                                """ + RESET);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ROJO + "Opcion no valida, \n" +
                        "vuelve a intentarlo.\n" + RESET);
                sc.nextLine();
            }
        } while (opc != 7);

        sc.close();

    }
}

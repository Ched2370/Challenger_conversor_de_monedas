package dev.mhproject.view;

import static dev.mhproject.view.ColorsAndEmojis.*;


public class BannerMHProject {

    public static void banner(){
        System.out.println(AZUL + """
                ****************************************************
                    __  _____  ______               _           __\s
                   /  |/  / / / / __ \\_________    (_)__  _____/ /_
                  / /|_/ / /_/ / /_/ / ___/ __ \\  / / _ \\/ ___/ __/
                 / /  / / __  / ____/ /  / /_/ / / /  __/ /__/ /_ \s
                /_/  /_/_/ /_/_/   /_/   \\____/_/ /\\___/\\___/\\__/ \s
                                             /___/                \s
                ****************************************************
                """ + "\t\t\t " + CONVERSION +
                SUBRAYADO + NEGRITA + "CONVERSOR DE MONEDAS" + RESET + CONVERSION);
        try {
            Thread.sleep(3000);
            System.out.println(CONVERSION + " Bienvenido al Conversor de Monedas MH Project");
            Thread.sleep(2500);
            System.out.println(MUNDO + " Convierte monedas de forma simple y rápida.");
            Thread.sleep(2500);
            System.out.println(HERRAMIENTA + " Basado en tasas actualizadas vía API.");
            Thread.sleep(2500);
            System.out.println(CARGANDO + " Presiona cualquier tecla para comenzar...");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

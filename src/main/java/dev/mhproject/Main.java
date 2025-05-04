package dev.mhproject;

import dev.mhproject.service.ApiService;
import dev.mhproject.service.TerminalClearService;
import dev.mhproject.view.BannerMHProject;
import dev.mhproject.view.Menu;

import javax.swing.*;
import java.io.IOException;

import static dev.mhproject.view.BannerMHProject.banner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        TerminalClearService.clearConsole();
        new JOptionPane("Hola");

        if(args.length > 0) {
            String hola = args[0];
            System.out.println(hola);
        } else {
            System.out.println("No funsiono, jajajaja");
        }
        BannerMHProject presentacion = new BannerMHProject();
        ApiService api = new ApiService();
        Menu menu = new Menu();
        // consumimos api
        api.loadExchangeRates();
        // cargamos banner
        banner();
        // bienvenida
        presentacion.welcome();
        // llamamos al menu
        menu.showMenu();
    }
}
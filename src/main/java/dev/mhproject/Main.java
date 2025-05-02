package dev.mhproject;

import dev.mhproject.service.ApiService;
import dev.mhproject.service.ConversionService;
import dev.mhproject.service.TerminalClearService;
import dev.mhproject.view.BannerMHProject;
import dev.mhproject.view.Menu;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        TerminalClearService.clearConsole();
        BannerMHProject presentacion = new BannerMHProject();
        ApiService api = new ApiService();
        ConversionService conversionService = new ConversionService();
        Menu menu = new Menu();
        // consumimos api
        api.loadExchangeRates();
        // cargamos banner
        presentacion.banner();
        // bienvenida
        presentacion.welcome();
        // llamamos al menu
        menu.showMenu();
    }
}
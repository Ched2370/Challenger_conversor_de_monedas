package dev.mhproject;

import dev.mhproject.service.ApiService;
import dev.mhproject.view.BannerMHProject;
import dev.mhproject.view.Menu;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BannerMHProject presentacion = new BannerMHProject();
        ApiService api = new ApiService();
        Menu menu = new Menu();
        presentacion.banner();
        api.loadExchangeRates();
        menu.showMenu();
    }
}
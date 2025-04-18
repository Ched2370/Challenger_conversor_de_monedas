package dev.mhproject;

import dev.mhproject.model.dto.CurrencyDTO;
import dev.mhproject.service.ConversionService;
import dev.mhproject.view.BannerMHProject;
import dev.mhproject.view.Menu;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BannerMHProject presentacion = new BannerMHProject();
        Menu menu = new Menu();

        presentacion.banner();

        ConversionService conversionService = new ConversionService();
        menu.showMenu();
    }
}
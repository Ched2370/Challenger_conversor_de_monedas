package dev.mhproject;

import dev.mhproject.service.ApiService;
import dev.mhproject.view.BannerMHProject;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BannerMHProject presentacion = new BannerMHProject();
        presentacion.banner();
        ApiService api = new ApiService();
        System.out.println(api.obtenerTasas("ARS"));
    }
}
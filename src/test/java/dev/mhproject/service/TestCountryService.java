package dev.mhproject.service;

public class TestCountryService {
    public static void main(String[] args) {
        CountryService cs = new CountryService();

        System.out.println(cs.loadCountries());
        System.out.println("Cantidad de paises " + cs.loadCountries().stream().count());
    }
}

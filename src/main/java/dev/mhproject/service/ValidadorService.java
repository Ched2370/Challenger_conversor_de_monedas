package dev.mhproject.service;

import dev.mhproject.model.entitiy.CountryModel;
import dev.mhproject.model.entitiy.CurrencyModel;

import java.util.regex.Pattern;

public class ValidadorService {

    CurrencyModel currencyModel = new CurrencyModel();
    CountryModel countryModel = new CountryModel();

    public boolean validarCurrency (String currency){
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar una moneda de cambio");
        }

        // boolean foundInCountry = countryModel.getName().contains(currency);
        boolean foundInCurrency = currencyModel.getCodeBase().contains(currency);

        if (!foundInCurrency) {
            throw new IllegalArgumentException("No se ha encontrado el país o el código.");
        }

        return true;
    }

    public boolean validarFloat(String currency) {
        String regex = "^-?\\d+(\\.\\d+)?$";
        return Pattern.matches(regex, currency);
    }
}

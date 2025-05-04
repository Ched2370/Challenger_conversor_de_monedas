package dev.mhproject.service;

import dev.mhproject.model.dto.CountryDTO;
import dev.mhproject.model.dto.CurrencyDTO;
import dev.mhproject.model.entitiy.CurrencyModel;

import java.io.IOException;
import java.util.List;

import static dev.mhproject.view.ColorsAndEmojis.*;

public class ConversionService {
    ApiService api = new ApiService();
    CountryService cs = new CountryService();
    CurrencyModel model = new CurrencyModel();


    public CurrencyModel currencyMappingConversor(String codeBase, String otherCode, String conversor) {
        try {

            CurrencyDTO currencyDTO = api.loadExchangeRates();
            List<CountryDTO> countryDTOs = cs.loadCountries();

            String upperCodeBase = codeBase.toUpperCase();
            String upperOtherCode = otherCode.toUpperCase();

            // Obtener los precios de las conversiones
            float priceBase = currencyDTO.conversion().get(upperCodeBase);
            float otherPrice = currencyDTO.conversion().get(upperOtherCode);

            model.setCodeBase(upperCodeBase);
            model.setPriceBase(priceBase);
            model.setOtherCode(upperOtherCode);
            model.setOtherPrice(otherPrice);
            model.setDate(currencyDTO.last_update());

            for (CountryDTO country : countryDTOs) {
                if (country.code().equals(upperCodeBase)) {
                    model.setCountryBase(country.country());
                }
                if (country.code().equals(upperOtherCode)) {
                    model.setOtherCountry(country.country());
                }
            }

            String sinComa = conversor.replace(",", ".");
            conversion(model, Float.parseFloat(sinComa));

            return model;
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(ROJO + ERROR + "Valor inexistente." + RESET);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void conversion (CurrencyModel model, float cant) {

        float otherPrice = model.getOtherPrice() / model.getPriceBase();

        int parteEntera = (int) cant;
        int parteDecimal = (int) ((cant - parteEntera) * 10000);

        System.out.printf(
                "\n" + VERDE +
                        "***********************************\n" +
                        " %-2s\n (%-2s) %10s\n" +
                        "-----------------------------------\n" +
                        " %-2s\n (%-2s) %10s\n" +
                        " Ultima actualizacion: %s" +
                        VERDE +
                        "***********************************\n\n" + RESET,
                model.getCountryBase(), model.getCodeBase() , CIAN + parteEntera + AMARILLO + "." +
                        String.format("%04d", parteDecimal) + VERDE,
                model.getOtherCountry(), model.getOtherCode() , CIAN + (int)(otherPrice * cant) + AMARILLO + "." +
                        String.format("%04d", (int)((otherPrice * cant - (int)(otherPrice * cant)) * 10000)) + VERDE,
                java.time.Instant.ofEpochSecond(model.getDate())
                        .atZone(java.time.ZoneId.systemDefault())
                        .toLocalDate()
                        .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy\n")
                                .withLocale(java.util.Locale.forLanguageTag("es")))
        );
    }
}

package dev.mhproject.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.mhproject.model.dto.CountryDTO;
import dev.mhproject.model.entitiy.CountryModel;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class CountryService {

    public List<CountryDTO> loadCountries() {
        try (InputStream is = CountryService.class.getClassLoader().getResourceAsStream("currencies.json")) {
            if (is == null) {
                throw new RuntimeException("El archivo 'currencies.json' no se encontró.");
            }
            InputStreamReader reader = new InputStreamReader(is);

            Type listType = new TypeToken<List<CountryDTO>>() {}.getType();
            List<CountryDTO> countries = new Gson().fromJson(reader, listType);
            return countries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

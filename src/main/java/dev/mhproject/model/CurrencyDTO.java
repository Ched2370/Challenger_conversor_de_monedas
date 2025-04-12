package dev.mhproject.model;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public record CurrencyDTO(
        @SerializedName("conversion_rates") ConversionRates conversion,
        @SerializedName("time_last_update_unix") long last_update) {

    public record ConversionRates(
            @SerializedName("USD") float usd,
            @SerializedName("ARS") float ars,
            @SerializedName("BRL") float brl,
            @SerializedName("BOB") float bob,
            @SerializedName("COP") float cop) {
        @Override
        public String toString() {
            return "{" +
                    "\n usd=" + usd +
                    ",\n ars=" + ars +
                    ",\n brl=" + brl +
                    ",\n bob=" + bob +
                    ",\n cop=" + cop +
                    "\n}";
        }
    }

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "\nconversion: " + conversion +
                ",\nlast_update: " + Instant.ofEpochSecond(last_update)
                .atZone(ZoneId.systemDefault())
                .toLocalDate() +
                "\n}";
    }
}

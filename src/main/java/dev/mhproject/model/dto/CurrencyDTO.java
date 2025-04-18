package dev.mhproject.model.dto;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Map;


public record CurrencyDTO(
        @SerializedName("conversion_rates") Map<String, Float> conversion,
        @SerializedName("time_last_update_unix") long last_update) {

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

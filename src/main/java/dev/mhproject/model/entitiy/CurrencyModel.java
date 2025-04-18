package dev.mhproject.model.entitiy;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyModel {
    private String codeBase;
    private String countryBase;
    private String otherCode;
    private String otherCountry;
    private float priceBase;
    private float otherPrice;
    private long date;

    @Override
    public String toString() {
        return "CurrencyModel{" +
                "\nPais='" + countryBase + '\'' +
                "\ncodeBase='" + codeBase + '\'' +
                ",\npriceBase=" + priceBase +
                ",\nPais='" + otherCountry + '\'' +
                ",\notherCode='" + otherCode + '\'' +
                ",\notherPrice=" + otherPrice +
                ",\ndate=" + date +
                "\n}";
    }

}

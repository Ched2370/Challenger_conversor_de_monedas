package dev.mhproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyModel extends PaisModel implements Comparable<CurrencyModel>{
    private String code;
    private float price;

    @Override
    public int compareTo(CurrencyModel otherCurrency) {
        return 0;
    }
}

package dev.mhproject.model.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryModel {
    protected String code;
    protected String name;
    protected String country;

    @Override
    public String toString() {
        return "{" +
                "\n code='" + code + '\'' +
                ",\n name='" + name + '\'' +
                ",\n country='" + country + '\'' +
                "\n}\n";
    }
}

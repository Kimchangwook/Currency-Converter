package myproject.currency_converter;

import lombok.Data;

@Data
public class Currency {
    private String currencyCode;
    private String currencyExplanation;

    public Currency(String currencyCode, String currencyExplanation) {
        this.currencyCode = currencyCode;
        this.currencyExplanation = currencyExplanation;
    }
}

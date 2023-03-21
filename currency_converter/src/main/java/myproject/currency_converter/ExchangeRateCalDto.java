package myproject.currency_converter;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ExchangeRateCalDto {
    private String sourceCurrency;
    private String targetCurrency;
    @NotNull(message = "Please enter a valid value!")
    @Positive(message = "Please enter a valid value!")
    @NumberFormat(pattern = "###,###.##")
    private Double amount;
    @NumberFormat(pattern = "###,###.##")
    private Double result;

    public ExchangeRateCalDto(String sourceCurrency, String targetCurrency, Double amount, Double result) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.result = result;
    }
}

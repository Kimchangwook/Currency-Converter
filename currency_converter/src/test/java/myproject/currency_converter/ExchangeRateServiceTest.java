package myproject.currency_converter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ExchangeRateServiceTest {
    ExchangeRateService exchangeRateService = new ExchangeRateService();

    @Test
    public void test() throws IOException {
        ExchangeRateCalDto dto = new ExchangeRateCalDto("usd", "krw", 100.0, null);
        double result = exchangeRateService.getExchangeRate(dto);

        //Assertions.assertThat(result).isEqualTo(132064.0384);
    }

    @Test
    public void currenciesTest() {
        List<String> currencies = Stream.of(Currencies.values())
                .map(Currencies::name)
                .collect(Collectors.toList());
        for (String currency : currencies) {
            System.out.println(currency);
        }
    }



}
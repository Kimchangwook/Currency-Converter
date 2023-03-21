package myproject.currency_converter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReturnCurrenciesListTest {

    ReturnCurrenciesList returnCurrenciesList = new ReturnCurrenciesList();

    @Test
    public void test() {
        List<Currency> currencies = returnCurrenciesList.returnCurrencies();

        for (Currency currency : currencies) {
            System.out.println(currency.toString());
        }
    }

}
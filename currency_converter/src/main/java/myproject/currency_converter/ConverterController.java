package myproject.currency_converter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ConverterController {

    private final ReturnCurrenciesList returnCurrenciesList;
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/currency-converter")
    public String currencyConverterForm(Model model, @ModelAttribute("formDto") ExchangeRateCalDto exchangeRateCalDto) {
//        List<String> currencies = Stream.of(Currencies.values())
//                .map(Currencies::name)
//                .collect(Collectors.toList());

        List<Currency> currencies = returnCurrenciesList.returnCurrencies();
        model.addAttribute("currencies", currencies);
        //model.addAttribute("formDto", new ExchangeRateCalDto(null, null, 0));

        return "main";
    }

    @PostMapping("/currency-converter")
    public String currencyConverter(@Validated @ModelAttribute("formDto") ExchangeRateCalDto exchangeRateCalDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            log.error("error={}", bindingResult);
            List<Currency> currencies = returnCurrenciesList.returnCurrencies();
            model.addAttribute("currencies", currencies);
            return "main";
        }

        exchangeRateCalDto.setResult(exchangeRateService.getExchangeRate(exchangeRateCalDto));
        log.info("sourceCurrency={}, targetCurrency={}, amount={}, result={}", exchangeRateCalDto.getSourceCurrency(), exchangeRateCalDto.getTargetCurrency(), exchangeRateCalDto.getAmount(), exchangeRateCalDto.getResult());

        List<Currency> currencies = returnCurrenciesList.returnCurrencies();
        model.addAttribute("currencies", currencies);

        return "main";
    }
}
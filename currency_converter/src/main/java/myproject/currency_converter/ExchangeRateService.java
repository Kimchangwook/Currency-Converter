package myproject.currency_converter;

import okhttp3.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExchangeRateService {
    public double getExchangeRate(ExchangeRateCalDto exchangeRateCalDto) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/currency_data/convert?to=" + exchangeRateCalDto.getTargetCurrency()
                        + "&from=" + exchangeRateCalDto.getSourceCurrency() + "&amount=" + exchangeRateCalDto.getAmount())
                .addHeader("apikey", "2PDwMJS6U9SFad6axev9TE7PA8LWA3Sy")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        String jsonString = response.body().string();
        JSONObject jsonObject = new JSONObject(jsonString);

        double result = jsonObject.getDouble("result");

        return result;
    }
}

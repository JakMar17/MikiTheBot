package team.marela.covid.miki_the_bot.services.crypto;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.marela.covid.miki_the_bot.services.crypto.models.CryptoCurrencyRootModel;
import team.marela.covid.miki_the_bot.services.sledilnik.models.MainSummaryModel;

@Service
@RequiredArgsConstructor
public class CryptoServices {
    @Value("${crypto_api_token}")
    private String token;

    private final RestTemplate restTemplate;

    public CryptoCurrencyRootModel getCryptoPrice(String cryptoId) {
        String url = String.format(
            "https://api.nomics.com/v1/currencies/ticker?ids=%s&convert=EUR&key=%s",
                cryptoId,
                token
        );

        var array = this.restTemplate.getForObject(url, CryptoCurrencyRootModel[].class);

        return array[0];
    }
}

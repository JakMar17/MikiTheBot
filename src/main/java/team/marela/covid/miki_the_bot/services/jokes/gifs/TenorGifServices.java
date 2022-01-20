package team.marela.covid.miki_the_bot.services.jokes.gifs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.marela.covid.miki_the_bot.services.jokes.gifs.model.TenorGifResponseModel;
import team.marela.covid.miki_the_bot.services.jokes.your_mom.model.TvojaMamaNotModel;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TenorGifServices {

    @Value("${tenor_api_token}")
    private String token;
    private String url = "https://g.tenor.com/v1/search?q=%QUERY&key=%KEY&limit=%LIMIT";

    private final RestTemplate restTemplate;

    public String getRandomGif(String searchQuery) {
        final int limit = 10;

        final var finalUrl = url
                .replace("%QUERY", searchQuery)
                .replace("%KEY", token)
                .replace("%LIMIT", Integer.toString(limit));

        var model = this.restTemplate.getForObject(finalUrl, TenorGifResponseModel.class);

        var random = new Random();
        var randomGif = random.nextInt(limit + 1);

        return model.results.get(randomGif).getMedia().get(0).getGif().getUrl();
    }
}

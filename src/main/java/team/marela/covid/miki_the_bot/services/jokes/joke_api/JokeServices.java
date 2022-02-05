package team.marela.covid.miki_the_bot.services.jokes.joke_api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.marela.covid.miki_the_bot.services.jokes.your_mom.model.TvojaMamaNotModel;

@Service
@RequiredArgsConstructor
public class JokeServices {

    private final RestTemplate restTemplate;

    public String getJoke() {
        String url = "https://icanhazdadjoke.com/";
        return this.restTemplate.getForObject(url, String.class);
    }
}

package team.marela.covid.miki_the_bot.services.jokes.your_mom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.marela.covid.miki_the_bot.services.jokes.your_mom.model.TvojaMamaNotModel;

@Service
@RequiredArgsConstructor
public class TvojaMamaServices {

    private final RestTemplate restTemplate;

    public String getJoke() {
        String url = "https://api.yomomma.info/";
        return this.restTemplate.getForObject(url, TvojaMamaNotModel.class).getJoke();
    }
}

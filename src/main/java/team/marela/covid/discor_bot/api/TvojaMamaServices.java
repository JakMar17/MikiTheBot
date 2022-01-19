package team.marela.covid.discor_bot.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.marela.covid.discor_bot.api.model.TvojaMamaNotModel;
import team.marela.covid.discor_bot.sledilnik_api.models.MainSummaryModel;

@Service
@RequiredArgsConstructor
public class TvojaMamaServices {

    private final RestTemplate restTemplate;

    public String getJoke() {
        String url = "https://api.yomomma.info/";
        return this.restTemplate.getForObject(url, TvojaMamaNotModel.class).getJoke();
    }
}

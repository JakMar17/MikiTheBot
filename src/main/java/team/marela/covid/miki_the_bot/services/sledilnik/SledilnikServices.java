package team.marela.covid.miki_the_bot.services.sledilnik;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.marela.covid.miki_the_bot.services.sledilnik.models.MainSummaryModel;

@Service
@RequiredArgsConstructor
public class SledilnikServices {

    private final RestTemplate restTemplate;

    public MainSummaryModel getSummary() {
        String url = "https://api.sledilnik.org/api/summary";
        return this.restTemplate.getForObject(url, MainSummaryModel.class);
    }
}

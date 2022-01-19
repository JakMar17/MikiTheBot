package team.marela.covid.discor_bot.sledilnik_api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import team.marela.covid.discor_bot.sledilnik_api.models.MainSummaryModel;

@Service
@RequiredArgsConstructor
public class SledilnikSummaryService {

    private final RestTemplate restTemplate;

    public MainSummaryModel getSummary() {
        String url = "https://api.sledilnik.org/api/summary";
        return this.restTemplate.getForObject(url, MainSummaryModel.class);
    }
}

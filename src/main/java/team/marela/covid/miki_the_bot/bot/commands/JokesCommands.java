package team.marela.covid.miki_the_bot.bot.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.marela.covid.miki_the_bot.services.jokes.your_mom.TvojaMamaServices;

@Service
@RequiredArgsConstructor
public class JokesCommands {

    private final TvojaMamaServices tvojaMamaServices;

    public String getYourMamaJoke() {
        return tvojaMamaServices.getJoke();
    }

    public String getPrstki() {
        return "<:bizi:930906818526478408>";
    }
}


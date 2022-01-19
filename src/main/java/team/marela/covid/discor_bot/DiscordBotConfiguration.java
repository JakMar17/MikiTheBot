package team.marela.covid.discor_bot;

import lombok.RequiredArgsConstructor;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.marela.covid.discor_bot.bot.commands.SledilnikSummaryCommand;
import team.marela.covid.discor_bot.bot.commands.TvojaMamaCommand;

@Configuration
@RequiredArgsConstructor
public class DiscordBotConfiguration {

    @Value("${token}")
    private String token;

    private final SledilnikSummaryCommand sledilnikSummaryCommand;
    private final TvojaMamaCommand tvojaMamaCommand;

    @Bean
    public void configureBot() {
        // We login blocking, just because it is simpler and doesn't matter here
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        // Add listeners
        api.addMessageCreateListener(sledilnikSummaryCommand);
        api.addMessageCreateListener(tvojaMamaCommand);
    }
}

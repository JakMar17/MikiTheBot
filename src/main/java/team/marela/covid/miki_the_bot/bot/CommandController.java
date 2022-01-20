package team.marela.covid.miki_the_bot.bot;


import lombok.RequiredArgsConstructor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;
import org.springframework.stereotype.Service;
import team.marela.covid.miki_the_bot.bot.commands.CovidCommands;
import team.marela.covid.miki_the_bot.bot.commands.GeneralCommands;
import team.marela.covid.miki_the_bot.bot.commands.JokesCommands;
import team.marela.covid.miki_the_bot.services.jokes.gifs.TenorGifServices;


@Service
@RequiredArgsConstructor
public class CommandController implements MessageCreateListener {

    private final GeneralCommands generalCommands;
    private final JokesCommands jokesCommands;
    private final CovidCommands covidCommands;

    private final TenorGifServices tenorGifServices;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String message = event.getMessageContent().toLowerCase();

        if(event.getMessageAuthor().isBotUser()) {
            return;
        }

        //general commands
        if (message.contains("!izgubilsemse")) {
            sendEmbeddedMessage(event, generalCommands.getHelp());
        }

        //jokes
        else if (message.contains("!tvojamama")) {
            sendStringMessage(event, jokesCommands.getYourMamaJoke());
            sendStringMessage(event, tenorGifServices.getRandomGif("laugh"));
        } else if (message.contains("!prstki")) {
            sendStringMessage(event, jokesCommands.getPrstki());
        }

        //covid commands
        else if (message.contains("!covid danes")) {
            sendEmbeddedMessage(event, covidCommands.getCovidSummary());
        }

    }

    private void sendStringMessage(MessageCreateEvent event, String message) {
        event.getChannel().sendMessage(message)
                .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }

    private void sendEmbeddedMessage(MessageCreateEvent event, EmbedBuilder message) {
        event.getChannel().sendMessage(message)
                .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }
}
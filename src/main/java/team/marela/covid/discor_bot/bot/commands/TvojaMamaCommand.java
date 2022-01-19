package team.marela.covid.discor_bot.bot.commands;

import lombok.RequiredArgsConstructor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;
import org.springframework.stereotype.Service;
import team.marela.covid.discor_bot.api.TvojaMamaServices;

@Service
@RequiredArgsConstructor
public class TvojaMamaCommand implements MessageCreateListener {

    private final TvojaMamaServices tvojaMamaServices;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!tvojamama")) {
            var joke = tvojaMamaServices.getJoke();
            event.getChannel().sendMessage(joke)
                    .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
        }
        else if (event.getMessageContent().equalsIgnoreCase("!prstki")) {
            var joke = tvojaMamaServices.getJoke();
            event.getChannel().sendMessage("<:bizi:930906818526478408>")
                    .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
        }
    }
}


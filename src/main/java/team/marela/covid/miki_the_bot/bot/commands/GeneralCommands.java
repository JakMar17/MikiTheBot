package team.marela.covid.miki_the_bot.bot.commands;

import lombok.RequiredArgsConstructor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.stereotype.Service;
import team.marela.covid.miki_the_bot.functions.FileRetriever;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GeneralCommands {

    private static final String HELP_MESSAGE = """
            Pozdravljen, moje ime je MikiTheBot. Če te kdaj narobe razumem, se ti že v naprej pardoniram. Na žalost nisem najpametnejši.
            Pomagam ti lahko z naslednjimi ukazi:
                \"!coviddanes\" - stanje COVIDa v Sloveniji za današnji dan
                \"!tvojamama\" - TVOJA MAMA!
                \"!prstki\" - poglej te prečudovite prstke <3
                \"!izgubilsemse\" - tu kjer si sedaj
                            
            Upam, da ti bom v pomoč in se ne bom izgubil.
            """;
    private final FileRetriever fileRetriever;

    public EmbedBuilder getHelp() {

        var e = new EmbedBuilder()
                .setTitle("MikiTheBot")
                .setDescription("Pozdravljen, moje ime je MikiTheBot. Če te kdaj narobe razumem, se ti že v naprej pardoniram. Na žalost nisem najpametnejši.\n Pomagam ti lahko z naslednjimi ukazi")
                .addField("!covid danes", "stanje COVIDa v Sloveniji za danšnji dan")
                .addField("!tvojamama", "TVOJA MAMA HAHAHAHAHAHAHAHAH!")
                .addField("!prstki", "Glejte kakšno čudo se godi")
                .addField("!izgubilsemse", "Jaz tudi :(")
                .setFooter("Upam, da ti bom v pomoč in se ne bom izgubil!");

        try {
            var image = fileRetriever.getFromResources("mikithebot.png");
            e.setThumbnail(image);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return e;
    }
}

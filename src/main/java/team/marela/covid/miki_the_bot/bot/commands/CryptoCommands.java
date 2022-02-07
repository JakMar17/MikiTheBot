package team.marela.covid.miki_the_bot.bot.commands;

import lombok.RequiredArgsConstructor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.util.logging.ExceptionLogger;
import org.springframework.stereotype.Service;
import team.marela.covid.miki_the_bot.services.crypto.CryptoServices;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CryptoCommands {

    private final CryptoServices cryptoServices;

    public void generateResponse(MessageCreateEvent event) {
        String message = event.getMessageContent().toLowerCase();
        var id = message.replace("!crypto ", "").toUpperCase();

        var data = cryptoServices.getCryptoPrice(id);
        var reply = new EmbedBuilder()
                .setTitle("Crypto " + data.getName())
                .setThumbnail(data.getLogoUrl())

                .addField("Price", reformatPrice(data.getPrice()) + " €")
                .addField(
                        "1 day",
                        String.format("%s € (%s)", reformatPrice(data.get_1d().getPriceChange()), reformatPercentage((data.get_1d().getPriceChangePct()))),
                        true
                )
                .addField(
                        "7 days",
                        String.format("%s € (%s)", reformatPrice(data.get_7d().getPriceChange()), reformatPercentage((data.get_7d().getPriceChangePct()))),
                        true
                )
                .addField(
                        "30 days",
                        String.format("%s € (%s)", reformatPrice(data.get_30d().getPriceChange()), reformatPercentage((data.get_30d().getPriceChangePct()))),
                        true
                )
                .addField(
                        "365 days",
                        String.format("%s € (%s)", reformatPrice(data.get_365d().getPriceChange()), reformatPercentage((data.get_365d().getPriceChangePct()))),
                        true
                ).addField(
                        "Highest",
                        String.format("%s € (%s)", reformatPrice(data.getHigh()),
                                data.getHighTimestamp().format(DateTimeFormatter.ofPattern("dd. MM. yyyy"))
                        ),
                        true
                );

        event.getChannel().sendMessage(reply)
                .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }


    private String reformatPrice(String plain) {
        return reformatPrice(plain, 5);
    }

    private String reformatPrice(String plain, int noOfDecimals) {
        String[] a = plain.split("\\.");
        var wholeNo = a[0];
        var decimalNo = a[1].length() > noOfDecimals ? a[1].substring(0, noOfDecimals) : a[1];

        return String.format("%s,%s", wholeNo, decimalNo);
    }

    private String reformatPercentage(String plain) {
        double p = Double.parseDouble(plain);
        p *= 100;

        return reformatPrice(p + "", 2) + "%";
    }

}

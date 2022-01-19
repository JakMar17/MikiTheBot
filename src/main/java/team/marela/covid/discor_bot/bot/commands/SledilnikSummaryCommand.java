package team.marela.covid.discor_bot.bot.commands;

import lombok.RequiredArgsConstructor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;
import org.springframework.stereotype.Service;
import team.marela.covid.discor_bot.sledilnik_api.services.SledilnikSummaryService;

@Service
@RequiredArgsConstructor
public class SledilnikSummaryCommand implements MessageCreateListener {

    private final SledilnikSummaryService sledilnikSummaryService;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!sledilnik")) {

            var data = sledilnikSummaryService.getSummary();

            var builder = new EmbedBuilder()
                    .setTitle("Covid v Sloveniji - današnji povzetek")
                    .setDescription(
                            String.format("Podatki o opravljenih testih iz dne %d. %d. %d\nHospitalizacije %d. %d. %d\nUmrli %d. %d. %d",
                                    data.getTestsToday().getDay(), data.getTestsToday().getMonth(), data.getTestsToday().getYear(),
                                    data.getHospitalizedCurrent().getDay(), data.getHospitalizedCurrent().getMonth(), data.getHospitalizedCurrent().getYear(),
                                    data.getDeceasedToDate().getDay(), data.getDeceasedToDate().getMonth(), data.getDeceasedToDate().getYear()
                            )
                    )
                    .addField(
                            String.format("PCR skupaj"),
                            data.getTestsToday().getValue().toString(),
                            true
                    )
                    .addInlineField("pozitivni", data.getTestsToday().getSubValues().getPositive().toString())
                    .addInlineField("%", String.format("%d %%", data.getTestsToday().getSubValues().getPercent()))

                    .addInlineField("Povprečje (7 dni)", String.format("%d (%.2f %%)", data.getCasesAvg7Days().getValue(), data.getCasesAvg7Days().getDiffPercentage()))
                    .addInlineField("Pojavnost na 100 000 (14 dni)", String.format("%d (%.2f %%)", data.getCasesActive100k().getValue(), data.getCasesActive100k().getDiffPercentage()))
                    .addInlineField("Umrli skupaj (danes)", String.format("%d (%d)", data.getDeceasedToDate().getValue(), data.getDeceasedToDate().getSubValues().getDeceased()))

                    .addField("Hospitalizacije", String.format("%d (%.2f %%)", data.getHospitalizedCurrent().getValue(), data.getHospitalizedCurrent().getDiffPercentage()), true)
                    .addInlineField("Sprejeti", String.format("%d", data.getHospitalizedCurrent().getValue()))
                    .addInlineField("Odpuščeni (umrli)", String.format("%d (%d)", data.getHospitalizedCurrent().getSubValues().getOut(), data.getHospitalizedCurrent().getSubValues().getDeceased()))

                    .addField("Intenzivna nega", String.format("%d", data.getIcuCurrent().getValue()), true)
                    .addInlineField("Sprejeti", String.format("%d", data.getIcuCurrent().getValue()))
                    .addInlineField("Odpuščeni (umrli)", String.format("%d (%d)", data.getIcuCurrent().getSubValues().getOut(), data.getIcuCurrent().getSubValues().getDeceased()));

            // Send the embed. It logs every exception, besides missing permissions (you are not allowed to send message in the channel)
            event.getChannel().sendMessage(builder)
                    .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
        }
    }
}

package team.marela.covid.discor_bot.sledilnik_api.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainSummaryModel {

    private SummaryModel vaccinationSummary;
    private SummaryModel casesToDateSummary;
    private SummaryModel casesActive;
    private SummaryModel casesActive100k;
    private SummaryModel casesAvg7Days;
    private SummaryModel hospitalizedCurrent;
    private SummaryModel icuCurrent;
    private SummaryModel deceasedToDate;
    private SummaryModel testsToday;
    private SummaryModel testsTodayHAT;
}

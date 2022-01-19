package team.marela.covid.discor_bot.sledilnik_api.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SummaryModel {

    private Integer value;
    private SummarySubValuesModel subValues;

    private Double diffPercentage;
    private Boolean sublabel;


    private Integer year;
    private Integer month;
    private Integer day;
}

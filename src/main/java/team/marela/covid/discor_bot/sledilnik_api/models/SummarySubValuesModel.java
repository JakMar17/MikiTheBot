package team.marela.covid.discor_bot.sledilnik_api.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummarySubValuesModel {

    private Integer in;
    private Integer out;
    private Integer deceased;
    private Integer positive;
    private Integer percent;
}

package team.marela.covid.miki_the_bot.services.crypto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptoPriceModel {
    @JsonProperty("volume")
    String volume;

    @JsonProperty("price_change")
    String priceChange;

    @JsonProperty("price_change_pct")
    String priceChangePct;

    @JsonProperty("volume_change")
    String volumeChange;

    @JsonProperty("volume_change_pct")
    String volumeChangePct;

    @JsonProperty("market_cap_change")
    String marketCapChange;

    @JsonProperty("market_cap_change_pct")
    String marketCapChangePct;
}

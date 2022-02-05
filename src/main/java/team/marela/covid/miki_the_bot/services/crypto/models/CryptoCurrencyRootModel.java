package team.marela.covid.miki_the_bot.services.crypto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrencyRootModel {
    @JsonProperty("id")
    String id;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("symbol")
    String symbol;

    @JsonProperty("name")
    String name;

    @JsonProperty("logo_url")
    String logoUrl;

    @JsonProperty("status")
    String status;

   @JsonProperty("price")
    String price;

    @JsonProperty("price_date")
    LocalDateTime priceDate;

    @JsonProperty("price_timestamp")
    LocalDateTime priceTimestamp;

    @JsonProperty("circulating_supply")
    String circulatingSupply;

    @JsonProperty("max_supply")
    String maxSupply;

    @JsonProperty("market_cap")
    String marketCap;

    @JsonProperty("market_cap_dominance")
    String marketCapDominance;

    @JsonProperty("num_exchanges")
    String numExchanges;

    @JsonProperty("num_pairs")
    String numPairs;

    @JsonProperty("num_pairs_unmapped")
    String nuPairsUnmapped;

    @JsonProperty("first_candle")
    LocalDateTime firstCandle;

    @JsonProperty("first_trade")
    LocalDateTime firstTrade;

    @JsonProperty("first_order_book")
    LocalDateTime firstOrderBook;

    @JsonProperty("rank")
    String rank;

    @JsonProperty("rank_delta")
    String rankDelta;

    @JsonProperty("high")
    String high;

    @JsonProperty("high_timestamp")
    LocalDateTime highTimestamp;

    @JsonProperty("1d")
    CryptoPriceModel _1d;

    @JsonProperty("7d")
    CryptoPriceModel _7d;

    @JsonProperty("30d")
    CryptoPriceModel _30d;

    @JsonProperty("365d")
    CryptoPriceModel _365d;

    @JsonProperty("ytd")
    CryptoPriceModel ytd;

    @JsonProperty("platform_currency")
    String platformCurrency;
}



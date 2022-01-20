package team.marela.covid.miki_the_bot.services.jokes.gifs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TenorGifResponseModel{
    public ArrayList<TenorGifResultModel> results;
    public String next;
}


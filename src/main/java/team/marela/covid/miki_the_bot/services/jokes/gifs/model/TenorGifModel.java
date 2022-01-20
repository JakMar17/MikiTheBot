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
public class TenorGifModel {
    private ArrayList<Integer> dims;
    private String url;
    private String preview;
    private int size;
}

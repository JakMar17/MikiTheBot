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
public class TenorGifResultModel {
    private String id;
    private String title;
    private String content_description;
    private String content_rating;
    private String h1_title;
    private ArrayList<TenorMediumModel> media;
    private String bg_color;
    private double created;
    private String itemurl;
    private String url;
    private ArrayList<Object> tags;
    private ArrayList<Object> flags;
    private int shares;
    private boolean hasaudio;
    private boolean hascaption;
    private String source_id;
    private Object composite;
}

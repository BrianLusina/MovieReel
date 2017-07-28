package com.moviereel.data.api.model.tv;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author lusinabrian on 10/04/17
 */

public class Seasons {

    @Expose
    @SerializedName("air_date")
    private String airDate;

    @Expose
    @SerializedName("episode_count")
    private int episodeCount;

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("poster_path")
    private String posterPath;

    @Expose
    @SerializedName("season_number")
    private int seasonNumber;
}

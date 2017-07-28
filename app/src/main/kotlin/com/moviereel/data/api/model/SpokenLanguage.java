package com.moviereel.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author lusinabrian on 31/03/17
 * Model for spoken language
 */

public class SpokenLanguage {

    @Expose
    @SerializedName("iso_639_1")
    private String isoCode;

    @Expose
    @SerializedName("name")
    private String name;

}

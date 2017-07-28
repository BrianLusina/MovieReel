package com.moviereel.data.api.model.movie.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author lusinabrian on 30/03/17
 */

public class DatesResponse {
    @Expose
    @SerializedName("maximum")
    private Date maximum;

    @Expose
    @SerializedName("minimum")
    private Date minimum;

    public Date getMaximum() {
        return maximum;
    }

    public void setMaximum(Date maximum) {
        this.maximum = maximum;
    }

    public Date getMinimum() {
        return minimum;
    }

    public void setMinimum(Date minimum) {
        this.minimum = minimum;
    }
}

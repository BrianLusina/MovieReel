package com.moviereel.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author lusinabrian on 31/03/17
 */

public class ProductionCompany {
    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("id")
    private int id;

    public ProductionCompany(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

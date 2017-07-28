package com.moviereel.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author lusinabrian on 31/03/17
 * Base request that all requests will inherit from
 */

public abstract class BaseRequest {

    @Expose
    @SerializedName("page")
    private int page;

    @Expose
    @SerializedName("language")
    private String language;

    public BaseRequest(int page, String language) {
        this.page = page;
        this.language = language;
    }

    public BaseRequest(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

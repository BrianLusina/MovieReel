package com.moviereel.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * @author lusinabrian on 01/04/17
 * Base response that are similar across all responses from api calls
 */

public abstract class BaseResponse{

    @Expose
    @SerializedName("page")
    private int page;

    @Expose
    @SerializedName("total_pages")
    private int totalPages;

    @Expose
    @SerializedName("total_results")
    private int totalResults;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}

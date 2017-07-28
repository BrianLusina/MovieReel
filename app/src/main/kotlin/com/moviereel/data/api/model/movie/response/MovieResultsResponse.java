package com.moviereel.data.api.model.movie.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moviereel.data.api.model.BaseResultsResponse;

/**
 * @author lusinabrian on 30/03/17
 * Results object for movies
 */

public class MovieResultsResponse extends BaseResultsResponse implements Parcelable {

    @Expose
    @SerializedName("release_date")
    private String releaseDate;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("original_title")
    private String originalTitle;

    public static final Creator<MovieResultsResponse> CREATOR = new Creator<MovieResultsResponse>() {
        @Override
        public MovieResultsResponse createFromParcel(Parcel in) {
            return new MovieResultsResponse();
        }

        @Override
        public MovieResultsResponse[] newArray(int size) {
            return new MovieResultsResponse[size];
        }
    };

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @Override
    public String toString() {
        return "MovieResultsResponse{" +
                "releaseDate='" + releaseDate + '\'' +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(releaseDate);
        dest.writeString(title);
        dest.writeString(originalTitle);
    }
}

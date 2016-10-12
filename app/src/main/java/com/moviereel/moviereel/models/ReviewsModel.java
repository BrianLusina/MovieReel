package com.moviereel.moviereel.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * MovieReel
 * com.moviereel.moviereel.models
 * Created by lusinabrian on 11/10/16.
 * Description: POJO class for the reviews endpoint of the API
 */
public class ReviewsModel implements Parcelable {
    private String reviewId, reviewAuthor, reviewContent, reviewUrl;

    public ReviewsModel(){}

    public ReviewsModel(String reviewId, String reviewAuthor, String reviewContent, String reviewUrl) {
        this.reviewId = reviewId;
        this.reviewAuthor = reviewAuthor;
        this.reviewContent = reviewContent;
        this.reviewUrl = reviewUrl;
    }

    @Override
    public String toString() {
        return "ReviewsModel{" +
                "reviewId='" + reviewId + '\'' +
                ", reviewAuthor='" + reviewAuthor + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewUrl='" + reviewUrl + '\'' +
                '}';
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reviewId);
        dest.writeString(this.reviewAuthor);
        dest.writeString(this.reviewContent);
        dest.writeString(this.reviewUrl);
    }

    protected ReviewsModel(Parcel in) {
        this.reviewId = in.readString();
        this.reviewAuthor = in.readString();
        this.reviewContent = in.readString();
        this.reviewUrl = in.readString();
    }

    public static final Parcelable.Creator<ReviewsModel> CREATOR = new Parcelable.Creator<ReviewsModel>() {
        @Override
        public ReviewsModel createFromParcel(Parcel source) {
            return new ReviewsModel(source);
        }

        @Override
        public ReviewsModel[] newArray(int size) {
            return new ReviewsModel[size];
        }
    };
}

package com.moviereel.moviereel.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * MovieReel
 * com.moviereel.moviereel.models
 * Created by lusinabrian on 10/10/16.
 * Description: POJO of Images of a movie or tv series.
 * Fields include:
 * 1. "aspect_ratio": 1.77777777777778,
 * 2. "file_path": "/fCayJrkfRaCRCTh8GqN30f8oyQF.jpg",
 * 3. "height": 720,
 * 4. "iso_639_1": null,
 * 5. "vote_average": 0,
 * 6. "vote_count": int
 * 7. "width": int
 */

public class ImagesModel implements Parcelable{
    private String filePath, iso;
    private int width, height, voteCount;
    private float aspectRatio, voteAverage;

    public ImagesModel(){}

    public ImagesModel(String filePath, String iso, int width, int height, float voteAverage, int voteCount, float aspectRatio) {
        this.filePath = filePath;
        this.iso = iso;
        this.width = width;
        this.height = height;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.aspectRatio = aspectRatio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.filePath);
        dest.writeString(this.iso);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeFloat(this.voteAverage);
        dest.writeInt(this.voteCount);
        dest.writeFloat(this.aspectRatio);
    }

    protected ImagesModel(Parcel in) {
        this.filePath = in.readString();
        this.iso = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.voteAverage = in.readFloat();
        this.voteCount = in.readInt();
        this.aspectRatio = in.readFloat();
    }

    public static final Creator<ImagesModel> CREATOR = new Creator<ImagesModel>() {
        @Override
        public ImagesModel createFromParcel(Parcel source) {
            return new ImagesModel(source);
        }

        @Override
        public ImagesModel[] newArray(int size) {
            return new ImagesModel[size];
        }
    };

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
}

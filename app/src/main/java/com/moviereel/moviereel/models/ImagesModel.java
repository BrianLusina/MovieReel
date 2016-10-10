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
 * 6. "vote_count": 0,
 * 7. "width": 1280
 */

public class ImagesModel implements Parcelable{
    private String filePath, iso;
    private int width, height;
    private long voteAverage,voteCount;
    private double aspectRation;

    public ImagesModel(){}

    public ImagesModel(String filePath, String iso, int width, int height, long voteAverage, long voteCount, double aspectRation) {
        this.filePath = filePath;
        this.iso = iso;
        this.width = width;
        this.height = height;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.aspectRation = aspectRation;
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
        dest.writeLong(this.voteAverage);
        dest.writeLong(this.voteCount);
        dest.writeDouble(this.aspectRation);
    }

    protected ImagesModel(Parcel in) {
        this.filePath = in.readString();
        this.iso = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.voteAverage = in.readLong();
        this.voteCount = in.readLong();
        this.aspectRation = in.readDouble();
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

    public long getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(long voteAverage) {
        this.voteAverage = voteAverage;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }

    public double getAspectRation() {
        return aspectRation;
    }

    public void setAspectRation(double aspectRation) {
        this.aspectRation = aspectRation;
    }
}

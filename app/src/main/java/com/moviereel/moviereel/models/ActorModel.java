package com.moviereel.moviereel.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * MovieReel
 * com.moviereel.moviereel.models
 * Created by lusinabrian on 06/10/16.
 * Description:
 */

public class ActorModel implements Parcelable {
    private int castId, id,order;
    private String creditId, name,profilePath,character;

    /**Empty constructor for initilization*/
    public ActorModel(){}

    /**constructor for adding Actor models to the adapter*/
    public ActorModel(int castId, int id, int order, String creditId, String name, String profilePath, String character) {
        this.castId = castId;
        this.id = id;
        this.order = order;
        this.creditId = creditId;
        this.name = name;
        this.profilePath = profilePath;
        this.character = character;
    }

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.castId);
        dest.writeInt(this.id);
        dest.writeInt(this.order);
        dest.writeString(this.creditId);
        dest.writeString(this.name);
        dest.writeString(this.profilePath);
        dest.writeString(this.character);
    }

    protected ActorModel(Parcel in) {
        this.castId = in.readInt();
        this.id = in.readInt();
        this.order = in.readInt();
        this.creditId = in.readString();
        this.name = in.readString();
        this.profilePath = in.readString();
        this.character = in.readString();
    }

    public static final Parcelable.Creator<ActorModel> CREATOR = new Parcelable.Creator<ActorModel>() {
        @Override
        public ActorModel createFromParcel(Parcel source) {
            return new ActorModel(source);
        }

        @Override
        public ActorModel[] newArray(int size) {
            return new ActorModel[size];
        }
    };

    @Override
    public String toString() {
        return "ActorModel{" +
                "castId=" + castId +
                ", id=" + id +
                ", order=" + order +
                ", creditId='" + creditId + '\'' +
                ", name='" + name + '\'' +
                ", profilePath='" + profilePath + '\'' +
                ", character='" + character + '\'' +
                '}';
    }
}

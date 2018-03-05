package com.example.shalini.assignment.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shalini Prajesh on 4/3/18.
 */

public class Owner implements Parcelable{
    @SerializedName("avatar_url")
    String avatarUrl;

    protected Owner(Parcel in) {
        avatarUrl = in.readString();
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avatarUrl);
    }
}

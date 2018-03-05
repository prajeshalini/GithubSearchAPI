package com.example.shalini.assignment.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shalini Prajesh on 5/3/18.
 */

public class Contributor implements Parcelable {
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("repos_url")
    private String repoUrl;

    protected Contributor(Parcel in) {
        avatarUrl = in.readString();
        repoUrl = in.readString();
    }

    public static final Creator<Contributor> CREATOR = new Creator<Contributor>() {
        @Override
        public Contributor createFromParcel(Parcel in) {
            return new Contributor(in);
        }

        @Override
        public Contributor[] newArray(int size) {
            return new Contributor[size];
        }
    };

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avatarUrl);
        dest.writeString(repoUrl);
    }
}

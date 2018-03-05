package com.example.shalini.assignment.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shalini Prajesh on 3/3/18.
 */

public class Repos implements Parcelable{
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("watchers_count")
    private String watchersCount;
    @SerializedName("owner")
    private Owner owner;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("contributors_url")
    private String contributorsUrl;
    @SerializedName("description")
    private String description;


    public Repos(String name) {
        this.name = name;
    }

    protected Repos(Parcel in) {
        owner = in.readParcelable(Owner.class.getClassLoader());
        name = in.readString();
        fullName = in.readString();
        watchersCount = in.readString();
        htmlUrl = in.readString();
        contributorsUrl = in.readString();
        description = in.readString();
    }

    public static final Creator<Repos> CREATOR = new Creator<Repos>() {
        @Override
        public Repos createFromParcel(Parcel in) {
            return new Repos(in);
        }

        @Override
        public Repos[] newArray(int size) {
            return new Repos[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getWatchersCount() {
        return watchersCount;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(owner,flags);
        dest.writeString(name);
        dest.writeString(fullName);
        dest.writeString(watchersCount);
        dest.writeString(htmlUrl);
        dest.writeString(contributorsUrl);
        dest.writeString(description);
    }
}

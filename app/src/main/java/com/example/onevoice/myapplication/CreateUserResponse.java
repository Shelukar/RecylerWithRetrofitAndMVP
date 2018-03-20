package com.example.onevoice.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by onevoice on 1/3/18.
 */

public class CreateUserResponse {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;
}

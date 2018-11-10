package com.moleujana.morzana.mrzn;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gsy01 on 2018-11-10.
 */

public class Login {

    @SerializedName("u_id")
    public String id;
    @SerializedName("u_password")
    public String password;

    public boolean state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

}

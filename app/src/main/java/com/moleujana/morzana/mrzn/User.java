package com.moleujana.morzana.mrzn;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gsy01 on 2018-11-10.
 */

public class User {

    @SerializedName("u_idx")
    public int idx;
    @SerializedName("u_id")
    public String id;
    @SerializedName("u_password")
    public String password;
    @SerializedName("u_name")
    public String name;
    @SerializedName("u_phoneNum")
    public String  phoneNum;
    @SerializedName("u_email")
    public String  email;

    private boolean state;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

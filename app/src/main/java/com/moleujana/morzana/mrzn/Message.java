package com.moleujana.morzana.mrzn;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gsy01 on 2018-11-10.
 */

public class Message {

    @SerializedName("m_idx")
    public int idx;
    @SerializedName("u_idx_caller")
    public int idx_caller;
    @SerializedName("m_contents")
    public String  contents;
    @SerializedName("u_idx_receiver")
    public int idx_receiver;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdx_caller() {
        return idx_caller;
    }

    public void setIdx_caller(int idx_caller) {
        this.idx_caller = idx_caller;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getIdx_receiver() {
        return idx_receiver;
    }

    public void setIdx_receiver(int idx_receiver) {
        this.idx_receiver = idx_receiver;
    }
}

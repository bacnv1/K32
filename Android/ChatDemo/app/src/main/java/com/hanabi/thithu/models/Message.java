package com.hanabi.thithu.models;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String idUserName;
    @SerializedName("message")
    private String message;
    @SerializedName("pub_date")
    private String createAt;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUserName() {
        return idUserName;
    }

    public void setIdUserName(String idUserName) {
        this.idUserName = idUserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}

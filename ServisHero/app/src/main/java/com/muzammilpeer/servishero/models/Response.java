
package com.muzammilpeer.servishero.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muzammilpeer.baselayer.model.BaseModel;

public class Response  extends BaseModel{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("responseText")
    @Expose
    private String responseText;
    @SerializedName("responseValue")
    @Expose
    private String responseValue;
    @SerializedName("responseOrder")
    @Expose
    private Integer responseOrder;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("question")
    @Expose
    private Integer question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(String responseValue) {
        this.responseValue = responseValue;
    }

    public Integer getResponseOrder() {
        return responseOrder;
    }

    public void setResponseOrder(Integer responseOrder) {
        this.responseOrder = responseOrder;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

}

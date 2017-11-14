
package com.muzammilpeer.servishero.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeServicesResponseModel {

    @SerializedName("searchTerms")
    @Expose
    private String searchTerms;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("bodyText")
    @Expose
    private String bodyText;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("serviceType")
    @Expose
    private Integer serviceType;
    @SerializedName("questionSubsets")
    @Expose
    private QuestionSubsets questionSubsets;

    public String getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public QuestionSubsets getQuestionSubsets() {
        return questionSubsets;
    }

    public void setQuestionSubsets(QuestionSubsets questionSubsets) {
        this.questionSubsets = questionSubsets;
    }

}

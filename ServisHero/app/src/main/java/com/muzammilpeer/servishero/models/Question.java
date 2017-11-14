
package com.muzammilpeer.servishero.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muzammilpeer.baselayer.model.BaseModel;

public class Question extends BaseModel {

    @SerializedName("responses")
    @Expose
    private List<Response> responses = null;
    @SerializedName("service")
    @Expose
    private Integer service;
    @SerializedName("questionType")
    @Expose
    private QuestionType questionType;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("questionText")
    @Expose
    private String questionText;
    @SerializedName("questionSubText")
    @Expose
    private String questionSubText;
    @SerializedName("questionSubsetId")
    @Expose
    private Integer questionSubsetId;
    @SerializedName("questionOrder")
    @Expose
    private Integer questionOrder;
    @SerializedName("salesItemTypeId")
    @Expose
    private Integer salesItemTypeId;
    @SerializedName("numOfServiceUnit")
    @Expose
    private Integer numOfServiceUnit;
    @SerializedName("serviceAttributeId")
    @Expose
    private Integer serviceAttributeId;
    @SerializedName("isTooltip")
    @Expose
    private Boolean isTooltip;
    @SerializedName("isOptional")
    @Expose
    private Boolean isOptional;
    @SerializedName("tooltipText")
    @Expose
    private String tooltipText;
    @SerializedName("tooltipImageUrl")
    @Expose
    private String tooltipImageUrl;
    @SerializedName("durationPerUnit")
    @Expose
    private Integer durationPerUnit;

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionSubText() {
        return questionSubText;
    }

    public void setQuestionSubText(String questionSubText) {
        this.questionSubText = questionSubText;
    }

    public Integer getQuestionSubsetId() {
        return questionSubsetId;
    }

    public void setQuestionSubsetId(Integer questionSubsetId) {
        this.questionSubsetId = questionSubsetId;
    }

    public Integer getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(Integer questionOrder) {
        this.questionOrder = questionOrder;
    }

    public Integer getSalesItemTypeId() {
        return salesItemTypeId;
    }

    public void setSalesItemTypeId(Integer salesItemTypeId) {
        this.salesItemTypeId = salesItemTypeId;
    }

    public Integer getNumOfServiceUnit() {
        return numOfServiceUnit;
    }

    public void setNumOfServiceUnit(Integer numOfServiceUnit) {
        this.numOfServiceUnit = numOfServiceUnit;
    }

    public Integer getServiceAttributeId() {
        return serviceAttributeId;
    }

    public void setServiceAttributeId(Integer serviceAttributeId) {
        this.serviceAttributeId = serviceAttributeId;
    }

    public Boolean getIsTooltip() {
        return isTooltip;
    }

    public void setIsTooltip(Boolean isTooltip) {
        this.isTooltip = isTooltip;
    }

    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public String getTooltipText() {
        return tooltipText;
    }

    public void setTooltipText(String tooltipText) {
        this.tooltipText = tooltipText;
    }

    public String getTooltipImageUrl() {
        return tooltipImageUrl;
    }

    public void setTooltipImageUrl(String tooltipImageUrl) {
        this.tooltipImageUrl = tooltipImageUrl;
    }

    public Integer getDurationPerUnit() {
        return durationPerUnit;
    }

    public void setDurationPerUnit(Integer durationPerUnit) {
        this.durationPerUnit = durationPerUnit;
    }

}

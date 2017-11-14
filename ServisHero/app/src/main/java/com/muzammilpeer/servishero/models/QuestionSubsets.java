
package com.muzammilpeer.servishero.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionSubsets {

    @SerializedName("1")
    @Expose
    private List<Question> question1 = null;
    @SerializedName("3")
    @Expose
    private List<Question> question3 = null;

    public List<Question> getQuestion1() {
        return question1;
    }

    public void setQuestion1(List<Question> question1) {
        this.question1 = question1;
    }

    public List<Question> getQuestion3() {
        return question3;
    }

    public void setQuestion3(List<Question> question3) {
        this.question3 = question3;
    }

}

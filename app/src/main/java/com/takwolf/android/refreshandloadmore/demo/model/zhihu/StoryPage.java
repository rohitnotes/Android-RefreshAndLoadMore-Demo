package com.takwolf.android.refreshandloadmore.demo.model.zhihu;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryPage {

    private String date;

    @SerializedName("stories")
    private List<Story> storyList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

}

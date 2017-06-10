package com.takwolf.android.refreshandloadmore.demo.model.zhihu;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Story {

    private String id;

    private String type;

    @SerializedName("ga_prefix")
    private String  gaPrefix;

    private String title;

    @SerializedName("images")
    private List<String> imageList;

    @SerializedName("multipic")
    private boolean multiPic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public boolean isMultiPic() {
        return multiPic;
    }

    public void setMultiPic(boolean multiPic) {
        this.multiPic = multiPic;
    }

}

package com.takwolf.android.refreshandloadmore.demo.model.illust;

public class Illust {

    private String id;

    private String image;

    public Illust() {}

    public Illust(String id, String image) {
        this.id = id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

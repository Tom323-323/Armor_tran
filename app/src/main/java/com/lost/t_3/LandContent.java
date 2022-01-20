package com.lost.t_3;

public class LandContent {

    private String title_text, content_text;
    private int img_land;

    public String getTitle_text() {
        return title_text;
    }

    public String getContent_text() {
        return content_text;
    }

    public int getImg_land() {
        return img_land;
    }

    public void setTitle_text(String title_text) {
        this.title_text = title_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public void setImg_land(int img_land) {
        this.img_land = img_land;
    }

    public LandContent(String title_text, String content_text, int img_land) {
        this.title_text = title_text;
        this.content_text = content_text;
        this.img_land = img_land;
    }
}

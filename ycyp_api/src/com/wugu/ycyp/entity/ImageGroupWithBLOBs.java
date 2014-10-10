package com.wugu.ycyp.entity;

import java.io.Serializable;

public class ImageGroupWithBLOBs extends ImageGroup implements Serializable {
    private String content;

    private String html;

    private static final long serialVersionUID = 1L;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }
}
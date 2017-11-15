package com.love.rxjavademo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by android on 2017/11/15.
 */

public class MultipleItem implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int IMG = 0;
    private int itemType;


    private String text;
    private String url;


    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }


    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

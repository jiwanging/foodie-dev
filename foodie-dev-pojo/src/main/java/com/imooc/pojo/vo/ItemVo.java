package com.imooc.pojo.vo;

import java.util.List;

public class ItemVo {

    private String rootCatId;//父级id
    private String rootCatName;//父级名称
    private String slogan;//父级slogan
    private String catImage;//父类图片
    private String bgColor;//背景颜色
    private List<NewItemVo> simpleItemList;

    public String getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(String rootCatId) {
        this.rootCatId = rootCatId;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public List<NewItemVo> getSimpleItemList() {
        return simpleItemList;
    }

    public void setSimpleItemList(List<NewItemVo> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }
}

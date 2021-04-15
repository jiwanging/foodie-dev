package com.imooc.pojo.vo;

import com.imooc.pojo.Category;

import java.util.List;

public class CategoryVo {

    private String id;
    private String name;
    private String type;
    private String fatherId;
    private List<Category> subCatList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public List<Category> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<Category> subCatList) {
        this.subCatList = subCatList;
    }
}

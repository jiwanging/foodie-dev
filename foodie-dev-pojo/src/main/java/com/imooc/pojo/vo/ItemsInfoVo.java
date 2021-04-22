package com.imooc.pojo.vo;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;

import java.util.List;

public class ItemsInfoVo {

    private Items item;//商品信息
    private List<ItemsImg> itemImgList;//商品图片
    private List<ItemsSpec> itemSpecList;//商品售卖规格
    private ItemsParam itemParams;//商品参数，生产厂商等信息

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public List<ItemsImg> getItemImgList() {
        return itemImgList;
    }

    public void setItemImgList(List<ItemsImg> itemImgList) {
        this.itemImgList = itemImgList;
    }

    public List<ItemsSpec> getItemSpecList() {
        return itemSpecList;
    }

    public void setItemSpecList(List<ItemsSpec> itemSpecList) {
        this.itemSpecList = itemSpecList;
    }

    public ItemsParam getItemParams() {
        return itemParams;
    }

    public void setItemParams(ItemsParam itemParams) {
        this.itemParams = itemParams;
    }

    @Override
    public String toString() {
        return "ItemsInfoVo{" +
                "items=" + item +
                ", itemImgList=" + itemImgList +
                ", itemSpecList=" + itemSpecList +
                ", itemParams=" + itemParams +
                '}';
    }
}

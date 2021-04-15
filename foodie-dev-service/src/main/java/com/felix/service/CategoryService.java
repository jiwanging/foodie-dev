package com.felix.service;

import com.imooc.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有大分类
     * @return
     */
    public List<Category> queryAllRootLevelCat();

    /**
     * 查询指定大分类下的子分类
     * @return
     */
    public List<Category> querySubLevelList(Integer rootId);
}

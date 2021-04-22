package com.felix.service;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVo;
import com.imooc.pojo.vo.ItemVo;

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
    public List<CategoryVo> querySubLevelList(Integer rootId);

    /**
     * 查询指定分类下最新的6个商品及其图片 用于推荐
     * @param catId 指定商品分类id
     * @return
     */
    public List<ItemVo> getNewSixItem(Integer catId);
}

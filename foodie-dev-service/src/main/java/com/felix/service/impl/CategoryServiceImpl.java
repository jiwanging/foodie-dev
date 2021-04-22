package com.felix.service.impl;

import com.felix.service.CategoryService;
import com.imooc.mapper.CategoryMapper;
import com.imooc.mapper.CategoryMapperCustom;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVo;
import com.imooc.pojo.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        List<Category> list = categoryMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<CategoryVo> querySubLevelList(Integer rootId) {

        List<CategoryVo> list = categoryMapperCustom.querySubList(rootId);

        return list;
    }

    @Override
    public List<ItemVo> getNewSixItem(Integer catId) {

        return categoryMapperCustom.queryNewSixItem(catId);
    }


}

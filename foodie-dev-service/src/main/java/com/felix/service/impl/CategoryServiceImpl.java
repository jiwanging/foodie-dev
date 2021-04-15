package com.felix.service.impl;

import com.felix.service.CategoryService;
import com.imooc.mapper.CategoryMapper;
import com.imooc.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        List<Category> list = categoryMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<Category> querySubLevelList(Integer rootId) {

        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fatherId",rootId);
        List<Category> list = categoryMapper.selectByExample(example);

        return list;
    }
}

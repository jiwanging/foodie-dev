package com.imooc.mapper;

import com.imooc.pojo.vo.CategoryVo;
import com.imooc.pojo.vo.ItemVo;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNode;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {

    public List<CategoryVo> querySubList(@Param("rootId") int rootId);

    public List<ItemVo> queryNewSixItem(@Param("catId") int catId);
}

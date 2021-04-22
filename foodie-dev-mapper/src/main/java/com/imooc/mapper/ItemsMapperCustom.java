package com.imooc.mapper;

import com.imooc.pojo.vo.ItemsCommentsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    public List<ItemsCommentsVo> queryComments(@Param("paramsMap") Map<String, Object> map);
}

package com.imooc.mapper;

import com.imooc.pojo.vo.ItemsCommentsVo;
import com.imooc.pojo.vo.SearchItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    /**
     * 查询商品评论
     * @param map
     * @return
     */
    public List<ItemsCommentsVo> queryComments(@Param("paramsMap") Map<String, Object> map);

    /**
     * 查询搜索结果
     * @param map
     * @return
     */
    public List<SearchItemsVo> querySearcherInfo(@Param("map") Map<String, Object> map);

    /**
     * 根据三级分类查询商品信息
     * @param map
     * @return
     */
    public List<SearchItemsVo> queryInfoByThirdCatId(@Param("thirdMap") Map<String, Object> map);


}

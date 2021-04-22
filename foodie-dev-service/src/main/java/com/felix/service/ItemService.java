package com.felix.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CommentsPageVo;
import com.imooc.pojo.vo.CommentsVo;
import com.imooc.pojo.vo.ItemsCommentsVo;
import com.imooc.pojo.vo.PagedGridResult;

import java.util.List;

public interface ItemService {

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品评论数量
     * @param itemId
     * @return
     */
    public CommentsVo queryItemComments(String itemId);

    /**
     * 根据商品id查询商品分页的商品评论信息
     * @param itemId
     * @return
     */
    public PagedGridResult queryPagedComments(String itemId, Integer level,
                                              Integer page, Integer pageSize);


    /**
     * 根据关键字查询商品信息
     * @param itemId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult querySearcherInfo(String itemId, String sort,
                                              Integer page, Integer pageSize);

    /**
     * 根据商品三级分类查询商品信息
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryInfoByThirdCatId(String catId, String sort,
                                             Integer page, Integer pageSize);


}

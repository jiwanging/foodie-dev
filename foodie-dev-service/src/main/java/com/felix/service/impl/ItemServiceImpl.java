package com.felix.service.impl;

import com.felix.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.enums.CommentsLevel;
import com.imooc.mapper.*;
import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentsPageVo;
import com.imooc.pojo.vo.CommentsVo;
import com.imooc.pojo.vo.ItemsCommentsVo;
import com.imooc.pojo.vo.PagedGridResult;
import com.imooc.utils.DesensitizationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsImgMapper itemsImgMapper;

    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsImgMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsSpecMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemParam(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsParamMapper.selectOneByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentsVo queryItemComments(String itemId) {

        Integer goodCounts =  getCommentsCounts(itemId, CommentsLevel.goodComments.level);
        Integer normalCounts =  getCommentsCounts(itemId, CommentsLevel.normalComments.level);
        Integer badCounts =  getCommentsCounts(itemId, CommentsLevel.badComments.level);
        Integer totalCounts =  goodCounts + normalCounts + badCounts;

        //封装返回数据
        CommentsVo commentsVo = new CommentsVo();
        commentsVo.setGoodCounts(goodCounts);
        commentsVo.setNormalCounts(normalCounts);
        commentsVo.setBadCounts(badCounts);
        commentsVo.setTotalCounts(totalCounts);

        return commentsVo;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize) {

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("itemId",itemId);
        map.put("level",level+"");
        //开始分页
        PageHelper.startPage(page,pageSize);
        List<ItemsCommentsVo> list = itemsMapperCustom.queryComments(map);
        //昵称进行脱敏处理
        for (ItemsCommentsVo vo : list) {
            vo.setNickname(DesensitizationUtil.commonDisplay(vo.getNickname()));
        }

        return setPageInfo(page,list);
    }

    private PagedGridResult setPageInfo(Integer page, List<ItemsCommentsVo> list) {
        PageInfo<ItemsCommentsVo> pageInfo = new PageInfo<ItemsCommentsVo>(list);
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setTotal(pageInfo.getPages());
        pagedGridResult.setRecords(pageInfo.getTotal());
        pagedGridResult.setRows(list);
        pagedGridResult.setPage(page);
        return pagedGridResult;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getCommentsCounts(String itemsId, Integer level){
        ItemsComments condition = new ItemsComments();
        if(level != null){
            condition.setCommentLevel(level);
        }
        condition.setItemId(itemsId);
        return itemsCommentsMapper.selectCount(condition);
    }
}

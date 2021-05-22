package com.felix;

import com.imooc.mapper.CategoryMapperCustom;
import com.imooc.mapper.ItemsMapperCustom;
import com.imooc.pojo.bo.ShopcartItemBo;
import com.imooc.pojo.vo.ItemSpecVo;
import com.imooc.pojo.vo.ItemVo;
import com.imooc.pojo.vo.ItemsInfoVo;
import com.imooc.pojo.vo.SearchItemsVo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperCustomTest {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Test
    @Ignore
    public void querySearchInfo() {
        System.out.println("querySubList 执行====");
        Map<String,Object> map = new HashMap<>();
        map.put("Keywords","面");
        map.put("sort","p");
        List<SearchItemsVo> list = itemsMapperCustom.querySearcherInfo(map);
        System.out.println("执行结束=========");
        System.out.println("执行结果为："+ list.toString());
    }

    @Test
    public void queryThirdInfo() {
        System.out.println("queryThirdInfo 执行====");
        Map<String,Object> map = new HashMap<>();
        map.put("catId","51");
        map.put("sort","p");
        List<SearchItemsVo> list = itemsMapperCustom.queryInfoByThirdCatId(map);
        System.out.println("执行结束=========");
        System.out.println("执行结果为："+ list.toString());
    }

    @Test
    public void queryLastInfo() {
        System.out.println("queryLastInfo 执行====");
        List<String> list = new ArrayList<>();
        list.add("7");
        list.add("cake-1004-spec-1");
        List<ItemSpecVo> result = itemsMapperCustom.querylastInfo(list);
        System.out.println("执行结束=========");
        System.out.println("执行结果为："+ result.toString());
    }

}
package com.felix;

import com.imooc.mapper.CategoryMapperCustom;
import com.imooc.pojo.vo.ItemVo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class CategoryMapperCustomTest {

    @Autowired
    private CategoryMapperCustom custom;

    @Test
    public void querySubList() {
        System.out.println("querySubList 执行====");
    }

    @Test
    public void queryNewSixItem() {
        System.out.println("queryNewSixItem 执行====");
        List<ItemVo> list = custom.queryNewSixItem(1);
        System.out.println(list.get(0).getRootCatName());
    }
}
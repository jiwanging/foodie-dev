package com.felix.service.ServiceImpl;

import com.felix.service.CarouselService;
import com.imooc.mapper.CarouselMapper;
import com.imooc.pojo.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);
        example.orderBy("sort").desc();
        return carouselMapper.selectByExample(example);
    }
}

package com.felix.service.ServiceImpl;

import com.felix.service.UserService;
import com.imooc.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper userMappper;

    @Override
    public Object getUserInfoById(int id) {
        return userMappper.selectByPrimaryKey(id);
    }
}

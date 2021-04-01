package com.felix.service;

import com.imooc.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {


    public Object getUserInfoById(int id);
}

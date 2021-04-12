package com.felix.service.ServiceImpl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

import com.felix.service.UserService;
import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper userMappper;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";


    @Override
    public Object getUserInfoById(int id) {
        return userMappper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryNameIsExit(String userName) {
        if(userName == null){
            return false;
        }
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", userName);
        Users results = userMappper.selectOneByExample(userExample);
        if(results != null )
            return true;
        return false;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users createUser(UserBo userBo) {
        //1、验证用户名等不能为空
        if((userBo != null) && StrUtil.hasEmpty(userBo.getUsername()) &&
                StrUtil.hasEmpty(userBo.getPassword()) &&
                StrUtil.hasEmpty(userBo.getConfirmPassword())){
            return null;
        }

        //2、验证密码和确认密码是否相同
        if(!userBo.getPassword().equals(userBo.getConfirmPassword())){
            return null;
        }

        //3、创建新用户
        Users user =  new Users();
        // 设置唯一id
        user.setId(ObjectId.next());
        // 设置用户名
        user.setUsername(userBo.getUsername());
        // 设置默认密码
        user.setPassword(SecureUtil.md5(userBo.getPassword()));
        // 默认头像
        user.setFace(USER_FACE);
        // 默认生日
        user.setBirthday(DateUtil.parse("1900-01-01"));
        // 默认性别为 保密
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        userMappper.insert(user);

        return user;
    }

    @Override
    public IMOOCJSONResult login(UserBo userBo, HttpServletRequest request, HttpServletResponse response) {
        //1、用户名和密码不能为空
        String username = userBo.getUsername();
        String password = userBo.getPassword();

        if(StrUtil.hasEmpty(username) &&
                StrUtil.hasEmpty(password)){
            return new IMOOCJSONResult("用户名或密码不能为空");
        }
        //2、用户名和密码校验\
        Example example = new Example(Users.class);
        Example.Criteria criteria =  example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",SecureUtil.md5(password));
        Users userResult = userMappper.selectOneByExample(example);
        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userResult), true);

        //3、返回用户信息
        return new IMOOCJSONResult(200,"登录成功",userResult);
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
}

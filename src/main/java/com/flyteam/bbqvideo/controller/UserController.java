package com.flyteam.bbqvideo.controller;

import com.flyteam.bbqvideo.dao.UserDao;
import com.flyteam.bbqvideo.entity.UserInfo;
import com.flyteam.bbqvideo.repository.UserRepository;
import com.flyteam.bbqvideo.util.Result;
import com.flyteam.bbqvideo.util.ResultGenerator;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    public void addUser(UserDao userInfo){
        UserDao userDao=new UserDao();
        userDao.setUserName(userInfo.getUserName());
        userRepository.save(userDao);
    }

    @PostMapping("/login")
    public Result login(@RequestParam(required=false,name="username") String userName,
                        @RequestParam(required=false,name="password") String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            ResultGenerator.genFailResult("用户名或者密码不能为空");
        }
        UserInfo uInfo = null;
        try {
            UserDao data = userRepository.getUserDaoByUserNameAndPassword(userName,password);
            if(data!=null){
                uInfo = new UserInfo(data.getUserId(),data.getUserName(),data.getNickName());
            }
        }catch (Exception e){
            return ResultGenerator.genFailResult(e.toString());
        }
        if(uInfo!=null){
            return ResultGenerator.genSuccessResult(uInfo);
        }
        else{
            return ResultGenerator.genFailResult("登录失败，用户不存在");
        }
    }
    @PostMapping("/signIn")
    public Result signIn(@RequestParam(required=false,name="username") String userName,
                         @RequestParam(required=false,name="password") String password,
                         @RequestParam(required = false,name="nickname") String nickName) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)||StringUtils.isEmpty(nickName)) {
            ResultGenerator.genFailResult("各项信息不能为空");
        }
        try {
            List<UserDao> alreadyExistUser = userRepository.getUserDaoByUserName(userName);
            if(alreadyExistUser!=null&&alreadyExistUser.size()>0){
                return ResultGenerator.genFailResult("用户名已存在");
            }
        } catch (Exception e){
            return ResultGenerator.genFailResult(e.toString());
        }
        UserDao data = new UserDao();
        data.setUserName(userName);
        data.setPassword(password);
        data.setNickName(nickName);
        try {
            userRepository.save(data);
        }catch (Exception e){
            return ResultGenerator.genFailResult(e.toString());
        }
        return ResultGenerator.genSuccessResult("注册成功");
    }
}

package com.saran.springbootunittests.Service;

import com.saran.springbootunittests.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userdao;

    public String getUser(){
        return userdao.getUser();
    }

}

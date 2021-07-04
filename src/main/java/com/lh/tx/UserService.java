package com.lh.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-07-03 17:10
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void insert(){
        userDao.insert();
        System.out.println("插入完成。。。。");
    }
}

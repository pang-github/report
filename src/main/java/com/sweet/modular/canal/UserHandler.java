package com.sweet.modular.canal;


import com.sweet.modular.databaseInfo.entity.DatabaseInfo;
import com.sweet.modular.databaseInfo.service.DatabaseInfoService;
import com.sweet.modular.testUser.entity.TUser;
import com.sweet.modular.testUser.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

import java.util.List;

@Component
@CanalTable(value = "users")
public class UserHandler implements EntryHandler<User> {

    @Autowired
    TUserService tUserService;
    @Autowired
    DatabaseInfoService databaseInfoService;

    private Logger logger = LoggerFactory.getLogger(UserHandler.class);


    @Override
    public void insert(User user) {

        logger.info("insert message  {}", user);
        int id = user.getId();
        String name = user.getUserName();

        tUserService.setIds(id,name);
        ThreadContext.unbindSubject();
    }

    @Override
    public void update(User before, User after) {
        logger.info("update before {} ", before);
        logger.info("update after {}", after);
    }

    @Override
    public void delete(User user) {
        logger.info("delete  {}", user);
    }
}

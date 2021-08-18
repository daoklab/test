package com.daoklab.test.dbid.service;

import com.daoklab.test.dbid.commons.base.BaseMapper;
import com.daoklab.test.dbid.commons.base.BaseService;
import com.daoklab.test.dbid.dao.UserRandomKeyExtMapper;
import com.daoklab.test.dbid.domain.UserRandomKey;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * user_random_keyService 接口
 */
 @Service
public class UserRandomKeyService extends BaseService<UserRandomKey, Long> {

	@Resource
    private UserRandomKeyExtMapper userRandomKeyExtMapper;
	
    public BaseMapper<UserRandomKey, Long> getMapper() {
        return userRandomKeyExtMapper;
    }
}
package com.daoklab.test.dbid.service;

import com.daoklab.test.dbid.commons.base.BaseMapper;
import com.daoklab.test.dbid.commons.base.BaseService;
import com.daoklab.test.dbid.dao.UserUuidExtMapper;
import com.daoklab.test.dbid.domain.UserUuid;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * user_uuidService 接口
 */
 @Service
public class UserUuidService extends BaseService<UserUuid, Long> {

	@Resource
    private UserUuidExtMapper userUuidExtMapper;
	
    public BaseMapper<UserUuid, Long> getMapper() {
        return userUuidExtMapper;
    }
}
package com.daoklab.test.dbid.service;

import com.daoklab.test.dbid.commons.base.BaseMapper;
import com.daoklab.test.dbid.commons.base.BaseService;
import com.daoklab.test.dbid.dao.UserKeyAutoExtMapper;
import com.daoklab.test.dbid.domain.UserKeyAuto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * user_key_autoService 接口
 */
@Service
public class UserKeyAutoService extends BaseService<UserKeyAuto, Long> {

    @Resource
    private UserKeyAutoExtMapper userKeyAutoExtMapper;

    public BaseMapper<UserKeyAuto, Long> getMapper() {
        return userKeyAutoExtMapper;
    }
}
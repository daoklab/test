package com.daoklab.test.dbid.service;

import com.alibaba.fastjson.JSONObject;
import com.daoklab.test.dbid.commons.msg.ResultMessage;
import com.daoklab.test.dbid.commons.utils.SnowflakeIdWorker;
import com.daoklab.test.dbid.domain.UserKeyAuto;
import com.daoklab.test.dbid.domain.UserRandomKey;
import com.daoklab.test.dbid.domain.UserUuid;
import com.daoklab.test.dbid.utils.RandomValueUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName TestService
 * @Description TODO
 * @Author xianglin
 * @Date 2021/8/17 16:22
 * @Version V1.0
 */
@Service
public class TestService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserKeyAutoService userKeyAutoService;

    @Autowired
    private UserRandomKeyService userRandomKeyService;

    @Autowired
    private UserUuidService userUuidService;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    /**
     * 写入数据
     *
     * @return
     */
    public ResultMessage autoKey(Long sum) {
        sum = sum * 10000;
        if (sum == null || sum <= 0) {
            sum = 100000L;
        }
        long antoTime = autoKeyTableService(sum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("autoKey写入" + sum / 10000 + "W条数据耗费时间(ms)", antoTime);
        return ResultMessage.ResultSuccessMessage(jsonObject);
    }

    /**
     * 写入数据
     *
     * @return
     */
    public ResultMessage uuidKey(Long sum) {
        sum = sum * 10000;
        if (sum == null || sum <= 0) {
            sum = 100000L;
        }
        JSONObject jsonObject = new JSONObject();
        long uuidTime = uuidKeyTableService(sum);
        jsonObject.put("uuidKey写入" + sum / 10000 + "W条数据耗费时间(ms)", uuidTime);
        return ResultMessage.ResultSuccessMessage(jsonObject);
    }

    /**
     * 写入数据
     *
     * @return
     */
    public ResultMessage randomKey(Long sum) {
        sum = sum * 10000;
        if (sum == null || sum <= 0) {
            sum = 100000L;
        }
        JSONObject jsonObject = new JSONObject();
        long randomTime = randomKeyTableService(sum);
        jsonObject.put("randomKey写入" + sum / 10000 + "W条数据耗费时间(ms)", randomTime);
        return ResultMessage.ResultSuccessMessage(jsonObject);
    }

    /**
     * 自动生成key
     *
     * @param sum
     * @return
     */
    private long autoKeyTableService(Long sum) {

        // 组装写入数据
        List<UserKeyAuto> insertList = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            UserKeyAuto userKeyAuto = new UserKeyAuto();
            userKeyAuto.setUserName(RandomValueUtils.getChineseName());
            userKeyAuto.setSex(RandomValueUtils.getNum(0, 1));
            userKeyAuto.setAddress(RandomValueUtils.getRoad());
            userKeyAuto.setCity(RandomValueUtils.getCity());
            userKeyAuto.setEmail(RandomValueUtils.getEmail(6, 8));
            userKeyAuto.setState(0);
            insertList.add(userKeyAuto);
        }

        long start1 = System.currentTimeMillis();
        int insertSum = userKeyAutoService.insertEntryBatch(insertList);
        long end1 = System.currentTimeMillis();
        LOGGER.warn(MessageFormat.format("auto key消耗的时间:{0}毫秒", (end1 - start1)));
        return end1 - start1;
    }

    /**
     * UUID的key
     *
     * @param sum
     * @return
     */
    private long uuidKeyTableService(Long sum) {
        long start = System.currentTimeMillis();
        // 组装写入数据
        List<UserUuid> insertList = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            UserUuid userUuid = new UserUuid();
//            userUuid.setUserId(UUID.randomUUID().toString());
            userUuid.setUserName(RandomValueUtils.getChineseName());
            userUuid.setSex(RandomValueUtils.getNum(0, 1));
            userUuid.setAddress(RandomValueUtils.getRoad());
            userUuid.setCity(RandomValueUtils.getCity());
            userUuid.setEmail(RandomValueUtils.getEmail(6, 8));
            userUuid.setState(0);
            insertList.add(userUuid);
        }
        long end = System.currentTimeMillis();
        LOGGER.info(MessageFormat.format("准备数据耗时:{0}毫秒", end - start));

        long start1 = System.currentTimeMillis();
        int insertSum = userUuidService.insertEntryBatch(insertList);
        long end1 = System.currentTimeMillis();
        LOGGER.warn(MessageFormat.format("UUID key消耗的时间:{0}毫秒", (end1 - start1)));
        return end1 - start1;

    }

    /**
     * 随机的long值key
     *
     * @param sum
     * @return
     */
    private long randomKeyTableService(Long sum) {

        // 组装写入数据
        List<UserRandomKey> insertList = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            UserRandomKey userRandomKey = new UserRandomKey();
            userRandomKey.setUserId(snowflakeIdWorker.nextId());
            userRandomKey.setUserName(RandomValueUtils.getChineseName());
            userRandomKey.setSex(RandomValueUtils.getNum(0, 1));
            userRandomKey.setAddress(RandomValueUtils.getRoad());
            userRandomKey.setCity(RandomValueUtils.getCity());
            userRandomKey.setEmail(RandomValueUtils.getEmail(6, 8));
            userRandomKey.setState(0);
            insertList.add(userRandomKey);
        }

        long start1 = System.currentTimeMillis();
        long insertSum = userRandomKeyService.insertEntryBatch(insertList);
        long end1 = System.currentTimeMillis();
        LOGGER.warn(MessageFormat.format("随机key任务消耗时间:{0}毫秒", (end1 - start1)));
        return end1 - start1;
    }

}

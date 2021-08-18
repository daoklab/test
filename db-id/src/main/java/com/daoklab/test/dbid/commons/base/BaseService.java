package com.daoklab.test.dbid.commons.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * service基类<实体,主键>
 *
 * @since 2020-03-18
 */
public abstract class BaseService<T, KEY extends Serializable> {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * 获取DAO操作类
     */
    public abstract BaseMapper<T, KEY> getMapper();

    public int insertEntry(T t) {
        if (t == null) {
            return 0;
        }
        return getMapper().insertEntry(t);
    }

    public int insertEntry(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int count = 0;
        for (T t : list) {
            count += getMapper().insertEntry(t);
        }
        return count;
    }

    public int insertEntryBatch(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return getMapper().insertEntryBatch(list);
    }

    public int deleteByKey(KEY key) {
        return getMapper().deleteByKey(key);
    }

    public int deleteByArrayKey(KEY[] key) {
        return getMapper().deleteByArrayKey(key);
    }

    public int deleteByKey(T condtion) {
        return getMapper().deleteByKey(condtion);
    }

    public int deleteByKeyLogic(T condtion) {
        return getMapper().deleteByKeyLogic(condtion);
    }

    public int updateByKey(T condtion) {
        if (condtion == null) {
            return 0;
        }
        return getMapper().updateByKey(condtion);
    }

    public int updateByKeyNotDelete(T condtion) {
        if (condtion == null) {
            return 0;
        }
        return getMapper().updateByKeyNotDelete(condtion);
    }

    public boolean saveOrUpdate(T t) {
        Long id = 0L;
        try {
            Class<?> clz = t.getClass();
            id = (Long)clz.getMethod("getWorkOrderNo").invoke(t);
        } catch (Exception e) {
            LOGGER.warn("获取对象主键值失败!");
        }
        if (id > 0) {
            return updateByKey(t) > 0;
        }
        return insertEntry(t) > 0;
    }

    public T selectEntry(KEY key) {
        return getMapper().selectEntry(key);
    }

    public T selectEntryOne(T condtion) {
        List<T> list = getMapper().selectEntryList(condtion);
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    public List<T> selectEntryList(T condtion) {
        return getMapper().selectEntryList(condtion);
    }

    public List<T> selectSimpleEntryList(T condtion) {
        return getMapper().selectSimpleEntryList(condtion);
    }

    /**
     * 查询数据总数
     *
     * @param condtion
     * @return
     */
    public Integer selectEntryListCount(T condtion) {
        Integer size = getMapper().selectEntryListCount(condtion);

        return size;
    }

    /**
     * 限制字符串长度
     *
     * @param s
     * @param maxLength
     * @return
     */
    public String limitStringLength(String s, int maxLength) {
        if (s == null)
            return "";
        if (s.length() > maxLength) {
            return s.substring(0, maxLength);
        }
        return s;
    }

    public int deleteByCondtion(T condtion) {
        return getMapper().deleteByCondtion(condtion);
    }

}

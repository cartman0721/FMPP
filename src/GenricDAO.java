/**
 * Project: agds.dal
 * 
 * File Created at 2011-8-2
 * $Id$
 * 
 * Copyright 1999-2100 Alibaba.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */


import java.util.List;

import com.alifi.agds.common.model.Entity;
import com.alifi.agds.common.model.Pagination;
import com.alifi.agds.common.searchparam.PageParam;
import com.alifi.agds.dal.dao.condition.QueryCondition;

/**
 * DAO基类接口 <br>
 * 
 * @author tingjia.chentj
 */
/**
 * TODO Comment of GenricDAO
 * @author bangis.wangdf
 *
 * @param <T>
 */
/**
 * TODO Comment of GenricDAO
 * @author bangis.wangdf
 *
 * @param <T>
 */
public interface GenricDAO<T extends Entity> {
    public static String COUNT="Count"; 
    /**
     * 新增记录
     * 
     * @param entity 被插入的实体,本方法不检查参数有效性
     * @return
     */
    T insert(T entity);

    /**
     * 根据唯一标识删除记录
     * 
     * @param id
     */
    void deleteById(Long id);

    /**
     * 修改记录
     * 
     * @param entity 被更新的实体,本方法不检查参数有效性
     */
    void update(T entity);

    /**
     * 根据唯一标识获取记录
     * 
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 根据参数获取一条记录
     * @param statementName
     * @param parameterObject
     * @return
     */
    T queryForObject(final String statementName, final Object parameterObject);
    /**
     * 
     * @param statementName
     * @param parameterObject
     * @return
     */
    Object queryxForObject(final String statementName, final Object parameterObject);
    
    /**
     * @param <E>
     * @param classz
     * @param statementName
     * @param parameterObject
     * @return
     */
    <E> E queryForObject(Class<E> classz, final String statementName, final Object parameterObject);
    
    /**
     * 根据参数获取记录
     * @param statementName
     * @param parameterObject
     * @return
     */
    List<T> selectForList(final String statementName, final Object parameterObject);
    
    /**
     * 根据参数获取记录
     * @param statementName
     * @param parameterObject
     * @return
     */
    public List selectForObjectList(final String statementName, final Object parameterObject);
    
    /**
     * 根据条件获取记录
     * 
     * @param condition
     * @return
     */
    List<T> selectByCondition(QueryCondition condition);

    /**
     * 统计符合条件的记录数
     * 
     * @param condition
     * @return
     */
    int countByCondition(QueryCondition condition);

    /**
     * 以分页的方式根据条件获取记录
     * 
     * @param condition
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<T> selectByCondition(QueryCondition condition, int pageNo, int pageSize);
    
    /**
     * statementName 查询 必须配置‘statementName’Count 的SQL
     * @param statementName
     * @param QueryCondition condition 必须添加 pageNo,pageSize
     * @return
     */
    Pagination<Object> queryForPage(final String statementName, final QueryCondition condition);
    
    Pagination<T> queryForPage(final String statementName, final PageParam param);
    
    <E> Pagination<E> queryForPage(Class<E> classz,final String statementName, final QueryCondition condition);

    <E> Pagination<E> queryForPage(Class<E> classz,final String statementName, final PageParam param);
}

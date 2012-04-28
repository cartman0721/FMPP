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


import java.util.Date;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alifi.agds.common.model.Entity;
import com.alifi.agds.common.model.Pagination;
import com.alifi.agds.common.searchparam.PageParam;
import com.alifi.agds.dal.dao.GenricDAO;
import com.alifi.agds.dal.dao.condition.QueryCondition;

/**
 * 基本接口的Ibatis实现
 * 
 * @author tingjia.chentj
 */
public abstract class GenricDAOImpl<T extends Entity> extends SqlMapClientDaoSupport implements GenricDAO<T> {

    /**
     * 获取实体Dao的Ibatis命名空间
     * 
     * @return
     */
    public abstract String getNamespace();

    /**
     * 获取Ibatis配置的SQL ID
     * 
     * @param statementName
     * @return
     */
    protected String getQualifiedStatementName(String statementName) {
        return new StringBuilder(getNamespace()).append(".").append(statementName).toString();
    }

    @Override
    public void deleteById(Long id) {
        getSqlMapClientTemplate().delete(getQualifiedStatementName("deleteById"), id);
    }

    @Override
    public T getById(Long id) {
        return (T) getSqlMapClientTemplate().queryForObject(getQualifiedStatementName("getById"), id);
    }

    @Override
    public T queryForObject(final String statementName, final Object parameterObject){
        return (T) getSqlMapClientTemplate().queryForObject(getQualifiedStatementName(statementName), parameterObject);
    }
    
    @Override
    public List<T> selectForList(final String statementName, final Object parameterObject){
        return (List<T>) getSqlMapClientTemplate().queryForList(getQualifiedStatementName(statementName), parameterObject);
    }
    
    @Override
    public List selectForObjectList(final String statementName, final Object parameterObject){
        return getSqlMapClientTemplate().queryForList(getQualifiedStatementName(statementName), parameterObject);
    }
    
    @Override
    public Object queryxForObject(final String statementName, final Object parameterObject){
        return  getSqlMapClientTemplate().queryForObject(getQualifiedStatementName(statementName), parameterObject);
    }
    
   
    @Override
    public <E> E queryForObject(Class<E> classz, String statementName, Object parameterObject) {
        return (E)getSqlMapClientTemplate().queryForObject(getQualifiedStatementName(statementName), parameterObject);
    }

    /**
     * statementName 查询 必须配置‘statementName’Count 的SQL
     * @param statementName
     * @param QueryCondition condition 必须添加 pageNo,pageSize
     * @return
     */
    @Override
    public Pagination<Object> queryForPage(final String statementName, final QueryCondition condition){
        Long count = (Long)getSqlMapClientTemplate().queryForObject(getQualifiedStatementName(statementName+COUNT),condition.asMap());
        List<Object> data= getSqlMapClientTemplate().queryForList(getQualifiedStatementName(statementName), condition.asMap());
        Pagination<Object> page = new Pagination<Object>(condition.get("pageNo", Integer.class),condition.get("pageSize", Integer.class));
        page.setTotal(count.intValue());
        page.setData(data);
        return page;
    }
    
    /**
     * statementName 查询 必须配置‘statementName’Count 的SQL
     * @param statementName
     * @param QueryCondition condition 必须添加 pageNo,pageSize
     * @return
     */
    @Override
    public Pagination<T> queryForPage(final String statementName, final PageParam param){
        Long count = (Long)getSqlMapClientTemplate().queryForObject(getQualifiedStatementName(statementName+COUNT),param);
        List<T> data= getSqlMapClientTemplate().queryForList(getQualifiedStatementName(statementName), param);
        Pagination<T> page = new Pagination<T>(param.getPageNumber(),param.getLength());//condition.get("pageNo", Integer.class),condition.get("pageSize", Integer.class));
        page.setTotal(count.intValue());
        page.setData(data);
        return page;
    }
    
    /**
     * statementName 查询 必须配置‘statementName’Count 的SQL
     * @param statementName
     * @param QueryCondition condition 必须添加 pageNo,pageSize
     * @return
     */
    @Override
    public  <E> Pagination<E> queryForPage(Class<E> classz,final String statementName, final QueryCondition condition){
        Long count = (Long)getSqlMapClientTemplate().queryForObject(getQualifiedStatementName(statementName+COUNT),condition.asMap());
        List<E> data= getSqlMapClientTemplate().queryForList(getQualifiedStatementName(statementName), condition.asMap());
        Pagination<E> page = new Pagination<E>(condition.get("pageNo", Integer.class),condition.get("pageSize", Integer.class));
        page.setTotal(count.intValue());
        page.setData(data);
        return page;
    }
    
    /**
     * statementName 查询 必须配置‘statementName’Count 的SQL
     * @param statementName
     * @return
     */
    @Override
    public  <E> Pagination<E> queryForPage(Class<E> classz,final String statementName, final PageParam param){
        Long count = (Long)getSqlMapClientTemplate().queryForObject(getQualifiedStatementName(statementName+COUNT),param);
        @SuppressWarnings("unchecked")
        List<E> data= getSqlMapClientTemplate().queryForList(getQualifiedStatementName(statementName), param);
        Pagination<E> page = new Pagination<E>(param.getPageNumber(),param.getLength());//condition.get("pageNo", Integer.class),condition.get("pageSize", Integer.class));
        page.setTotal(count.intValue());
        page.setData(data);
        return page;
    }
    
    @Override
    public T insert(T entity) {
        Date currentDate = new Date();
        if(entity.getGmtCreated()==null){
            entity.setGmtCreated(currentDate);
        }
        if(entity.getGmtModified()==null){
            entity.setGmtModified(currentDate);
        }
        getSqlMapClientTemplate().insert(getQualifiedStatementName("insert"), entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        entity.setGmtModified(new Date());
        getSqlMapClientTemplate().update(getQualifiedStatementName("update"), entity);
    }

    @Override
    public List<T> selectByCondition(QueryCondition condition) {
        return (List<T>) getSqlMapClientTemplate().queryForList(getQualifiedStatementName("selectByCondition"),
                condition.asMap());
    }

    @Override
    public int countByCondition(QueryCondition condition) {
        return (Integer) getSqlMapClientTemplate().queryForObject(getQualifiedStatementName("countByCondition"),
                condition.asMap());
    }

    @Override
    public List<T> selectByCondition(QueryCondition condition, int pageNo, int pageSize) {
        if (pageNo <= 0 || pageSize <= 0) {
            int begin = (pageNo - 1) * pageSize + 1;
            condition.add("first", begin);
            condition.add("last", begin + pageSize);
        }
        return selectByCondition(condition);
    }

}

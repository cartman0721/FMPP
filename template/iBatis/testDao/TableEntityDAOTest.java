<#ftl  ns_prefixes={"a":"attribute","c":"collection","o":"object"}> 
<@pp.dropOutputFile />
<#list p.tables! as tab>
<@pp.changeOutputFile name="/${projectname}/src/test/java/" + pathUrl(tab.Package!) + "/dal/dao/" + CamelPeak(tab.Code)?cap_first + "DAOTest.java" />
<#setting datetime_format="yyyy-MM-dd">
/**
 * Project: ${projectname}
 * 
 * File Created at ${pp.now}
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
package ${tab.Package}.${dal};		

import java.math.BigDecimal;
import java.util.Date;
import ${tab.Package}.common.model.${CamelPeak(tab.Code)?cap_first};
import ${tab.Package}.dal.dao.${CamelPeak(tab.Code)?cap_first}DAO;
import ${tab.Package}.dal.test.SqlScriptPreparedDatabaseTransactionalTests;

<#setting datetime_format="yyyy-MM-dd HH:mm:ss">
/**
 * <li> ${tab.Name}</li>
 * 
 * @author ${p.author}
 * @generateTime ${pp.now}
 */

public class ${CamelPeak(tab.Code)?cap_first}DAOTest extends SqlScriptPreparedDatabaseTransactionalTests{
	private ${CamelPeak(tab.Code)?cap_first}DAO ${CamelPeak(tab.Code)}DAO;

    public void set${CamelPeak(tab.Code)?cap_first}DAO(${CamelPeak(tab.Code)?cap_first}DAO ${CamelPeak(tab.Code)}DAO) {
        this.${CamelPeak(tab.Code)}DAO = ${CamelPeak(tab.Code)}DAO;
    }
    
    public void testCURD() {
    	${CamelPeak(tab.Code)?cap_first} db = ${CamelPeak(tab.Code)}DAO.getById(new Long(1));
    	assertNotNull(db);
    	assertTrue(db.getId().longValue()==1);
    	assertTrue("test".equals(db.getGmtCreator()));
        ${CamelPeak(tab.Code)?cap_first} db1 = ${CamelPeak(tab.Code)}DAO.insert(initDB());
        assertNotNull(db1);
        assertTrue(db1.getId().longValue()>0);
        ${CamelPeak(tab.Code)?cap_first} db2 = ${CamelPeak(tab.Code)}DAO.getById(db1.getId());
        assertNotNull(db2);
        assertTrue("1".equals(db2.getGmtCreator()));
        ${CamelPeak(tab.Code)?cap_first} db3 = modifDB(db2);
        ${CamelPeak(tab.Code)}DAO.update(db3);
         ${CamelPeak(tab.Code)?cap_first} db4 = ${CamelPeak(tab.Code)}DAO.getById(db3.getId());
        assertNotNull(db4);
        assertTrue("m".equals(db4.getGmtModifier()));
        ${CamelPeak(tab.Code)}DAO.deleteById(new Long(1));
        ${CamelPeak(tab.Code)?cap_first} db5 = ${CamelPeak(tab.Code)}DAO.getById(new Long(1));
    	assertNull(db5);
    	
    }
    
    public ${CamelPeak(tab.Code)?cap_first} initDB(){
    	${CamelPeak(tab.Code)?cap_first} ${CamelPeak(tab.Code)} =  new ${CamelPeak(tab.Code)?cap_first}();
    	<#list tab.columns! as column>
    	<#if column.Code!="ID">
    		<#if getDatyType(column)=="String">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}("i");
    		<#elseif getDatyType(column)=="Long">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}(new Long(1));
    		<#elseif getDatyType(column)=="Date">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}(new Date());
    		<#elseif getDatyType(column)=="BigDecimal">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}(new BigDecimal(1));
    		</#if>
    	</#if>
    	</#list>
    	return ${CamelPeak(tab.Code)} ;	
    }
    public ${CamelPeak(tab.Code)?cap_first} modifDB(${CamelPeak(tab.Code)?cap_first} ${CamelPeak(tab.Code)}){
    	<#list tab.columns! as column>
    	<#if column.Code!="ID">
    		<#if getDatyType(column)=="String">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}("m");
    		<#elseif getDatyType(column)=="Long">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}(new Long(2));
    		<#elseif getDatyType(column)=="Date">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}(new Date());
    		<#elseif getDatyType(column)=="BigDecimal">
    			${CamelPeak(tab.Code)}.set${CamelPeak(column.Code)?cap_first}(new BigDecimal(2));
    		</#if>
    	</#if>
    	</#list>
    	return ${CamelPeak(tab.Code)} ;	
    }
    //TODO 这一坨是为了让单元测试回滚，注意改数据源(用在bean中配置的数据源)
    @Override
    protected void prepareTestInstance() throws Exception {
        if (getApplicationContext() == null) {
            throw new RuntimeException("ApplicationContext has not been configured for test [" + getClass().getName()
                    + "]: dependency injection will NOT be performed.");
        } else {
            setDependencyCheck(false);
            setAutowireMode(AUTOWIRE_BY_NAME);
         
            injectDependencies();
            setDataSource((DataSource) getApplicationContext().getBean("mysqlDataSource"));
            setTransactionManager((PlatformTransactionManager) getApplicationContext().getBean("mysqlTransactionManager"));
        }
    }
    
}
</#list>
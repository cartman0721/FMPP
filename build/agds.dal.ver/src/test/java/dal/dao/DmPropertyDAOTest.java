/**
 * Project: agds.dal.ver
 * 
 * File Created at 2012-05-22
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
package com.alifi.agds.dal.dmmanage.dao;		

import java.math.BigDecimal;
import java.util.Date;
import com.alifi.agds.common.model.DmProperty;
import com.alifi.agds.dal.dao.DmPropertyDAO;
import com.alifi.agds.dal.test.SqlScriptPreparedDatabaseTransactionalTests;

/**
 * <li> agds_dm_property</li>
 * 
 * @author dazuo.sundz
 * @generateTime 2012-05-22 10:16:21
 */

public class DmPropertyDAOTest extends SqlScriptPreparedDatabaseTransactionalTests{
	private DmPropertyDAO dmPropertyDAO;

    public void setDmPropertyDAO(DmPropertyDAO dmPropertyDAO) {
        this.dmPropertyDAO = dmPropertyDAO;
    }
    
    public void testCURD() {
    	DmProperty db = dmPropertyDAO.getById(new Long(1));
    	assertNotNull(db);
    	assertTrue(db.getId().longValue()==1);
    	assertTrue("test".equals(db.getGmtCreator()));
        DmProperty db1 = dmPropertyDAO.insert(initDB());
        assertNotNull(db1);
        assertTrue(db1.getId().longValue()>0);
        DmProperty db2 = dmPropertyDAO.getById(db1.getId());
        assertNotNull(db2);
        assertTrue("1".equals(db2.getGmtCreator()));
        DmProperty db3 = modifDB(db2);
        dmPropertyDAO.update(db3);
         DmProperty db4 = dmPropertyDAO.getById(db3.getId());
        assertNotNull(db4);
        assertTrue("m".equals(db4.getGmtModifier()));
        dmPropertyDAO.deleteById(new Long(1));
        DmProperty db5 = dmPropertyDAO.getById(new Long(1));
    	assertNull(db5);
    	
    }
    
    public DmProperty initDB(){
    	DmProperty dmProperty =  new DmProperty();
    			dmProperty.setPathId(new Long(1));
    			dmProperty.setPcode("i");
    			dmProperty.setPname("i");
    			dmProperty.setValidator("i");
    			dmProperty.setTag(new Long(1));
    			dmProperty.setDwTable("i");
    			dmProperty.setDwColumn("i");
    			dmProperty.setDescs("i");
    			dmProperty.setCreater("i");
    			dmProperty.setOperator("i");
    			dmProperty.setGmtCreate(new Date());
    			dmProperty.setGmtModified(new Date());
    			dmProperty.setInDate(new Date());
    			dmProperty.setSubmitDate(new Date());
    			dmProperty.setUpdFrequency("i");
    			dmProperty.setTimeliness("i");
    			dmProperty.setPriority("i");
    	return dmProperty ;	
    }
    public DmProperty modifDB(DmProperty dmProperty){
    			dmProperty.setPathId(new Long(2));
    			dmProperty.setPcode("m");
    			dmProperty.setPname("m");
    			dmProperty.setValidator("m");
    			dmProperty.setTag(new Long(2));
    			dmProperty.setDwTable("m");
    			dmProperty.setDwColumn("m");
    			dmProperty.setDescs("m");
    			dmProperty.setCreater("m");
    			dmProperty.setOperator("m");
    			dmProperty.setGmtCreate(new Date());
    			dmProperty.setGmtModified(new Date());
    			dmProperty.setInDate(new Date());
    			dmProperty.setSubmitDate(new Date());
    			dmProperty.setUpdFrequency("m");
    			dmProperty.setTimeliness("m");
    			dmProperty.setPriority("m");
    	return dmProperty ;	
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

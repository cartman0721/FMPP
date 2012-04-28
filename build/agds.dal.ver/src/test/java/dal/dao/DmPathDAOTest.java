/**
 * Project: agds.dal.ver
 * 
 * File Created at 2012-04-28
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
import com.alifi.agds.common.model.DmPath;
import com.alifi.agds.dal.dao.DmPathDAO;
import com.alifi.agds.dal.test.SqlScriptPreparedDatabaseTransactionalTests;

/**
 * <li> agds_dm_path</li>
 * 
 * @author dazuo.sundz
 * @generateTime 2012-04-28 13:46:32
 */

public class DmPathDAOTest extends SqlScriptPreparedDatabaseTransactionalTests{
	private DmPathDAO dmPathDAO;

    public void setDmPathDAO(DmPathDAO dmPathDAO) {
        this.dmPathDAO = dmPathDAO;
    }
    
    public void testCURD() {
    	DmPath db = dmPathDAO.getById(new Long(1));
    	assertNotNull(db);
    	assertTrue(db.getId().longValue()==1);
    	assertTrue("test".equals(db.getGmtCreator()));
        DmPath db1 = dmPathDAO.insert(initDB());
        assertNotNull(db1);
        assertTrue(db1.getId().longValue()>0);
        DmPath db2 = dmPathDAO.getById(db1.getId());
        assertNotNull(db2);
        assertTrue("1".equals(db2.getGmtCreator()));
        DmPath db3 = modifDB(db2);
        dmPathDAO.update(db3);
         DmPath db4 = dmPathDAO.getById(db3.getId());
        assertNotNull(db4);
        assertTrue("m".equals(db4.getGmtModifier()));
        dmPathDAO.deleteById(new Long(1));
        DmPath db5 = dmPathDAO.getById(new Long(1));
    	assertNull(db5);
    	
    }
    
    public DmPath initDB(){
    	DmPath dmPath =  new DmPath();
    			dmPath.setPcode("i");
    			dmPath.setPname("i");
    			dmPath.setParentId(new Long(1));
    			dmPath.setDescs("i");
    			dmPath.setGmtCreate(new Date());
    			dmPath.setGmtModified(new Date());
    			dmPath.setOperator("i");
    	return dmPath ;	
    }
    public DmPath modifDB(DmPath dmPath){
    			dmPath.setPcode("m");
    			dmPath.setPname("m");
    			dmPath.setParentId(new Long(2));
    			dmPath.setDescs("m");
    			dmPath.setGmtCreate(new Date());
    			dmPath.setGmtModified(new Date());
    			dmPath.setOperator("m");
    	return dmPath ;	
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

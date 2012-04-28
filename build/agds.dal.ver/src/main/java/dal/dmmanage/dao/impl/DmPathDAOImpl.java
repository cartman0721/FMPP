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
package com.alifi.agds.dal.dmmanage.dao.impl;		

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alifi.agds.common.dmmanage.model.DmPath;
import com.alifi.agds.dal.dmmanage.dao.DmPathDAO;
/**
 * <li> agds_dm_path</li>
 * 
 * @author dazuo.sundz
 * @generateTime 2012-04-28 13:46:32
 */

public class DmPathDAOImpl  extends GenricDAOImpl<DmPath> implements DmPathDAO{
    
    public String getNamespace() {
        return "AGDS_DM_PATH";
    }
}

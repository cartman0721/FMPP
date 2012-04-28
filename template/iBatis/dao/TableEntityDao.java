<#ftl  ns_prefixes={"a":"attribute","c":"collection","o":"object"}> 
<@pp.dropOutputFile />
<#list p.tables! as tab>
<@pp.changeOutputFile name="/${projectname}/src/main/java/" + pathUrl(tab.Package!) + "/" + pathUrlBak(dal) + "/" + CamelPeak(tab.Code)?cap_first + "DAO.java" />
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

import ${tab.Package}.${model}.${CamelPeak(tab.Code)?cap_first};
<#setting datetime_format="yyyy-MM-dd HH:mm:ss">
/**
 * <li> ${tab.Name}</li>
 * 
 * @author ${p.author}
 * @generateTime ${pp.now}
 */

public interface ${CamelPeak(tab.Code)?cap_first}DAO extends GenricDAO<${CamelPeak(tab.Code)?cap_first}>{

}
</#list>
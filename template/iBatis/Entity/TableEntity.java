<#ftl  ns_prefixes={"a":"attribute","c":"collection","o":"object"}> 
<#include "ExceptionColumn.ftl">
<@pp.dropOutputFile />
<#list p.tables! as tab>
<@pp.changeOutputFile name="/${projectname}/src/main/java/" + pathUrl(tab.Package!) + "/" + pathUrlBak(model) + "/" + CamelPeak(tab.Code)?cap_first + ".java" />
package ${tab.Package}.${model};		
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
<#setting datetime_format="yyyy-MM-dd HH:mm:ss">
/**
 * <li> 表名： ${tab.Name}</li>
 * @author ${p.author}
 * @generateTime ${pp.now}
 */

public class ${CamelPeak(tab.Code)?cap_first} extends Entity implements Serializable{
    /**
     * 表名
     */
    public static final String TABLE_NAME = "${tab.Code?upper_case}";
    
    
<#--属性-->
	<#list tab.columns! as column>
	<#if isNotException(column.Code)>
	private ${getDatyType(column)} ${CamelPeak(column.Code)}; //${column.Name}
	</#if>
	</#list>
<#--get Set 方法-->
	<#list tab.columns! as column>
	<#if isNotException(column.Code)>
	/**
	 * <li>${column.Name}</li>
	 * 
	 * @return ${getDatyType(column)}
	 */
	public ${getDatyType(column)} get${CamelPeak(column.Code)?cap_first}(){
		return this.${CamelPeak(column.Code)};
	}
	
	/**
	 * <li> ${column.Name} <#if column.Comment?? && column.Comment!=column.Name>${column.Comment}</#if></li>
	 * 
	 * @param  ${CamelPeak(column.Code)}
	 */
	public void set${CamelPeak(column.Code)?cap_first}(${getDatyType(column)} ${CamelPeak(column.Code)}){
		this.${CamelPeak(column.Code)}=${CamelPeak(column.Code)};
	}
	</#if>
	</#list>
	
}
</#list>
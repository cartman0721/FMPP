<#ftl  ns_prefixes={"a":"attribute","c":"collection","o":"object"}> 
<@pp.dropOutputFile />
<#list p.tables! as tab>
<@pp.changeOutputFile name="/${projectname}/src/test/resources/sql/" + CamelPeak(tab.Code)?cap_first + "DAOTest.sql" />
delete from ${tab.Code} where id=1;
<#if database == "oracle">
select SEQ_${tab.Code}.nextval from dual;
</#if>
insert into ${tab.Code} (
		<#list tab.columns! as column>
		<#if column_index==0>${column.Code}<#else>,${column.Code}</#if>
		</#list>
		)
	  values (
	  	<#list tab.columns! as column>
		<#if column_index==0>
		1
		<#else>		
			<#if getSqlMapType(column)="DECIMAL">
		,1 		    
			<#elseif getSqlMapType(column)="INTEGER">
		,1
			<#elseif getSqlMapType(column)="VARCHAR">
		,'test'
			<#elseif getSqlMapType(column)="TIMESTAMP">
				<#if database == "oracle">
				,sysdate
				<#else>	
				,sysdate()
				</#if>
			<#else>
			      ,1
			</#if>
		</#if>
		</#list>
	    );
</#list>
<#ftl  ns_prefixes={"a":"attribute","c":"collection","o":"object"}> 
<#--用于提出字段-->
<@pp.dropOutputFile />

<#function isNotException Code>
	<#list ExceptionColumns as col>
		<#if col==Code>
			<#return false>
		</#if>
	</#list>
	<#return true>
</#function>
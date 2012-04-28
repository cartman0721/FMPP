<#global p = pp.newWritableHash()>
<#global packages = pdm.Model["o:RootObject"]["c:Children"]["o:Model"]["c:Packages"]>
<#setting datetime_format="yyyy-MM-dd HH:mm:ss">


<#--骆驼峰 首字母小写-->
<#function CamelPeakBak Code>
	<#assign ColNames=Code?split("_")>
	<#assign ColName="">
	<#list ColNames as Col>
		<#if Col_index?number==0>
		<#assign ColName=ColName+Col?lower_case>
		<#else>
		<#assign ColName=ColName+Col?lower_case?cap_first>
		</#if>
	</#list>
	<#return ColName>
</#function>

<#--骆驼峰 删除前缀 首字母小写-->
<#function CamelPeak Code>
	<#assign ColNames=Code?split("_")>
	<#if isPrefix(ColNames[0]?lower_case)>
		<#assign start=1>
	<#else>
		<#assign start=0>
	</#if>
	<#assign ColName="">
	<#list ColNames as Col>
		<#if Col_index?number==start>
			<#assign ColName=ColName+Col?lower_case>
		<#elseif Col_index gt start>
			<#assign ColName=ColName+Col?lower_case?cap_first>
		</#if>
	</#list>
	<#return ColName>
</#function>

<#--判断前缀-->
<#function isPrefix cd>
	<#list RMPrefix as pre>
		<#if cd==pre?lower_case>
			<#return true>
		</#if>
	</#list>
	<#return false>
</#function>

<#--剔除不需要的字段-->
<#function isNotException Code>
	<#list ExceptionColumns as col>
		<#if col==Code>
			<#return false>
		</#if>
	</#list>
	<#return true>
</#function>

<#--DB type to SqlMap.xml Type-->
<#function getSqlMapType column>
<#assign dateType=column.DataType>
<#list dbTypes as dbType>
	<#if dbType.db==database>
		<#list dbType.types as type>
			<#assign dateType = dateType?lower_case>
			<#assign dlength = dateType?length>
			<#assign db_Type = type.dbType?lower_case>
			<#assign tlength = type.dbType?length>
			<#if dlength==tlength && dateType == db_Type>
				<#return type.ibatisType>
			<#elseif dlength gt tlength>
				<#list 0..dlength-tlength as i>
					<#if dateType?string[i..tlength+i-1]==db_Type>
						<#return type.ibatisType>
					</#if>
				</#list>
			</#if>
		</#list>
     </#if>
</#list>
<#return default_IbatisType>
</#function>

<#--DB type to Java Type-->
<#function getDatyType column>
<#assign dateType=column.DataType>
<#---->
<#if column.Code?lower_case=="id" && 
dateType?lower_case?contains("number")?string=="true">
<#return "Long">
</#if>

	<#if (column.Name?ends_with("主键")?string=="true"  
		|| column.Code?upper_case?ends_with("ID")?string =="true")
		&& dateType?lower_case?contains("number")?string=="true">
	  		<#return "Long">
	</#if>
	
	<#list TypeLongColumnsPrefix as col>
		<#if column.Code?length gt col?length && column.Code?upper_case?substring(0,col?length)== col?upper_case>
			<#return "Long">
		</#if>
	</#list>

<#---->
<#list dbTypes as dbType>
	<#if dbType.db==database>
		<#list dbType.types as type>
			<#assign dateType = dateType?lower_case>
			<#assign dlength = dateType?length>
			<#assign db_Type = type.dbType?lower_case>
			<#assign tlength = type.dbType?length>
			<#if dlength==tlength && dateType == db_Type>
				<#return type.javaType>
			<#elseif dlength gt tlength>
				<#list 0..dlength-tlength as i>
					<#if dateType?string[i..tlength+i-1]==db_Type>
						<#return type.javaType>
					</#if>
				</#list>
			</#if>
		</#list>
     </#if>
</#list>
<#return default_JavaType>
</#function>

<#--visit macro 两者结合使用 -->
<#visit pdm.Model["o:RootObject"]["c:Children"]["o:Model"]>

<#macro "o:Model">
	<@pp.set hash=p key="author" value=default_author!"孙大作" />
	<@pp.set hash=p key="Creator" value=default_Creator!"孙大作" />
	<@pp.set hash=p key="Modifier" value=default_Modifier!"孙大作" />
	<#--解析o:Model下表-->
	<#if .node["c:Tables"]?size gt 0>
	    <#--使用默认包-->
		<#global package = default_package!"com.bangis.project">
		<#visit .node["c:Tables"]>
	</#if>
	<#--解析o:Model下视图-->
	<#if .node["c:Views"]?size gt 0>
	    <#--使用默认包-->
		<#global package = default_package!"com.bangis.project">
		<#visit .node["c:Views"]>
	</#if>
	<#--解析c:Packages-->
	<#if .node["c:Packages"]?size gt 0>
		<#visit .node["c:Packages"]>
	</#if>
</#macro>

<#macro "c:Packages">
	<#list .node["o:Package"]! as pg>
		<#--对应关系-->
		<#if pg["c:References"]?size gt 0>
			<#visit pg["c:References"]>
		</#if>
	    <#--使用默认包-->
		<#assign package = pg["a:Code"]>
		<#--解析o:Package下表-->
		<#visit pg["c:Tables"]>
	</#list>
	
</#macro>


<#macro "c:Tables">
	<#--解析c:Tables-->
	<#if .node["o:Table"]?size gt 0>
		<#list .node["o:Table"]! as item>
			<#if !p.tables??>
				<@pp.set hash=p key="tables" value=pp.newWritableSequence()/>
			</#if>
			<@pp.add seq=p.tables index=item_index value=pp.newWritableHash()/>
		    <#assign table_var=p.tables[item_index]>
		    <#visit item>
		</#list>
	</#if>
</#macro>
<#macro "o:Table">
	<#--解析o:Table-->
	<#list .node.@@! as a>
		<@pp.set hash=table_var key=a?node_name value=a />
	</#list>
	<#--表名-->
	<@pp.set hash=table_var key="Name" value=.node["a:Name"] />
	<#--代码-->
	<@pp.set hash=table_var key="Code" value=.node["a:Code"]?upper_case />
	<#--注释-->
	<#if .node["a:Comment"]??>
		<@pp.set hash=table_var key="Comment" value=.node["a:Comment"] />
	</#if>
	<#--创建者-->
	<@pp.set hash=table_var key="Creator" value=.node["a:Creator"] />
	<#--修改者-->
	<@pp.set hash=table_var key="Modifier" value=.node["a:Modifier"] />
	<#--所属包-->
	<@pp.set hash=table_var key="Package" value=package />
	
	<#--解析Column -->
	<#if !table_var.columns??>
		<@pp.set hash=table_var key="columns" value=pp.newWritableSequence()/>
	</#if>
	<#list .node["c:Columns"]["o:Column"]! as column>
		<@pp.add seq=table_var.columns index=column_index value=pp.newWritableHash()/>
		<#assign column_var=table_var.columns[column_index]>
		<#visit column>
	</#list>
</#macro>

<#macro "o:Column">
	<#--字段-->
	<@pp.set hash=column_var key="Id" value=.node.@Id />
	<@pp.set hash=column_var key="Name" value=.node["a:Name"] />
	<#if .node["a:Length"]?size gt 0>
	<@pp.set hash=column_var key="Length" value=.node["a:Length"] />
	</#if>
	<#if .node["a:Mandatory"]?size gt 0>
	<@pp.set hash=column_var key="Mandatory" value=.node["a:Mandatory"] />
	</#if>
	<@pp.set hash=column_var key="Code" value=.node["a:Code"]?upper_case />
	<#if .node["a:DataType"]?size gt 0>
		<@pp.set hash=column_var key="DataType" value=.node["a:DataType"] />
	<#else>
		<@pp.set hash=column_var key="DataType" value="varchar" />
	</#if>
	<#--注释-->
	<#if .node["a:Comment"]?size gt 0>
		<@pp.set hash=column_var key="Comment" value=.node["a:Comment"] />
	</#if>
</#macro>

<#macro "c:Views">
	<#--解析c:Views-->
	<#if .node["o:View"]?size gt 0>
		<#list .node["o:View"]! as item>
			<#if !p.views??>
				<@pp.set hash=p key="views" value=pp.newWritableSequence()/>
			</#if>
			<@pp.add seq=p.views index=item_index value=pp.newWritableHash()/>
		    <#assign view_var=p.views[item_index]>
		    <#visit item>
		</#list>
	</#if>
</#macro>


<#macro "o:View">
	<#--解析o:View-->
	<#list .node.@@! as a>
		<@pp.set hash=view_var key=a?node_name value=a />
	</#list>
	<#--表名-->
	<@pp.set hash=view_var key="Name" value=.node["a:Name"] />
	<#--代码-->
	<@pp.set hash=view_var key="Code" value=.node["a:Code"]?upper_case />
	<#--创建者-->
	<@pp.set hash=view_var key="Creator" value=.node["a:Creator"] />
	<#--修改者-->
	<@pp.set hash=view_var key="Modifier" value=.node["a:Modifier"] />
	<#--所属包-->
	<@pp.set hash=view_var key="Package" value=package />
	
	<#--解析Column -->
	<#if !view_var.columns??>
		<@pp.set hash=view_var key="columns" value=pp.newWritableSequence()/>
	</#if>
	<#list .node["c:Columns"]["o:ViewColumn"]! as column>
		<@pp.add seq=view_var.columns index=column_index value=pp.newWritableHash()/>
		<#assign column_var=view_var.columns[column_index]>
		<#visit column>
	</#list>
</#macro>
<#macro "o:ViewColumn">
	<#--字段-->
	<@pp.set hash=column_var key="Id" value=.node.@Id />
	<@pp.set hash=column_var key="Name" value=.node["a:Name"] />
	<#if .node["a:Length"]?size gt 0>
		<@pp.set hash=column_var key="Length" value=.node["a:Length"] />
	</#if>
	<#if .node["a:Mandatory"]?size gt 0>
	<@pp.set hash=column_var key="Mandatory" value=.node["a:Mandatory"] />
	</#if>
	<#assign isdate=.node["a:Code"]?lower_case?index_of("rq")>
	<@pp.set hash=column_var key="Code" value=.node["a:Code"]?upper_case />
	<#if .node["a:DataType"]?size gt 0>
	<@pp.set hash=column_var key="DataType" value=.node["a:DataType"] />
	<#elseif isdate gt 0>
	<@pp.set hash=column_var key="DataType" value="DATE" />
	<#else>
	<@pp.set hash=column_var key="DataType" value="String" />
	</#if>
</#macro>


<#function pathUrl package>
	<#return "">	
</#function>

<#function pathUrlBak package>
	<#return package?replace(".", "/")>	
</#function>


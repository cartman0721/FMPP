<#global p = pp.newWritableHash()>
<#global packages = pdm.Model["o:RootObject"]["c:Children"]["o:Model"]["c:Packages"]>
<#setting datetime_format="yyyy-MM-dd HH:mm:ss">

<#function getDatyType dateType>
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
<#return default_Type>
</#function>

<#visit pdm.Model["o:RootObject"]["c:Children"]["o:Model"]>

<#macro "o:Model">
	<@pp.set hash=p key="author" value=default_author!"王德峰" />
	<@pp.set hash=p key="Creator" value=default_Creator!"王德峰" />
	<@pp.set hash=p key="Modifier" value=default_Modifier!"王德峰" />
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
	<#--解析c:References对应关系-->
	<#if .node["c:References"]?size gt 0>
		<#visit .node["c:References"]>
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

<#macro "c:References">
	<#--解析c:References-->
	<#if .node["o:Reference"]?size gt 0>
		<#list .node["o:Reference"]! as reference>
			<#if !p.references??>
				<@pp.set hash=p key="references" value=pp.newWritableSequence()/>
			</#if>
			<@pp.add seq=p.references index=reference_index value=pp.newWritableHash()/>
		    <#assign reference_var=p.references[reference_index]>
		    <#visit reference>
		</#list>
	</#if>
</#macro>


<#macro "o:Reference">
	<#--解析o:Reference-->
	<#list .node.@@! as a>
		<@pp.set hash=reference_var key=a?node_name value=a />
	</#list>
	<#--关系名-->
	<@pp.set hash=reference_var key="Name" value=.node["a:Name"] />
	<#--关系Code-->
	<@pp.set hash=reference_var key="Code" value=.node["a:Code"] />
	<#--对应关系码-->
	<@pp.set hash=reference_var key="Cardinality" value=.node["a:Cardinality"] />
	<#--更新级联-->
	<@pp.set hash=reference_var key="UpdateConstraint" value=.node["a:UpdateConstraint"] />
	<#--删除级联-->
	<@pp.set hash=reference_var key="DeleteConstraint" value=.node["a:DeleteConstraint"] />
	<#--父表-->
	<@pp.set hash=reference_var key="ParentTable" value=.node["c:ParentTable"]["o:Table"].@Ref />
	<#--父表字段-->
	<@pp.set hash=reference_var key="ParentTableColumn" value=.node["c:Joins"]["o:ReferenceJoin"]["c:Object1"]["o:Column"].@Ref />
	<#--子表-->
	<@pp.set hash=reference_var key="ChildTable" value=.node["c:ChildTable"]["o:Table"].@Ref />
	<#--子表字段-->
	<@pp.set hash=reference_var key="ChildTableColumn" value=.node["c:Joins"]["o:ReferenceJoin"]["c:Object2"]["o:Column"].@Ref />
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
	<@pp.set hash=table_var key="Code" value=.node["a:Code"] />
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
	
	<#--解析key -->
	<#if !table_var.keys??>
		<@pp.set hash=table_var key="keys" value=pp.newWritableSequence()/>
	</#if>
	<#list .node["c:Keys"]["o:Key"]["c:Key.Columns"]["o:Column"]! as key>
		<@pp.add seq=table_var.keys index=key_index value=pp.newWritableHash()/>
		<#assign key_var=table_var.keys[key_index]> 
		<#assign pk = .node["//o:Column[@Id='${key.@Ref}']"]>
		<@pp.set hash=key_var key="Id" value=key.@Ref />
		<@pp.set hash=key_var key="Name" value=pk["a:Name"] />
		<@pp.set hash=key_var key="Code" value=pk["a:Code"] />
		<@pp.set hash=key_var key="DataType" value=pk["a:DataType"] />
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
	<@pp.set hash=column_var key="Code" value=.node["a:Code"] />
	<@pp.set hash=column_var key="DataType" value=.node["a:DataType"] />
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
	<@pp.set hash=view_var key="Code" value=.node["a:Code"] />
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
	
	<#--解析key -->
	<#if !view_var.keys??>
		<@pp.set hash=view_var key="keys" value=pp.newWritableSequence()/>
	</#if>
	<#list .node["c:Keys"]["o:Key"]["c:Key.Columns"]["o:ViewColumn"]! as key>
		<@pp.add seq=view_var.keys index=key_index value=pp.newWritableHash()/>
		<#assign key_var=view_var.keys[key_index]> 
		<#assign pk = .node["//o:ViewColumn[@Id='${key.@Ref}']"]>
		<@pp.set hash=key_var key="Id" value=key.@Ref />
		<@pp.set hash=key_var key="Name" value=pk["a:Name"] />
		<@pp.set hash=key_var key="Code" value=pk["a:Code"] />
		<@pp.set hash=key_var key="DataType" value=pk["a:DataType"] />
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
	<@pp.set hash=column_var key="Code" value=.node["a:Code"] />
	<#if .node["a:DataType"]?size gt 0>
	<@pp.set hash=column_var key="DataType" value=.node["a:DataType"] />
	<#elseif isdate gt 0>
	<@pp.set hash=column_var key="DataType" value="DATE" />
	<#else>
	<@pp.set hash=column_var key="DataType" value="String" />
	</#if>
</#macro>

<#--tables转Entitys-->
<#list p.tables! as tab>
	<#if !p.entities??>
		<@pp.set hash=p key="entities" value=pp.newWritableSequence()/>
		<#assign table_index=0>
	</#if>
    <#if !isManyToMany(tab)>
		<@pp.add seq=p.entities index=table_index value=pp.newWritableHash()/>
		<#assign entity_var=p.entities[table_index]>
		<#assign table_index=table_index+1>
		<#--package包-->
		<@pp.set hash=entity_var key="package" value=tab.Package />
		<#--表名-->
		<@pp.set hash=entity_var key="tabName" value=tab.Name />
		<#--类名-->
		<@pp.set hash=entity_var key="class" value=tab.Code?cap_first />
		<#--Id-->
		<@pp.set hash=entity_var key="id" value=pp.newWritableHash()/>
		<#list tab.keys! as key>
			<@pp.set hash=entity_var.id key="name" value=key.Name />
			<@pp.set hash=entity_var.id key="code" value=key.Code />
			<@pp.set hash=entity_var.id key="type" value=getDatyType(key.DataType) />
		</#list>
		<#--核心解析onetoone-->
	    <@onetoone tab.Id/>
	    <#--核心解析onetomany-->
	    <@onetomany tab.Id/>
	    <#--核心解析manytomany-->
	    <@manytomany tab/>
	    ${tab.Code}
		<#list tab.columns! as cln>
		    <#--核心解析manytoone-->
	    	<@manytoone tab.Id cln/>
	    	<#--核心解析onetooneM-->
	    	<@onetooneM tab.Id cln/>
	    	<#--核心解析properties-->
			<#if !entity_var.properties??>
				<@pp.set hash=entity_var key="properties" value=pp.newWritableSequence()/>
				<#assign property_index=0>
			</#if>
			<#if isNotKey(tab,cln) && isNotXToX(tab,cln)>
				<@pp.add seq=entity_var.properties index=property_index value=pp.newWritableHash()/>
				<#assign property_var=entity_var.properties[property_index]>
				<#assign property_index=property_index+1>
				<@pp.set hash=property_var key="type" value=getDatyType(cln.DataType) />
				<@pp.set hash=property_var key="name" value=cln.Code?lower_case /> 
				<@pp.set hash=property_var key="length" value=cln.Length!0 />
				<@pp.set hash=property_var key="nullable" value=cln.Mandatory!0 />
				<@pp.set hash=property_var key="clnName" value=cln.Name />
			</#if>
		</#list>
   </#if>
</#list>
<#--字段是主键-->
<#function isNotKey tab cln>
	<#list tab.keys! as key>
		<#if key.Code==cln.Code>
			<#return false>
		</#if>
	</#list>
	<#return true>
</#function>
<#--XXXXXXXXX-->
<#function isNotXToX tab cln>
	<#list p.references! as rs>
	   	<#if rs.ChildTable==tab.Id && rs.ChildTableColumn==cln.Id>
	   		<#return false>
	   	</#if>
	</#list>
	<#return true>
</#function>
<#--通过Id得到Table-->
<#function getTable tbId>
   <#list p.tables! as tab>
   		<#if tab.Id==tbId>
   			<#return tab>
   		</#if>
	</#list>
</#function>
<#--通过Id得到Table中字段-->
<#function getColumn tab clnId>
	<#list tab.columns! as cln>
		<#if cln.Id==clnId>
   			<#return cln>
   		</#if>
	</#list>
	<#return "null">
</#function>
<#--通过Id得到Many2Many关联表中Table另外字段-->
<#function getJoinColumn tab clnId>
	<#list tab.columns! as cln>
		<#if cln.Id!=clnId>
   			<#return cln>
   		</#if>
	</#list>
	<#return "null">
</#function>
<#--根据Many2Many关联表中Table字段得到另外表-->
<#function getInverseJoinTable tabId clnId>
	<#list p.references! as rs>
	   	<#if rs.ChildTable==tabId && rs.ChildTableColumn==clnId && (rs.Cardinality=="1..*" || rs.Cardinality=="0..*")>
	   		<#return getTable(rs.ParentTable)>
	   	</#if>
	</#list>
	<#return "null">
</#function>
<#--Table是Many2Many中间表-->
<#function isManyToMany tab>
	<#if tab.columns?size == 2>
	    <#assign manyFlay=0>
		<#list tab.columns! as cln>
			<#list p.references! as rs>
	   			<#if rs.ChildTable==tab.Id && rs.ChildTableColumn==cln.Id && (rs.Cardinality=="1..*" || rs.Cardinality=="0..*")>
	   				<#assign manyFlay=manyFlay+1>
	   			</#if>
	   		</#list>
		</#list>
		<#if manyFlay == 2>
			<#return true>
		<#else>
			<#return false>
		</#if>
	<#else>
		<#return false>
	</#if>
</#function>

<#--核心解析onetoone-->
<#macro onetoone tabId>
    <#if !entity_var.onetoones??>
		<@pp.set hash=entity_var key="onetoones" value=pp.newWritableSequence()/>
		<#assign xtox_index=0>
	</#if>
    <#list p.references! as rs>
   		<#if rs.ParentTable==tabId && (rs.Cardinality=="1..1" || rs.Cardinality=="0..1")>
			<@pp.add seq=entity_var.onetoones index=xtox_index value=pp.newWritableHash()/>
			<#assign onetoone_var=entity_var.onetoones[xtox_index]>
			<#assign xtox_index=xtox_index+1>
			<#assign childTable=getTable(rs.ChildTable)>
			<@pp.set hash=onetoone_var key="entity" value=childTable />
			<#if rs.Cardinality=="1..1">
			<@pp.set hash=onetoone_var key="optional" value="false" />
			<#else>
			<@pp.set hash=onetoone_var key="optional" value="true" />
			</#if>
		</#if>
	</#list>
</#macro>
<#--核心解析onetoone-->
<#macro onetooneM tabId cln>
  	<#if !entity_var.onetoones??>
		<@pp.set hash=entity_var key="onetoones" value=pp.newWritableSequence()/>
		<#assign xtox_index=0>
	</#if>
    <#list p.references! as rs>
		<#if rs.ChildTable==tabId && rs.ChildTableColumn==cln.Id && (rs.Cardinality=="1..1" || rs.Cardinality=="0..1")>
			<@pp.add seq=entity_var.onetoones index=xtox_index value=pp.newWritableHash()/>
			<#assign onetoone_var=entity_var.onetoones[xtox_index]>
			<#assign xtox_index=xtox_index+1>
			<#assign parentTable=getTable(rs.ParentTable)>
			<@pp.set hash=onetoone_var key="entity" value=parentTable />
			<@pp.set hash=onetoone_var key="joinColumn" value=cln.Code />
			<#if rs.Cardinality=="1..1">
			<@pp.set hash=onetoone_var key="optional" value="false" />
			<#else>
			<@pp.set hash=onetoone_var key="optional" value="true" />
			</#if>
		</#if>
	</#list>
</#macro>
<#--核心解析onetomany-->
<#macro onetomany tabId>
	<#if !entity_var.onetomanys??>
		<@pp.set hash=entity_var key="onetomanys" value=pp.newWritableSequence()/>
		<#assign xtox_index=0>
	</#if>
    <#list p.references! as rs>
	   	<#if rs.ParentTable==tabId && (rs.Cardinality=="1..*" || rs.Cardinality=="0..*")>
			<#assign childTable=getTable(rs.ChildTable)>
			<#if !isManyToMany(childTable)>
			    <@pp.add seq=entity_var.onetomanys index=xtox_index value=pp.newWritableHash()/>
			    <#assign onetomany_var=entity_var.onetomanys[xtox_index]>
			    <#assign xtox_index=xtox_index+1>
				<@pp.set hash=onetomany_var key="entity" value=childTable />
				<#if rs.Cardinality=="1..*">
					<@pp.set hash=onetomany_var key="optional" value="false" />
				<#else>
					<@pp.set hash=onetomany_var key="optional" value="true" />
				</#if>
			</#if>
		</#if>
	</#list>
</#macro>
<#--核心解析manytomany-->
<#macro manytomany tab>
	<#if !entity_var.manytomanys??>
		<@pp.set hash=entity_var key="manytomanys" value=pp.newWritableSequence()/>
		<#assign xtox_index=0>
	</#if>
    <#list p.references! as rs>
	   	<#if rs.ParentTable==tab.Id && (rs.Cardinality=="1..*" || rs.Cardinality=="0..*")>
			<#assign childTable=getTable(rs.ChildTable)>
			<#if isManyToMany(childTable)>
			    <@pp.add seq=entity_var.manytomanys index=xtox_index value=pp.newWritableHash()/>
			    <#assign manytomany_var=entity_var.manytomanys[xtox_index]>
			    <#assign xtox_index=xtox_index+1>
			    <#assign childColumn=getColumn(childTable,rs.ChildTableColumn)>
				<@pp.set hash=manytomany_var key="joinTable" value=childTable />
				<@pp.set hash=manytomany_var key="joinColumn" value=childColumn />
				<#assign inverseJoinColumn=getJoinColumn(childTable,childColumn.Id)>
				<#assign entityTable=getInverseJoinTable(childTable.Id,inverseJoinColumn.Id)>
				<@pp.set hash=manytomany_var key="inverseJoinColumn" value=inverseJoinColumn />
				<@pp.set hash=manytomany_var key="entity" value=entityTable />
			    <#if !tab.mappedBy??> 
					<@pp.set hash=manytomany_var key="mappedBy" value=false />
					<@pp.set hash=entityTable key="mappedBy" value=true /><#--对方为关系维护端（有一定的随机性质）-->
				<#else>
					<@pp.set hash=manytomany_var key="mappedBy" value=true />
				</#if>
			</#if>
		</#if>
	</#list>
</#macro>
 <#--核心解析manytoone-->
<#macro manytoone tabId cln>
	<#if !entity_var.manytoones??>
		<@pp.set hash=entity_var key="manytoones" value=pp.newWritableSequence()/>
		<#assign xtox_index=0>
	</#if>
	<#list p.references! as rs>
	   	<#if rs.ChildTable==tabId && rs.ChildTableColumn==cln.Id && (rs.Cardinality=="1..*" || rs.Cardinality=="0..*")>
			<@pp.add seq=entity_var.manytoones index=xtox_index value=pp.newWritableHash()/>
			<#assign manytoone_var=entity_var.manytoones[xtox_index]>
			<#assign xtox_index=xtox_index+1>
			<#assign parentTable=getTable(rs.ParentTable)>
			<@pp.set hash=manytoone_var key="entity" value=parentTable />
			<@pp.set hash=manytoone_var key="uniquely" value="false" />
			<@pp.set hash=manytoone_var key="joinColumn" value=cln.Code />
			<#if rs.Cardinality=="1..*">
				<@pp.set hash=manytoone_var key="optional" value="false" />
			<#else>
				<@pp.set hash=manytoone_var key="optional" value="true" />
			</#if>
		</#if>
	</#list>
</#macro>

<#function pathUrl package>
	<#return package?replace(".", "/")>	
</#function>

<#--生成文件名-->
<#function createFileNameByCode Code>
	<#assign CodeNames=Code?split("_")>
	<#assign CodeName="">
	<#list CodeNames as cName>
	<#assign CodeName=CodeName+cName?lower_case?cap_first>
	</#list>
	<#return CodeName>
</#function>
<#--生成字段属性-->
<#function createColumnName Code>
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

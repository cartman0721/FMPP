<#ftl  ns_prefixes={"a":"attribute","c":"collection","o":"object"}> 
<@pp.dropOutputFile />
<@pp.changeOutputFile name="/${projectname}/java.java" />

<#list excel as row>
/**
* <li>${row['name']}</li>
* <li>来源-${row['memo']!}</li>
**/
private String ${row['code']};
</#list>

<#list excel as row>
/**
* <li>${row['name']}</li>
* <li>来源-${row['memo']!}</li>
**/
public String get${row['code']?cap_first}(){
	return ${row['code']};
}

/**
* <li>${row['name']}</li>
* <li>来源-${row['memo']!}</li>
**/
public void set${row['code']?cap_first}(String ${row['code']}){
	this.${row['code']}=${row['code']};
}
</#list>




<#list excel as row>$!outsc.${row['code']} </#list>
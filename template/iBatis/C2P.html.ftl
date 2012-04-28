<#ftl  ns_prefixes={"a":"attribute","c":"collection","o":"object"}> 
<@pp.dropOutputFile />
<@pp.changeOutputFile name="/${projectname}/c2ps.html" />

<#list csv as row>
{name:'_${row_index}${(row['property']!"N/A")?string?uncap_first}',width:"80px"},
</#list>


<#list csv as row>
"_${row_index}${(row['property']!"N/A")?string?uncap_first}":"$!${row['Object']!"N/A"?string}.${(row['property']!"N/A")?string}",
</#list>

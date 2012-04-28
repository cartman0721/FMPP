package com.alifi.agds.common.dmmanage.model;		
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * <li> 表名： agds_dm_path</li>
 * @author dazuo.sundz
 * @generateTime 2012-04-28 13:46:31
 */

public class DmPath extends Entity implements Serializable{
    /**
     * 表名
     */
    public static final String TABLE_NAME = "AGDS_DM_PATH";
    
    
	private Long id; //id
	private String pcode; //pcode
	private String pname; //pname
	private Long parentId; //parent_id
	private String descs; //descs
	private Date gmtCreate; //gmt_create
	private Date gmtModified; //gmt_modified
	private String operator; //operator
	/**
	 * <li>id</li>
	 * 
	 * @return Long
	 */
	public Long getId(){
		return this.id;
	}
	
	/**
	 * <li> id ����ID</li>
	 * 
	 * @param  id
	 */
	public void setId(Long id){
		this.id=id;
	}
	/**
	 * <li>pcode</li>
	 * 
	 * @return String
	 */
	public String getPcode(){
		return this.pcode;
	}
	
	/**
	 * <li> pcode path�ڵ�Ӣ������\n</li>
	 * 
	 * @param  pcode
	 */
	public void setPcode(String pcode){
		this.pcode=pcode;
	}
	/**
	 * <li>pname</li>
	 * 
	 * @return String
	 */
	public String getPname(){
		return this.pname;
	}
	
	/**
	 * <li> pname path�ڵ���������\n</li>
	 * 
	 * @param  pname
	 */
	public void setPname(String pname){
		this.pname=pname;
	}
	/**
	 * <li>parent_id</li>
	 * 
	 * @return Long
	 */
	public Long getParentId(){
		return this.parentId;
	}
	
	/**
	 * <li> parent_id ���ڵ�ID</li>
	 * 
	 * @param  parentId
	 */
	public void setParentId(Long parentId){
		this.parentId=parentId;
	}
	/**
	 * <li>descs</li>
	 * 
	 * @return String
	 */
	public String getDescs(){
		return this.descs;
	}
	
	/**
	 * <li> descs ��ǰ�ڵ��������Ϣ</li>
	 * 
	 * @param  descs
	 */
	public void setDescs(String descs){
		this.descs=descs;
	}
	/**
	 * <li>gmt_create</li>
	 * 
	 * @return Date
	 */
	public Date getGmtCreate(){
		return this.gmtCreate;
	}
	
	/**
	 * <li> gmt_create ����ʱ��</li>
	 * 
	 * @param  gmtCreate
	 */
	public void setGmtCreate(Date gmtCreate){
		this.gmtCreate=gmtCreate;
	}
	/**
	 * <li>gmt_modified</li>
	 * 
	 * @return Date
	 */
	public Date getGmtModified(){
		return this.gmtModified;
	}
	
	/**
	 * <li> gmt_modified ������ʱ��</li>
	 * 
	 * @param  gmtModified
	 */
	public void setGmtModified(Date gmtModified){
		this.gmtModified=gmtModified;
	}
	/**
	 * <li>operator</li>
	 * 
	 * @return String
	 */
	public String getOperator(){
		return this.operator;
	}
	
	/**
	 * <li> operator </li>
	 * 
	 * @param  operator
	 */
	public void setOperator(String operator){
		this.operator=operator;
	}
	
}

package com.alifi.agds.common.dmmanage.model;		
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * <li> 表名： agds_dm_property</li>
 * @author dazuo.sundz
 * @generateTime 2012-05-22 10:16:21
 */

public class DmProperty extends Entity implements Serializable{
    /**
     * 表名
     */
    public static final String TABLE_NAME = "AGDS_DM_PROPERTY";
    
    
	private Long id; //id
	private Long pathId; //path_id
	private String pcode; //pcode
	private String pname; //pname
	private byte dataType; //data_type
	private String validator; //validator
	private Long tag; //tag
	private byte status; //status
	private String dwTable; //dw_table
	private String dwColumn; //dw_column
	private String descs; //descs
	private String creater; //creater
	private String operator; //operator
	private Date gmtCreate; //gmt_create
	private Date gmtModified; //gmt_modified
	private Date inDate; //in_date
	private Date submitDate; //submit_date
	private String updFrequency; //upd_frequency
	private String timeliness; //timeliness
	private String priority; //priority
	/**
	 * <li>id</li>
	 * 
	 * @return Long
	 */
	public Long getId(){
		return this.id;
	}
	
	/**
	 * <li> id 锟斤拷锟斤拷ID</li>
	 * 
	 * @param  id
	 */
	public void setId(Long id){
		this.id=id;
	}
	/**
	 * <li>path_id</li>
	 * 
	 * @return Long
	 */
	public Long getPathId(){
		return this.pathId;
	}
	
	/**
	 * <li> path_id path锟斤拷锟斤拷锟斤拷id</li>
	 * 
	 * @param  pathId
	 */
	public void setPathId(Long pathId){
		this.pathId=pathId;
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
	 * <li> pcode 锟斤拷锟斤拷英锟斤拷锟斤拷锟斤拷\n</li>
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
	 * <li> pname 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷\n</li>
	 * 
	 * @param  pname
	 */
	public void setPname(String pname){
		this.pname=pname;
	}
	/**
	 * <li>data_type</li>
	 * 
	 * @return byte
	 */
	public byte getDataType(){
		return this.dataType;
	}
	
	/**
	 * <li> data_type 1:Long, 2:Double, 3:String, 4:Boolean, 5:Date, 6:Integer</li>
	 * 
	 * @param  dataType
	 */
	public void setDataType(byte dataType){
		this.dataType=dataType;
	}
	/**
	 * <li>validator</li>
	 * 
	 * @return String
	 */
	public String getValidator(){
		return this.validator;
	}
	
	/**
	 * <li> validator 锟斤拷锟斤拷锟斤拷效锟斤拷校锟斤拷</li>
	 * 
	 * @param  validator
	 */
	public void setValidator(String validator){
		this.validator=validator;
	}
	/**
	 * <li>tag</li>
	 * 
	 * @return Long
	 */
	public Long getTag(){
		return this.tag;
	}
	
	/**
	 * <li> tag 锟斤拷锟皆憋拷签锟斤拷锟斤拷锟斤拷展位</li>
	 * 
	 * @param  tag
	 */
	public void setTag(Long tag){
		this.tag=tag;
	}
	/**
	 * <li>status</li>
	 * 
	 * @return byte
	 */
	public byte getStatus(){
		return this.status;
	}
	
	/**
	 * <li> status 锟斤拷锟斤拷状态(1.未锟结交 2.锟斤拷锟斤拷锟斤拷 3.锟窖斤拷锟斤拷 4.锟斤拷锟斤拷锟斤拷)</li>
	 * 
	 * @param  status
	 */
	public void setStatus(byte status){
		this.status=status;
	}
	/**
	 * <li>dw_table</li>
	 * 
	 * @return String
	 */
	public String getDwTable(){
		return this.dwTable;
	}
	
	/**
	 * <li> dw_table 锟斤拷应锟斤拷锟街憋拷锟斤拷</li>
	 * 
	 * @param  dwTable
	 */
	public void setDwTable(String dwTable){
		this.dwTable=dwTable;
	}
	/**
	 * <li>dw_column</li>
	 * 
	 * @return String
	 */
	public String getDwColumn(){
		return this.dwColumn;
	}
	
	/**
	 * <li> dw_column 锟斤拷应锟斤拷锟斤拷锟街讹拷</li>
	 * 
	 * @param  dwColumn
	 */
	public void setDwColumn(String dwColumn){
		this.dwColumn=dwColumn;
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
	 * <li> descs 锟斤拷锟皆的撅拷锟斤拷锟斤拷锟斤拷锟斤拷息</li>
	 * 
	 * @param  descs
	 */
	public void setDescs(String descs){
		this.descs=descs;
	}
	/**
	 * <li>creater</li>
	 * 
	 * @return String
	 */
	public String getCreater(){
		return this.creater;
	}
	
	/**
	 * <li> creater 锟斤拷锟斤拷锟斤拷</li>
	 * 
	 * @param  creater
	 */
	public void setCreater(String creater){
		this.creater=creater;
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
	 * <li> operator 锟睫革拷锟斤拷</li>
	 * 
	 * @param  operator
	 */
	public void setOperator(String operator){
		this.operator=operator;
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
	 * <li> gmt_create 锟斤拷锟斤拷时锟斤拷</li>
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
	 * <li> gmt_modified 锟睫革拷时锟斤拷</li>
	 * 
	 * @param  gmtModified
	 */
	public void setGmtModified(Date gmtModified){
		this.gmtModified=gmtModified;
	}
	/**
	 * <li>in_date</li>
	 * 
	 * @return Date
	 */
	public Date getInDate(){
		return this.inDate;
	}
	
	/**
	 * <li> in_date 锟斤拷锟斤拷时锟斤拷</li>
	 * 
	 * @param  inDate
	 */
	public void setInDate(Date inDate){
		this.inDate=inDate;
	}
	/**
	 * <li>submit_date</li>
	 * 
	 * @return Date
	 */
	public Date getSubmitDate(){
		return this.submitDate;
	}
	
	/**
	 * <li> submit_date 锟结交时锟斤拷</li>
	 * 
	 * @param  submitDate
	 */
	public void setSubmitDate(Date submitDate){
		this.submitDate=submitDate;
	}
	/**
	 * <li>upd_frequency</li>
	 * 
	 * @return String
	 */
	public String getUpdFrequency(){
		return this.updFrequency;
	}
	
	/**
	 * <li> upd_frequency 频锟斤拷</li>
	 * 
	 * @param  updFrequency
	 */
	public void setUpdFrequency(String updFrequency){
		this.updFrequency=updFrequency;
	}
	/**
	 * <li>timeliness</li>
	 * 
	 * @return String
	 */
	public String getTimeliness(){
		return this.timeliness;
	}
	
	/**
	 * <li> timeliness 时效锟斤拷</li>
	 * 
	 * @param  timeliness
	 */
	public void setTimeliness(String timeliness){
		this.timeliness=timeliness;
	}
	/**
	 * <li>priority</li>
	 * 
	 * @return String
	 */
	public String getPriority(){
		return this.priority;
	}
	
	/**
	 * <li> priority 锟斤拷锟饺硷拷</li>
	 * 
	 * @param  priority
	 */
	public void setPriority(String priority){
		this.priority=priority;
	}
	
}

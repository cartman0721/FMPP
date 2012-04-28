
/**
* <li>外包公司</li>
* <li>来源-委外协议</li>
**/
private String organName;
/**
* <li>委案日期</li>
* <li>来源-委外协议</li>
**/
private String outTime;
/**
* <li>预计退案日期</li>
* <li>来源-委外协议</li>
**/
private String planQuitTime;
/**
* <li>手别</li>
* <li>来源-委外协议</li>
**/
private String outCnt;
/**
* <li>逾期天数</li>
* <li>来源-贷款产品</li>
**/
private String ovdDays;
/**
* <li>贷款类型</li>
* <li>来源-贷款产品</li>
**/
private String product;
/**
* <li>案件标号</li>
* <li>来源-委外协议</li>
**/
private String caseSeqno;
/**
* <li>委案金额</li>
* <li>来源-贷款产品汇总</li>
**/
private String balanceDue;
/**
* <li>地区</li>
* <li>来源-委外协议</li>
**/
private String caseArea;
/**
* <li>淘宝ID</li>
* <li>来源-接口</li>
**/
private String taobao;
/**
* <li>买家星级</li>
* <li>来源-接口</li>
**/
private String sellerStar;
/**
* <li>卖家星级</li>
* <li>来源-接口</li>
**/
private String buyerStar;
/**
* <li>支付宝账户号码</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String bindAlipay;
/**
* <li>姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String fullName;
/**
* <li>证件号</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String credNum;
/**
* <li>性别</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String gender;
/**
* <li>家庭地址</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String homeAddress;
/**
* <li>户籍地址</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String regisPlace;
/**
* <li>手机</li>
* <li>来源-委外协议PHONE_NUM</li>
**/
private String phoneNum;
/**
* <li>联系人</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String contactNameExcel;
/**
* <li>联系人电话</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String contaictMobileExcel;
/**
* <li>个人手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String mobilePhone;
/**
* <li>个人邮箱</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String email;
/**
* <li>联系地址</li>
* <li>来源-无</li>
**/
private String contactAddress;
/**
* <li>配偶姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String mateName;
/**
* <li>配偶手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String mateMobile;
/**
* <li>实际控制人姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String managerName;
/**
* <li>实际控制人手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String managerPhone;
/**
* <li>最大供应商名称</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String largestSupplier;
/**
* <li>最大供应商联系人姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String lsContactName;
/**
* <li>最大供应商联系电话</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String lsContactTelephone;
/**
* <li>最大客户名称</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String largestCustomer;
/**
* <li>最大客户联系人</li>
* <li>来源-CustomerBasicInfo</li>
**/
private String lcContactName;
/**
* <li>最大客户联系电话lcContactTelephone</li>
* <li>来源-</li>
**/
private String CustomerBasicInfo;

/**
* <li>外包公司</li>
* <li>来源-委外协议</li>
**/
public String getOrganName(){
	return organName;
}

/**
* <li>外包公司</li>
* <li>来源-委外协议</li>
**/
public void setOrganName(String organName){
	this.organName=organName;
}
/**
* <li>委案日期</li>
* <li>来源-委外协议</li>
**/
public String getOutTime(){
	return outTime;
}

/**
* <li>委案日期</li>
* <li>来源-委外协议</li>
**/
public void setOutTime(String outTime){
	this.outTime=outTime;
}
/**
* <li>预计退案日期</li>
* <li>来源-委外协议</li>
**/
public String getPlanQuitTime(){
	return planQuitTime;
}

/**
* <li>预计退案日期</li>
* <li>来源-委外协议</li>
**/
public void setPlanQuitTime(String planQuitTime){
	this.planQuitTime=planQuitTime;
}
/**
* <li>手别</li>
* <li>来源-委外协议</li>
**/
public String getOutCnt(){
	return outCnt;
}

/**
* <li>手别</li>
* <li>来源-委外协议</li>
**/
public void setOutCnt(String outCnt){
	this.outCnt=outCnt;
}
/**
* <li>逾期天数</li>
* <li>来源-贷款产品</li>
**/
public String getOvdDays(){
	return ovdDays;
}

/**
* <li>逾期天数</li>
* <li>来源-贷款产品</li>
**/
public void setOvdDays(String ovdDays){
	this.ovdDays=ovdDays;
}
/**
* <li>贷款类型</li>
* <li>来源-贷款产品</li>
**/
public String getProduct(){
	return product;
}

/**
* <li>贷款类型</li>
* <li>来源-贷款产品</li>
**/
public void setProduct(String product){
	this.product=product;
}
/**
* <li>案件标号</li>
* <li>来源-委外协议</li>
**/
public String getCaseSeqno(){
	return caseSeqno;
}

/**
* <li>案件标号</li>
* <li>来源-委外协议</li>
**/
public void setCaseSeqno(String caseSeqno){
	this.caseSeqno=caseSeqno;
}
/**
* <li>委案金额</li>
* <li>来源-贷款产品汇总</li>
**/
public String getBalanceDue(){
	return balanceDue;
}

/**
* <li>委案金额</li>
* <li>来源-贷款产品汇总</li>
**/
public void setBalanceDue(String balanceDue){
	this.balanceDue=balanceDue;
}
/**
* <li>地区</li>
* <li>来源-委外协议</li>
**/
public String getCaseArea(){
	return caseArea;
}

/**
* <li>地区</li>
* <li>来源-委外协议</li>
**/
public void setCaseArea(String caseArea){
	this.caseArea=caseArea;
}
/**
* <li>淘宝ID</li>
* <li>来源-接口</li>
**/
public String getTaobao(){
	return taobao;
}

/**
* <li>淘宝ID</li>
* <li>来源-接口</li>
**/
public void setTaobao(String taobao){
	this.taobao=taobao;
}
/**
* <li>买家星级</li>
* <li>来源-接口</li>
**/
public String getSellerStar(){
	return sellerStar;
}

/**
* <li>买家星级</li>
* <li>来源-接口</li>
**/
public void setSellerStar(String sellerStar){
	this.sellerStar=sellerStar;
}
/**
* <li>卖家星级</li>
* <li>来源-接口</li>
**/
public String getBuyerStar(){
	return buyerStar;
}

/**
* <li>卖家星级</li>
* <li>来源-接口</li>
**/
public void setBuyerStar(String buyerStar){
	this.buyerStar=buyerStar;
}
/**
* <li>支付宝账户号码</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getBindAlipay(){
	return bindAlipay;
}

/**
* <li>支付宝账户号码</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setBindAlipay(String bindAlipay){
	this.bindAlipay=bindAlipay;
}
/**
* <li>姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getFullName(){
	return fullName;
}

/**
* <li>姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setFullName(String fullName){
	this.fullName=fullName;
}
/**
* <li>证件号</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getCredNum(){
	return credNum;
}

/**
* <li>证件号</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setCredNum(String credNum){
	this.credNum=credNum;
}
/**
* <li>性别</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getGender(){
	return gender;
}

/**
* <li>性别</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setGender(String gender){
	this.gender=gender;
}
/**
* <li>家庭地址</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getHomeAddress(){
	return homeAddress;
}

/**
* <li>家庭地址</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setHomeAddress(String homeAddress){
	this.homeAddress=homeAddress;
}
/**
* <li>户籍地址</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getRegisPlace(){
	return regisPlace;
}

/**
* <li>户籍地址</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setRegisPlace(String regisPlace){
	this.regisPlace=regisPlace;
}
/**
* <li>手机</li>
* <li>来源-委外协议PHONE_NUM</li>
**/
public String getPhoneNum(){
	return phoneNum;
}

/**
* <li>手机</li>
* <li>来源-委外协议PHONE_NUM</li>
**/
public void setPhoneNum(String phoneNum){
	this.phoneNum=phoneNum;
}
/**
* <li>联系人</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getContactNameExcel(){
	return contactNameExcel;
}

/**
* <li>联系人</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setContactNameExcel(String contactNameExcel){
	this.contactNameExcel=contactNameExcel;
}
/**
* <li>联系人电话</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getContaictMobileExcel(){
	return contaictMobileExcel;
}

/**
* <li>联系人电话</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setContaictMobileExcel(String contaictMobileExcel){
	this.contaictMobileExcel=contaictMobileExcel;
}
/**
* <li>个人手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getMobilePhone(){
	return mobilePhone;
}

/**
* <li>个人手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setMobilePhone(String mobilePhone){
	this.mobilePhone=mobilePhone;
}
/**
* <li>个人邮箱</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getEmail(){
	return email;
}

/**
* <li>个人邮箱</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setEmail(String email){
	this.email=email;
}
/**
* <li>联系地址</li>
* <li>来源-无</li>
**/
public String getContactAddress(){
	return contactAddress;
}

/**
* <li>联系地址</li>
* <li>来源-无</li>
**/
public void setContactAddress(String contactAddress){
	this.contactAddress=contactAddress;
}
/**
* <li>配偶姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getMateName(){
	return mateName;
}

/**
* <li>配偶姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setMateName(String mateName){
	this.mateName=mateName;
}
/**
* <li>配偶手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getMateMobile(){
	return mateMobile;
}

/**
* <li>配偶手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setMateMobile(String mateMobile){
	this.mateMobile=mateMobile;
}
/**
* <li>实际控制人姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getManagerName(){
	return managerName;
}

/**
* <li>实际控制人姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setManagerName(String managerName){
	this.managerName=managerName;
}
/**
* <li>实际控制人手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getManagerPhone(){
	return managerPhone;
}

/**
* <li>实际控制人手机</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setManagerPhone(String managerPhone){
	this.managerPhone=managerPhone;
}
/**
* <li>最大供应商名称</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getLargestSupplier(){
	return largestSupplier;
}

/**
* <li>最大供应商名称</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setLargestSupplier(String largestSupplier){
	this.largestSupplier=largestSupplier;
}
/**
* <li>最大供应商联系人姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getLsContactName(){
	return lsContactName;
}

/**
* <li>最大供应商联系人姓名</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setLsContactName(String lsContactName){
	this.lsContactName=lsContactName;
}
/**
* <li>最大供应商联系电话</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getLsContactTelephone(){
	return lsContactTelephone;
}

/**
* <li>最大供应商联系电话</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setLsContactTelephone(String lsContactTelephone){
	this.lsContactTelephone=lsContactTelephone;
}
/**
* <li>最大客户名称</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getLargestCustomer(){
	return largestCustomer;
}

/**
* <li>最大客户名称</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setLargestCustomer(String largestCustomer){
	this.largestCustomer=largestCustomer;
}
/**
* <li>最大客户联系人</li>
* <li>来源-CustomerBasicInfo</li>
**/
public String getLcContactName(){
	return lcContactName;
}

/**
* <li>最大客户联系人</li>
* <li>来源-CustomerBasicInfo</li>
**/
public void setLcContactName(String lcContactName){
	this.lcContactName=lcContactName;
}
/**
* <li>最大客户联系电话lcContactTelephone</li>
* <li>来源-</li>
**/
public String getCustomerBasicInfo(){
	return CustomerBasicInfo;
}

/**
* <li>最大客户联系电话lcContactTelephone</li>
* <li>来源-</li>
**/
public void setCustomerBasicInfo(String CustomerBasicInfo){
	this.CustomerBasicInfo=CustomerBasicInfo;
}




$!outsc.organName $!outsc.outTime $!outsc.planQuitTime $!outsc.outCnt $!outsc.ovdDays $!outsc.product $!outsc.caseSeqno $!outsc.balanceDue $!outsc.caseArea $!outsc.taobao $!outsc.sellerStar $!outsc.buyerStar $!outsc.bindAlipay $!outsc.fullName $!outsc.credNum $!outsc.gender $!outsc.homeAddress $!outsc.regisPlace $!outsc.phoneNum $!outsc.contactNameExcel $!outsc.contaictMobileExcel $!outsc.mobilePhone $!outsc.email $!outsc.contactAddress $!outsc.mateName $!outsc.mateMobile $!outsc.managerName $!outsc.managerPhone $!outsc.largestSupplier $!outsc.lsContactName $!outsc.lsContactTelephone $!outsc.largestCustomer $!outsc.lcContactName $!outsc.CustomerBasicInfo 
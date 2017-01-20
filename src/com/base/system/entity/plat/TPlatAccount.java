package com.base.system.entity.plat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_plat_account")
public class TPlatAccount implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.String account;//账号
	private java.lang.String pwd;//密码
	private java.lang.Integer employeeid;//员工id
	private java.lang.String name;//
	private java.lang.Integer type;//账号类型：1：业务模块，2,系统模块
	private java.lang.Integer status;//状态：1正常，0删除
	private java.sql.Timestamp createtime;//
	private java.lang.Integer companyid;//公司id
	public TPlatAccount(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setAccount(java.lang.String account){
		this.account=account;
	}
	public java.lang.String getAccount(){
		return account;
	}
	public void setPwd(java.lang.String pwd){
		this.pwd=pwd;
	}
	public java.lang.String getPwd(){
		return pwd;
	}
	public void setEmployeeid(java.lang.Integer employeeid){
		this.employeeid=employeeid;
	}
	public java.lang.Integer getEmployeeid(){
		return employeeid;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return name;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return type;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return status;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return createtime;
	}
	public void setCompanyid(java.lang.Integer companyid){
		this.companyid=companyid;
	}
	public java.lang.Integer getCompanyid(){
		return companyid;
	}
	@Override
	public String toString() { 
		return "TPlatAccount[id="+id+",account="+account+",pwd="+pwd+",employeeid="+employeeid+",name="+name+",type="+type+",status="+status+",createtime="+createtime+",companyid="+companyid+"]";
	}
}
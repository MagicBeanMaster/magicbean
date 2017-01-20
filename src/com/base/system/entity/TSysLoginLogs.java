package com.base.system.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_sys_login_logs")
public class TSysLoginLogs implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//主键
	private java.lang.String account;//账号
	private java.lang.String ip;//ip地址
	private java.lang.String sessId;//登录SessionId
	private java.sql.Timestamp intime;//登录时间
	private java.sql.Timestamp outtime;//退出时间
	private java.lang.String remark;//备注
	public TSysLoginLogs(){

	}
	public TSysLoginLogs(String account,String ip,String sessId){
		this.account=account;
		this.ip=ip;
		this.sessId=sessId;
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
	public void setIp(java.lang.String ip){
		this.ip=ip;
	}
	public java.lang.String getIp(){
		return ip;
	}
	public void setSessId(java.lang.String sessId){
		this.sessId=sessId;
	}
	public java.lang.String getSessId(){
		return sessId;
	}
	public void setIntime(java.sql.Timestamp intime){
		this.intime=intime;
	}
	public java.sql.Timestamp getIntime(){
		return intime;
	}
	public void setOuttime(java.sql.Timestamp outtime){
		this.outtime=outtime;
	}
	public java.sql.Timestamp getOuttime(){
		return outtime;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return remark;
	}
	@Override
	public String toString() { 
		return "TSysLoginLogs[id="+id+",account="+account+",ip="+ip+",sessId="+sessId+",intime="+intime+",outtime="+outtime+",remark="+remark+"]";
	}
}
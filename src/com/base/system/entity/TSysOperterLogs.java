package com.base.system.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_sys_operter_logs")
public class TSysOperterLogs implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//主键
	private java.lang.String account;//操作账号
	private java.lang.String methodname;//方法名称
	private java.lang.String remark;//备注
	private java.sql.Timestamp createtime;//创建时间
	private java.lang.String ip;//
	private java.lang.String mac;//
	public TSysOperterLogs(){

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
	public void setMethodname(java.lang.String methodname){
		this.methodname=methodname;
	}
	public java.lang.String getMethodname(){
		return methodname;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return remark;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return createtime;
	}
	public void setIp(java.lang.String ip){
		this.ip=ip;
	}
	public java.lang.String getIp(){
		return ip;
	}
	public void setMac(java.lang.String mac){
		this.mac=mac;
	}
	public java.lang.String getMac(){
		return mac;
	}
	@Override
	public String toString() { 
		return "TSysOperterLogs[id="+id+",account="+account+",methodname="+methodname+",remark="+remark+",createtime="+createtime+",ip="+ip+",mac="+mac+"]";
	}
}
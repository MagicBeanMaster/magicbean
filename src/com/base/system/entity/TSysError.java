package com.base.system.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_sys_error")
public class TSysError implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.String errormess;//
	private java.lang.String ip;//系统ip
	private java.sql.Timestamp createtime;//
	public TSysError(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setErrormess(java.lang.String errormess){
		this.errormess=errormess;
	}
	public java.lang.String getErrormess(){
		return errormess;
	}
	public void setIp(java.lang.String ip){
		this.ip=ip;
	}
	public java.lang.String getIp(){
		return ip;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return createtime;
	}
	@Override
	public String toString() { 
		return "TSysError[id="+id+",errormess="+errormess+",ip="+ip+",createtime="+createtime+"]";
	}
}
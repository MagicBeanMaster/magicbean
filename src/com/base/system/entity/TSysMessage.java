package com.base.system.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_sys_message")
public class TSysMessage implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//主键id
	private java.lang.String params;//传递的对象
	private java.sql.Timestamp createtime;//创建时间
	public TSysMessage(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setParams(java.lang.String params){
		this.params=params;
	}
	public java.lang.String getParams(){
		return params;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return createtime;
	}
	@Override
	public String toString() { 
		return "TSysMessage[id="+id+",params="+params+",createtime="+createtime+"]";
	}
}
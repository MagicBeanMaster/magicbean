package com.base.system.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_sys_version")
public class TSysVersion implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.String content;//
	private java.lang.String likecontent;//
	private java.sql.Timestamp createtime;//
	private java.sql.Timestamp updatetime;//
	public TSysVersion(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setContent(java.lang.String content){
		this.content=content;
	}
	public java.lang.String getContent(){
		return content;
	}
	public void setLikecontent(java.lang.String likecontent){
		this.likecontent=likecontent;
	}
	public java.lang.String getLikecontent(){
		return likecontent;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return createtime;
	}
	public void setUpdatetime(java.sql.Timestamp updatetime){
		this.updatetime=updatetime;
	}
	public java.sql.Timestamp getUpdatetime(){
		return updatetime;
	}
	@Override
	public String toString() { 
		return "TSysVersion[id="+id+",content="+content+",likecontent="+likecontent+",createtime="+createtime+",updatetime="+updatetime+"]";
	}
}
package com.base.system.entity.plat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_plat_resourceroles")
public class TPlatResourceroles implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.Integer roleid;//角色id
	private java.lang.Integer resourceid;//资源id
	private java.lang.Integer companyid;//公司id
	public TPlatResourceroles(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setRoleid(java.lang.Integer roleid){
		this.roleid=roleid;
	}
	public java.lang.Integer getRoleid(){
		return roleid;
	}
	public void setResourceid(java.lang.Integer resourceid){
		this.resourceid=resourceid;
	}
	public java.lang.Integer getResourceid(){
		return resourceid;
	}
	public void setCompanyid(java.lang.Integer companyid){
		this.companyid=companyid;
	}
	public java.lang.Integer getCompanyid(){
		return companyid;
	}
	@Override
	public String toString() { 
		return "TPlatResourceroles[id="+id+",roleid="+roleid+",resourceid="+resourceid+",companyid="+companyid+"]";
	}
}
package com.base.system.entity.plat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_plat_accountroles")
public class TPlatAccountroles implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.Integer accountid;//帐号id
	private java.lang.Integer roleid;//角色id
	private java.lang.Integer companyid;//公司id
	public TPlatAccountroles(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setAccountid(java.lang.Integer accountid){
		this.accountid=accountid;
	}
	public java.lang.Integer getAccountid(){
		return accountid;
	}
	public void setRoleid(java.lang.Integer roleid){
		this.roleid=roleid;
	}
	public java.lang.Integer getRoleid(){
		return roleid;
	}
	public void setCompanyid(java.lang.Integer companyid){
		this.companyid=companyid;
	}
	public java.lang.Integer getCompanyid(){
		return companyid;
	}
	@Override
	public String toString() { 
		return "TPlatAccountroles[id="+id+",accountid="+accountid+",roleid="+roleid+",companyid="+companyid+"]";
	}
}
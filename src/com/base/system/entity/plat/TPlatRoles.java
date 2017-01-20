package com.base.system.entity.plat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_plat_roles")
public class TPlatRoles implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.String rolesname;//角色名
	private java.lang.String remark;//备注
	private java.lang.Integer status;//状态：0正常，1删除
	private java.sql.Timestamp createtime;//创建时间
	private java.lang.Integer companyid;//公司id
	public TPlatRoles(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setRolesname(java.lang.String rolesname){
		this.rolesname=rolesname;
	}
	public java.lang.String getRolesname(){
		return rolesname;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return remark;
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
		return "TPlatRoles[id="+id+",rolesname="+rolesname+",remark="+remark+",status="+status+",createtime="+createtime+",companyid="+companyid+"]";
	}
}
package com.base.system.entity.plat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_plat_resource")
public class TPlatResource implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.Integer parentid;//父菜单
	private java.lang.String menuname;//菜单名
	private java.lang.String path;//访问的路径
	private java.lang.String icon;//图标
	private java.lang.Integer type;//类型：0一级,5按钮
	private java.lang.String remark;//备注
	private java.lang.Integer status;//状态：0正常，-1删除
	private java.lang.Integer ord;//排序
	private java.sql.Timestamp createtime;//创建时间
	private java.lang.Integer companyid;//公司id
	public TPlatResource(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setParentid(java.lang.Integer parentid){
		this.parentid=parentid;
	}
	public java.lang.Integer getParentid(){
		return parentid;
	}
	public void setMenuname(java.lang.String menuname){
		this.menuname=menuname;
	}
	public java.lang.String getMenuname(){
		return menuname;
	}
	public void setPath(java.lang.String path){
		this.path=path;
	}
	public java.lang.String getPath(){
		return path;
	}
	public void setIcon(java.lang.String icon){
		this.icon=icon;
	}
	public java.lang.String getIcon(){
		return icon;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return type;
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
	public void setOrd(java.lang.Integer ord){
		this.ord=ord;
	}
	public java.lang.Integer getOrd(){
		return ord;
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
		return "TPlatResource[id="+id+",parentid="+parentid+",menuname="+menuname+",path="+path+",icon="+icon+",type="+type+",remark="+remark+",status="+status+",ord="+ord+",createtime="+createtime+",companyid="+companyid+"]";
	}
}
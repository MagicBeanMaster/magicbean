package com.base.system.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_employee")
public class TEmployee implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.lang.Integer id;//
	private java.lang.String empcode;//员工编号
	private java.lang.String name;//员工姓名
	private java.util.Date age;//出生日期
	private java.lang.Integer sex;//性别
	private java.lang.String phone;//联系电话
	private java.lang.String email;//电子邮箱
	private java.lang.String job;//岗位
	private java.lang.Integer status;//状态：0离职 1在职
	private java.lang.Integer level;//员工等级
	private java.sql.Timestamp createtime;//创建时间
	private java.lang.Integer createpeople;//创建人
	private java.sql.Timestamp updatetime;//更新时间
	private java.lang.Integer updatepeople;//更新人
	private java.lang.Integer companyid;//公司id
	private java.lang.String remark1;//保留字段1
	private java.lang.String remark2;//保留字段2
	private java.lang.String remark3;//保留字段3
	public TEmployee(){

	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	public java.lang.Integer getId(){
		return id;
	}
	public void setEmpcode(java.lang.String empcode){
		this.empcode=empcode;
	}
	public java.lang.String getEmpcode(){
		return empcode;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return name;
	}
	public void setAge(java.util.Date age){
		this.age=age;
	}
	public java.util.Date getAge(){
		return age;
	}
	public void setSex(java.lang.Integer sex){
		this.sex=sex;
	}
	public java.lang.Integer getSex(){
		return sex;
	}
	public void setPhone(java.lang.String phone){
		this.phone=phone;
	}
	public java.lang.String getPhone(){
		return phone;
	}
	public void setEmail(java.lang.String email){
		this.email=email;
	}
	public java.lang.String getEmail(){
		return email;
	}
	public void setJob(java.lang.String job){
		this.job=job;
	}
	public java.lang.String getJob(){
		return job;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return status;
	}
	public void setLevel(java.lang.Integer level){
		this.level=level;
	}
	public java.lang.Integer getLevel(){
		return level;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return createtime;
	}
	public void setCreatepeople(java.lang.Integer createpeople){
		this.createpeople=createpeople;
	}
	public java.lang.Integer getCreatepeople(){
		return createpeople;
	}
	public void setUpdatetime(java.sql.Timestamp updatetime){
		this.updatetime=updatetime;
	}
	public java.sql.Timestamp getUpdatetime(){
		return updatetime;
	}
	public void setUpdatepeople(java.lang.Integer updatepeople){
		this.updatepeople=updatepeople;
	}
	public java.lang.Integer getUpdatepeople(){
		return updatepeople;
	}
	public void setCompanyid(java.lang.Integer companyid){
		this.companyid=companyid;
	}
	public java.lang.Integer getCompanyid(){
		return companyid;
	}
	public void setRemark1(java.lang.String remark1){
		this.remark1=remark1;
	}
	public java.lang.String getRemark1(){
		return remark1;
	}
	public void setRemark2(java.lang.String remark2){
		this.remark2=remark2;
	}
	public java.lang.String getRemark2(){
		return remark2;
	}
	public void setRemark3(java.lang.String remark3){
		this.remark3=remark3;
	}
	public java.lang.String getRemark3(){
		return remark3;
	}
	@Override
	public String toString() { 
		return "TEmployee[id="+id+",empcode="+empcode+",name="+name+",age="+age+",sex="+sex+",phone="+phone+",email="+email+",job="+job+",status="+status+",level="+level+",createtime="+createtime+",createpeople="+createpeople+",updatetime="+updatetime+",updatepeople="+updatepeople+",companyid="+companyid+",remark1="+remark1+",remark2="+remark2+",remark3="+remark3+"]";
	}
}
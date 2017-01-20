package com.base.system.entity;


/**
 * 
 * @description 登录实体用户信息
 * @author lq
 * @date 2015年10月20日 上午11:25:51
 * @version
 */
public class SysUser {

	private String sessionId;
	private java.lang.String account;// 账号
	private java.lang.String empid;// 员工id
	private java.lang.String name;// 姓名
	private java.lang.String pwd;// 密码
	private java.lang.Integer type;//账号类型：1：业务模块，2,系统模块
	private java.sql.Timestamp createtime;//
	private java.lang.Integer accountid;//账号id
	private java.lang.String rolesname;// 角色名
	private java.lang.String mess;// 角色名

	
	

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public java.lang.String getAccount() {
		return account;
	}
	public void setAccount(java.lang.String account) {
		this.account = account;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getPwd() {
		return pwd;
	}
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}
	public java.sql.Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.sql.Timestamp createtime) {
		this.createtime = createtime;
	}
	public java.lang.Integer getType() {
		return type;
	}
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	public java.lang.Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(java.lang.Integer accountid) {
		this.accountid = accountid;
	}
	public java.lang.String getRolesname() {
		return rolesname;
	}
	public void setRolesname(java.lang.String rolesname) {
		this.rolesname = rolesname;
	}
	public java.lang.String getEmpid() {
		return empid;
	}
	public void setEmpid(java.lang.String empid) {
		this.empid = empid;
	}
	public java.lang.String getMess() {
		return mess;
	}
	public void setMess(java.lang.String mess) {
		this.mess = mess;
	}
	
	
	
}

package com.base.system.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_sys_sql")
public class TSysSql implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private java.math.BigInteger id;//
	private java.lang.String runsql;//
	private java.lang.String parameters;//
	private java.sql.Timestamp createtime;//
	private java.lang.Integer sqlruntime;//
	private java.lang.String client;//
	public TSysSql(){

	}
	public void setId(java.math.BigInteger id){
		this.id=id;
	}
	public java.math.BigInteger getId(){
		return id;
	}
	public void setRunsql(java.lang.String runsql){
		this.runsql=runsql;
	}
	public java.lang.String getRunsql(){
		return runsql;
	}
	public void setParameters(java.lang.String parameters){
		this.parameters=parameters;
	}
	public java.lang.String getParameters(){
		return parameters;
	}
	public void setCreatetime(java.sql.Timestamp createtime){
		this.createtime=createtime;
	}
	public java.sql.Timestamp getCreatetime(){
		return createtime;
	}
	public void setSqlruntime(java.lang.Integer sqlruntime){
		this.sqlruntime=sqlruntime;
	}
	public java.lang.Integer getSqlruntime(){
		return sqlruntime;
	}
	public void setClient(java.lang.String client){
		this.client=client;
	}
	public java.lang.String getClient(){
		return client;
	}
	@Override
	public String toString() { 
		return "TSysSql[id="+id+",runsql="+runsql+",parameters="+parameters+",createtime="+createtime+",sqlruntime="+sqlruntime+",client="+client+"]";
	}
}
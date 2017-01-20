package com.base.label;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 
 * @description 表格列 
 * @author lq
 * @date 2015年10月30日 下午2:30:46 
 * @version
 */
public class Column extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2266852983465909546L;
	private String name;//表头name
	private String title;//表头
	private String breakpoint;//展示的宽度
	private String oper;//值
	
	@Override
	public int doStartTag() throws JspException {
		 return EVAL_PAGE;
	}
	
	@Override  
    public int doEndTag() throws JspException {  
        Tag t = findAncestorWithClass(this, Table.class);  
        Table parent = (Table) t;  
        parent.setTitle(name, title,breakpoint,oper);
        return super.doEndTag();  
    }  


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public String getBreakpoint() {
		return breakpoint;
	}

	public void setBreakpoint(String breakpoint) {
		this.breakpoint = breakpoint;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	

}

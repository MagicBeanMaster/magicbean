package com.base.label;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;


public class Operate extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2266852983465909546L;
	private String event;//事件
	private String text;//事件名
	
	@Override
	public int doStartTag() throws JspException {
		 return EVAL_PAGE;
	}
	
	@Override  
    public int doEndTag() throws JspException {  
        Tag t = findAncestorWithClass(this, Table.class);  
        Table parent = (Table) t;  
        parent.setAction(event, text);
        return super.doEndTag();  
    }

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}  
	
}

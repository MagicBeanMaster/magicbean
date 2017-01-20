package com.base.label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import org.apache.commons.lang3.StringUtils;

public class Table extends BodyTagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> titlelist=new ArrayList<String>();//表头title
	private List<String> namelist=new ArrayList<String>();//表头列name
	private List<String> breakpointslist=new ArrayList<String>();//展示的宽度
	private List<String> operslist=new ArrayList<String>();//展示的宽度
	private List<Map<String,Object>> listmap;//展示的数据
	private Integer startIndex=0;//开始值
	private List<String> eventlist=new ArrayList<String>();
	private List<String> textlist=new ArrayList<String>();

	@Override
	public int doStartTag() throws JspException {
		titlelist.clear();
		namelist.clear();
		breakpointslist.clear();
		operslist.clear();
		eventlist.clear();
		textlist.clear();
		return EVAL_BODY_INCLUDE;  
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		StringBuffer sb=new StringBuffer(225);
		sb.append("<script type='text/javascript'>");
		sb.append("function ckAll(){ ");
		sb.append("var v=$('#ckall').prop('checked'); ");
		sb.append("$('input[name=ckbox]').each(function(){ ");
		sb.append("$(this).prop('checked',v);");
		sb.append("})");
		sb.append("}");
		
		sb.append("var footable = $('.footable');");
		sb.append("footable.footable({");
		sb.append("'columns':[");
		Map<String,Object> tempmap=null;
		if(listmap.size()>0){
			tempmap=listmap.get(0);
		}
		
		for (int i = 0; i < titlelist.size(); i++) {
			if(i>0)
				sb.append(",");
			if(namelist.get(i).equals("ckbox")){
				sb.append("{'title':'<input type=checkbox id=ckall onchange=ckAll()>','name':'").append(namelist.get(i)).append("'");
			}else{
				sb.append("{'title':'").append(titlelist.get(i)).append("','name':'").append(namelist.get(i)).append("'");
				if(StringUtils.isNotEmpty(breakpointslist.get(i))){
					sb.append(",'breakpoints':'").append(breakpointslist.get(i)).append("'");
				}
			}
			sb.append("}");//md
		}

		if(tempmap!=null){
			for (String key : tempmap.keySet()) {
				if(!namelist.contains(key)){
					sb.append(",{'title':'").append(key).append("','name':'").append(key).append("','visible':false}");
				}
			}
		}
		
		if(eventlist.size()>0)
			sb.append(",{'name':'action','title':'操作'}");
		sb.append("]");
		sb.append(",'rows':[");
		
		for (int i = 0; i < listmap.size(); i++) {
			Map<String,Object> temp=listmap.get(i);
			if(i>0)
				sb.append(",");
			sb.append("{");

			for (int j = 0; j < namelist.size(); j++) {
				if(j>0)
					sb.append(",");
				if(namelist.get(j).equals("auto")){
					sb.append("'").append(namelist.get(j)).append("':'").append((i+1+startIndex)).append("'");
				}else if(namelist.get(j).equals("ckbox")){
					sb.append("'").append(namelist.get(j)).append("':'<input type=checkbox  name=ckbox />'");
				}else{
					sb.append("'").append(namelist.get(j)).append("':'<span name="+namelist.get(j)+">").append(temp.get(namelist.get(j))).append("</span>'");
				}
			}
			for (String key : tempmap.keySet()) {
				if(!namelist.contains(key)){
					sb.append(",'").append(key).append("':'<span name="+key+">").append(temp.get(key)).append("</span>'");
				}
			}
			if(eventlist.size()>0){
				sb.append(",'action':'");
				for (int k=0;k<eventlist.size();k++) {
					sb.append("<a href=# onclick=").append(eventlist.get(k)).append(">").append(textlist.get(k)).append("</a>").append("&nbsp;&nbsp;");
				}
				sb.append("'");
			}
			
			sb.append("}");
		}
		
		sb.append("]");

		sb.append("});");
		
		sb.append("</script>");
		
//		System.out.println("======="+sb.toString());
		try {
			out.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}

	public List<Map<String, Object>> getListmap() {
		return listmap;
	}

	public void setListmap(List<Map<String, Object>> listmap) {
		this.listmap = listmap;
	}
	
	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public void setTitle(String name,String title,String breakpoint,String oper){
		this.namelist.add(name);
		this.titlelist.add(title);
		this.breakpointslist.add(breakpoint);
		this.operslist.add(oper);
	}
	
	public void setAction(String event,String text){
		this.eventlist.add(event);
		this.textlist.add(text);
	}
	
	
	
}

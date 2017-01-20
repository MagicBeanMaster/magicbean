package com.base.label;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * @description 分页实体 
 * @author lq
 * @date 2015年10月16日 
 * @version
 */
public class Pager extends TagSupport{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer curPage;  //当前页
	private Integer pageSize = 10;  //每页显示的条数
	private Integer totalCount = 0;  //总条数
	private String formId;//form表达的ID
	
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();  
		int totalPage=0;
		if (totalCount%pageSize==0) {  
			totalPage = totalCount/pageSize;  
	      } else {  
	    	  totalPage = (totalCount/pageSize)+1;  
	      } 
        
        if (curPage < 1) {  
            curPage = 1;  
        }  
        StringBuffer sb=new StringBuffer(200);
          
        if (totalPage > 0) {  
        	sb.append("<script type='text/javascript'>" +   
                            "function go(pageNum){" +
                            	"var pn = pageNum;"+
                            	"if(typeof(pageNum)=='string'){if(pageNum.indexOf(',')!=-1){pn = pageNum.substr(0,pageNum.indexOf(','));}}"+
                                "var f = document.getElementById('" + formId + "');"+  
                            	"var suburl = f.action;var endurl = suburl;"+
                                "if(suburl.indexOf('pageNum')==-1){"+
	                            	"if(suburl.indexOf('?')!=-1){"+
	                                "endurl = endurl+ '&pageNum='+pn;"+
	        						"}else{"+
	        						"endurl = endurl + '?pageNum='+pn;"+
	        						"}"+
        						"}"+
        						"f.action = endurl;"+
                                "f.submit();"+  
                            "}" +   
                      "</script>");  
        	sb.append("<div ><ul class='pagination'>");  
            int start = 1;  
            int end = totalPage;  
            for(int i=4;i>=1;i--){  
                if((curPage-i)>=1){  
                    start = curPage-i;  
                    break;  
                }  
            }  
            for(int i=4;i>=1;i--){  
                if((curPage+i)<=totalPage){  
                    end = curPage+i;  
                    break;  
                }  
            }  
            //如果小于9则右侧补齐  
            if(end-start+1<=9){  
                Integer padLen = 9-(end-start+1);  
                for(int i=padLen;i>=1;i--){  
                    if((end+i)<=totalPage){  
                        end = end+i;  
                        break;  
                    }  
                }  
            }  
              
            //如果还小于9左侧补齐  
            if(end-start+1<=9){  
                Integer padLen = 9-(end-start+1);  
                for(int i=padLen;i>=1;i--){  
                    if((start-i)>=1){  
                        start = start-i;  
                        break;  
                    }  
                }  
            }  
              
            if(curPage>1){  
                if(start>1){  
                	sb.append("<li><a href='javascript:go(1)'>首页</a></li>");  
                }  
                sb.append("<li><a href='javascript:go("+(curPage-1)+")'>上一页</a></li>");  
            }  
              
            for(int i=start;i<=end;i++){  
                if(i==curPage){  
                	sb.append("<li class='active'><a href='#'>" + i + "</a></li>");  
                }else{  
                	sb.append("<li><a href='javascript:go("+i+")'>" + i + "</a></li>");  
                }  
            }  
            if(curPage<totalPage){  
            	sb.append("<li><a href='javascript:go("+(curPage+1)+")'>下一页</a></li>");  
                if(end<totalPage){  
                	sb.append("<li><a href='javascript:go("+totalPage+")'>尾页</a></li>");  
                }  
            }  
            sb.append("<li><a href='javascript:void(0)'>共" + totalPage + "页" + this.totalCount + "条</a></li>");  
            sb.append("</ul>");  
        }  
        try {
        	out.print(sb.toString());
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return super.doStartTag();  
  
    }  
      
    public static Integer getStartIndex(Integer pageNum, Integer pageSize){  
        Integer res = 0;  
        if(pageNum>0){  
            res = (pageNum-1)*pageSize;  
        }  
        return res;  
    }  
  
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	} 
	
	
}

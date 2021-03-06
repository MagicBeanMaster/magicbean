package com.base.system.comm;

/**
 * 
 * @description  员工\业务员查询的字段枚举类
 * @author yangzx
 * @date 2015年11月16日 下午2:14:46 
 * @version 1.0
 */
public enum SearchColumnToAccount {
	
	NAME("员工名称",3), 
	
	PHONE("联系方式",4);
	
	private String name;
	private int value;

	private SearchColumnToAccount(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static String getNameByValue(int value) {
		SearchColumnToAccount[] esc = SearchColumnToAccount.values();
		for (SearchColumnToAccount a : esc) {
			if (a.getValue() == value) {
				return a.getName();
			}
		}
		return "";
	}
}

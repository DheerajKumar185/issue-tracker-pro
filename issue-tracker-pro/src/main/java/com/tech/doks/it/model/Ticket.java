package com.tech.doks.it.model;

public class Ticket {
	private int id;
	private String summ;
	private String desc;
	private String assign;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSumm() {
		return summ;
	}
	public void setSumm(String summ) {
		this.summ = summ;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAssign() {
		return assign;
	}
	public void setAssign(String assign) {
		this.assign = assign;
	}
}

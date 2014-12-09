package com.atal.bookameme.bean;

public class Planning {
	private String date;
	private String petitDejeuner;
	private String dejeuner;
	private String diner;
	private int id;
	
	
	public String getPetitDejeuner() {
		return petitDejeuner;
	}
	public void setPetitDejeuner(String petitDejeuner) {
		this.petitDejeuner = petitDejeuner;
	}
	public String getDejeuner() {
		return dejeuner;
	}
	public void setDejeuner(String dejeuner) {
		this.dejeuner = dejeuner;
	}
	public String getDiner() {
		return diner;
	}
	public void setDiner(String diner) {
		this.diner = diner;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}

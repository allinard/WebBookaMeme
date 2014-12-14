package com.atal.bookameme.bean;

public class Planning {
	private String date;
	private Repas petitDejeuner;
	private Repas dejeuner;
	private Repas diner;
	private int id;
	private String user;

	
	
	public Repas getPetitDejeuner() {
		return petitDejeuner;
	}
	public void setPetitDejeuner(Repas petitDejeuner) {
		this.petitDejeuner = petitDejeuner;
	}
	public Repas getDejeuner() {
		return dejeuner;
	}
	public void setDejeuner(Repas dejeuner) {
		this.dejeuner = dejeuner;
	}
	public Repas getDiner() {
		return diner;
	}
	public void setDiner(Repas diner) {
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}

package com.atal.bookameme.bean;

public class Repas {
	private Recette entree;
	private Recette plat;
	private Recette dessert;
	
	private int calories;
	
	private int id;
	
	
	public Recette getEntree() {
		return entree;
	}
	public void setEntree(Recette entree) {
		this.entree = entree;
	}
	public Recette getPlat() {
		return plat;
	}
	public void setPlat(Recette plat) {
		this.plat = plat;
	}
	public Recette getDessert() {
		return dessert;
	}
	public void setDessert(Recette dessert) {
		this.dessert = dessert;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	
}

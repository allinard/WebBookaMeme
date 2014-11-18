package com.atal.bookameme.bean;

/**
 * Bean représentant une Recette
 * 
 * @author alexis
 * 
 */
public class Recette implements Comparable<Recette> {

	private int id;
	
	private String ingredients;
	
	private int tempsPrepa;
	
	private int tempsCuisson;
	
	private int indiceFacilite;
	
	private int budget;
	
	private String modePreparation;
	
	private int creePar;
	
	private String photoLink;

	
	@Override
	public int compareTo(Recette arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIngredients() {
		return ingredients;
	}


	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}


	public int getTempsPrepa() {
		return tempsPrepa;
	}


	public void setTempsPrepa(int tempsPrepa) {
		this.tempsPrepa = tempsPrepa;
	}


	public int getTempsCuisson() {
		return tempsCuisson;
	}


	public void setTempsCuisson(int tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}


	public int getIndiceFacilite() {
		return indiceFacilite;
	}


	public void setIndiceFacilite(int indiceFacilite) {
		this.indiceFacilite = indiceFacilite;
	}


	public int getBudget() {
		return budget;
	}


	public void setBudget(int budget) {
		this.budget = budget;
	}


	public String getModePreparation() {
		return modePreparation;
	}


	public void setModePreparation(String modePreparation) {
		this.modePreparation = modePreparation;
	}


	public int getCreePar() {
		return creePar;
	}


	public void setCreePar(int creePar) {
		this.creePar = creePar;
	}


	public String getPhotoLink() {
		return photoLink;
	}


	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}
	
	
	
}

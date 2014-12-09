package com.atal.bookameme.bean;

public class ProfilNutri implements Comparable<ProfilNutri>{

	private int id;

	private String user;
	
	private String alergie;
	
	private String preferences;
	
	private String motivations;
	
	private String huitres;
	
	private String moules;
	
	private String morue;
	
	private String ble;
	
	private String porcorc;
	
	private String viande;
	
	private String animal;
	
	private String fruitsmer;
	
	private String poissons;
	
	private String fruits;
	
	private String legumes;
	
	private String fruitscoque;
	
	@Override
	public int compareTo(ProfilNutri arg0) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAlergie() {
		return alergie;
	}



	public void setAlergie(String alergie) {
		this.alergie = alergie;
	}



	public String getPreferences() {
		return preferences;
	}



	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}



	public String getMotivations() {
		return motivations;
	}



	public void setMotivations(String motivations) {
		this.motivations = motivations;
	}



	public String getHuitres() {
		return huitres;
	}



	public void setHuitres(String huitres) {
		this.huitres = huitres;
	}



	public String getMoules() {
		return moules;
	}



	public void setMoules(String moules) {
		this.moules = moules;
	}



	public String getMorue() {
		return morue;
	}



	public void setMorue(String morue) {
		this.morue = morue;
	}



	public String getBle() {
		return ble;
	}



	public void setBle(String ble) {
		this.ble = ble;
	}



	public String getPorcorc() {
		return porcorc;
	}



	public void setPorcorc(String porcorc) {
		this.porcorc = porcorc;
	}



	public String getViande() {
		return viande;
	}



	public void setViande(String viande) {
		this.viande = viande;
	}



	public String getAnimal() {
		return animal;
	}



	public void setAnimal(String animal) {
		this.animal = animal;
	}



	public String getFruitsmer() {
		return fruitsmer;
	}



	public void setFruitsmer(String fruitsmer) {
		this.fruitsmer = fruitsmer;
	}



	public String getPoissons() {
		return poissons;
	}



	public void setPoissons(String poissons) {
		this.poissons = poissons;
	}



	public String getFruits() {
		return fruits;
	}



	public void setFruits(String fruits) {
		this.fruits = fruits;
	}



	public String getLegumes() {
		return legumes;
	}



	public void setLegumes(String legumes) {
		this.legumes = legumes;
	}



	public String getFruitscoque() {
		return fruitscoque;
	}



	public void setFruitscoque(String fruitscoque) {
		this.fruitscoque = fruitscoque;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer();
		
		s.append("id="+id+"\n"+"-");
		s.append("user="+user+"-");
		s.append("alergie="+alergie+"-");
		s.append("preferences="+preferences+"-");
		s.append("motivations="+motivations+"-");
		s.append("huitres="+huitres+"-");
		s.append("moules="+moules+"-");
		s.append("morue="+morue+"-");
		s.append("ble="+ble+"-");
		s.append("porcorc="+porcorc+"-");
		s.append("viande="+viande+"-");
		s.append("animal="+animal+"-");
		s.append("fruitsmer="+fruitsmer+"-");
		s.append("poissons="+poissons+"-");
		s.append("fruits="+fruits+"-");
		s.append("legumes="+legumes+"-");
		s.append("fruitscoque="+fruitscoque);
		
		return s.toString();
	}
}

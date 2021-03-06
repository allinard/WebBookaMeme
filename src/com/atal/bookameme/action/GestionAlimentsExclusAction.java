package com.atal.bookameme.action;

import com.atal.bookameme.bean.ProfilNutri;
import com.atal.bookameme.dao.ProfilNutriDAO;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

public class GestionAlimentsExclusAction extends ActionSupport{

	
	private User user;

	private boolean huitres;
	private boolean moules;
	private boolean morue;
	private boolean ble;
	private boolean porcorc;
	private boolean viande;
	private boolean animal;
	private boolean fruitsmer;
	private boolean poissons;
	private boolean fruits;
	private boolean legumes;
	private boolean fruitscoque;
	
	public String execute() {
		
		user = UserServiceFactory.getUserService().getCurrentUser();
		if(null==user){
			user = new User("masterAtal@gmail.com", "gmail");
		}

		ProfilNutri profilNutri;
		try{
			profilNutri = ProfilNutriDAO.getProfilNutriByUser(user.toString()).get(0);
			setHuitres(profilNutri.getHuitres().equals("O")?true:false);
			setMoules(profilNutri.getMoules().equals("O")?true:false);
			setMorue(profilNutri.getMorue().equals("O")?true:false);
			setBle(profilNutri.getBle().equals("O")?true:false);
			setPorcorc(profilNutri.getPorcorc().equals("O")?true:false);
			setViande(profilNutri.getViande().equals("O")?true:false);
			setAnimal(profilNutri.getAnimal().equals("O")?true:false);
			setFruitsmer(profilNutri.getFruitsmer().equals("O")?true:false);
			setPoissons(profilNutri.getPoissons().equals("O")?true:false);
			setFruits(profilNutri.getFruits().equals("O")?true:false);
			setLegumes(profilNutri.getLegumes().equals("O")?true:false);
			setFruitscoque(profilNutri.getFruitscoque().equals("O")?true:false);
		}
		catch(Exception e){
			profilNutri = new ProfilNutri();
			profilNutri.setUser(user.toString());
		}
		
		
		return "success";
	}
	
	

	
	public User getUser() {
		return user;
	}

	public void setUser(User u) {
		user = u;
	}




	public boolean isHuitres() {
		return huitres;
	}




	public void setHuitres(boolean huitres) {
		this.huitres = huitres;
	}




	public boolean isMoules() {
		return moules;
	}




	public void setMoules(boolean moules) {
		this.moules = moules;
	}




	public boolean isMorue() {
		return morue;
	}




	public void setMorue(boolean morue) {
		this.morue = morue;
	}




	public boolean isBle() {
		return ble;
	}




	public void setBle(boolean ble) {
		this.ble = ble;
	}




	public boolean isPorcorc() {
		return porcorc;
	}




	public void setPorcorc(boolean porcorc) {
		this.porcorc = porcorc;
	}




	public boolean isViande() {
		return viande;
	}




	public void setViande(boolean viande) {
		this.viande = viande;
	}




	public boolean isAnimal() {
		return animal;
	}




	public void setAnimal(boolean animal) {
		this.animal = animal;
	}




	public boolean isFruitsmer() {
		return fruitsmer;
	}




	public void setFruitsmer(boolean fruitsmer) {
		this.fruitsmer = fruitsmer;
	}




	public boolean isPoissons() {
		return poissons;
	}




	public void setPoissons(boolean poissons) {
		this.poissons = poissons;
	}




	public boolean isFruits() {
		return fruits;
	}




	public void setFruits(boolean fruits) {
		this.fruits = fruits;
	}




	public boolean isLegumes() {
		return legumes;
	}




	public void setLegumes(boolean legumes) {
		this.legumes = legumes;
	}




	public boolean isFruitscoque() {
		return fruitscoque;
	}




	public void setFruitscoque(boolean fruitscoque) {
		this.fruitscoque = fruitscoque;
	}
	
	
}

package com.atal.bookameme.action;

import java.util.List;

import com.atal.bookameme.bean.ProfilNutri;
import com.atal.bookameme.dao.ProfilNutriDAO;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

public class GestionProfilNutriAction extends ActionSupport {
	
	private User user;
	
	private List<String> listeAlergies = Constants.getListeAlergies();
	private List<String> listePreferences = Constants.getListePreferences();
	private List<String> listeMotivations = Constants.getListeMotivation();


	private String alergie;
	private String preferences;
	private String motivations;
	
	
	public String execute() {
		
		user = UserServiceFactory.getUserService().getCurrentUser();
		if(null==user){
			user = new User("masterAtal@gmail.com", "gmail");
		}

		ProfilNutri profilNutri;
		try{
			profilNutri = ProfilNutriDAO.getProfilNutriByUser(user.toString()).get(0);
			setAlergie(profilNutri.getAlergie());
			setPreferences(profilNutri.getPreferences());
			setMotivations(profilNutri.getMotivations());
		}
		catch(Exception e){
			profilNutri = new ProfilNutri();
			profilNutri.setUser(user.toString());
		}

		return "success";
	}
	
	
	
	public String save(){
		user = UserServiceFactory.getUserService().getCurrentUser();
		if(null==user){
			user = new User("masterAtal@gmail.com", "gmail");
		}
		
		ProfilNutri profilNutri;
		try{
			profilNutri = ProfilNutriDAO.getProfilNutriByUser(user.toString()).get(0);
		}
		catch(Exception e){
			profilNutri = new ProfilNutri();
			profilNutri.setUser(user.toString());
		}
		
		profilNutri.setAlergie(alergie);
		profilNutri.setPreferences(preferences);
		profilNutri.setMotivations(motivations);
		
		ProfilNutriDAO.createOrUpdateProfilNutri(profilNutri);
		
		return "success";
	}
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User u) {
		user = u;
	}




	public List<String> getListeAlergies() {
		return listeAlergies;
	}




	public void setListeAlergies(List<String> listeAlergies) {
		this.listeAlergies = listeAlergies;
	}




	public List<String> getListePreferences() {
		return listePreferences;
	}




	public void setListePreferences(List<String> listePreferences) {
		this.listePreferences = listePreferences;
	}




	public List<String> getListeMotivations() {
		return listeMotivations;
	}




	public void setListeMotivations(List<String> listeMotivations) {
		this.listeMotivations = listeMotivations;
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

}

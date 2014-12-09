package com.atal.bookameme.dao;

import java.util.ArrayList;
import java.util.List;
import com.atal.bookameme.bean.ProfilNutri;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


public class ProfilNutriDAO {
	
	
	public static int NEXTID = nextId();

	
	
	public static int nextId() {
		List<ProfilNutri> listeProfilNutri = getAllProfilNutri();
		int plusGrand = 0;

		for (ProfilNutri profilNutri : listeProfilNutri) {
			if (profilNutri.getId() > plusGrand) {
				plusGrand = profilNutri.getId();
			}
		}

		return plusGrand + 1;
	}
	
	
	
	public static List<ProfilNutri> getAllProfilNutri() {
		List<ProfilNutri> listeProfilNutri = new ArrayList<ProfilNutri>();
		for (Entity entity : getAllEntities()) {
			listeProfilNutri.add(getProfilNutri(entity));
		}
		return listeProfilNutri;
	}
	
	
	
	
	/**
	 * Retrun all the products
	 * 
	 * @param kind
	 *            : of kind product
	 * @return products
	 */
	public static Iterable<Entity> getAllEntities() {
		return Util.listEntities("ProfilNutriId", null, null);
	}

	/**
	 * Get product entity
	 * 
	 * @param name
	 *            : name of the product
	 * @return: product entity
	 */
	public static Entity getEntity(ProfilNutri profilNutri) {
		try {
			Key key = KeyFactory.createKey("ProfilNutriId", profilNutri.getId());
			return Util.findEntity(key);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	private static ProfilNutri getProfilNutri(Entity e) {
		ProfilNutri profilNutri = new ProfilNutri();
		profilNutri.setId((int) e.getKey().getId());
			
		profilNutri.setUser((String) e.getProperty("ProfilNutriUser"));
		profilNutri.setAlergie((String) e.getProperty("ProfilNutriAlergie"));
		profilNutri.setAnimal((String) e.getProperty("ProfilNutriAnimal"));
		profilNutri.setBle((String) e.getProperty("ProfilNutriBle"));
		profilNutri.setFruits((String) e.getProperty("ProfilNutriFruits"));
		profilNutri.setFruitscoque((String) e.getProperty("ProfilNutriFruitscoque"));
		profilNutri.setFruitsmer((String) e.getProperty("ProfilNutriFruitsmer"));
		profilNutri.setHuitres((String) e.getProperty("ProfilNutriHuitres"));
		profilNutri.setLegumes((String) e.getProperty("ProfilNutriLegumes"));
		profilNutri.setMorue((String) e.getProperty("ProfilNutriMorue"));
		profilNutri.setMotivations((String) e.getProperty("ProfilNutriMotivations"));
		profilNutri.setMoules((String) e.getProperty("ProfilNutriMoules"));
		profilNutri.setPoissons((String) e.getProperty("ProfilNutriPoissons"));
		profilNutri.setPorcorc((String) e.getProperty("ProfilNutriPorcorc"));
		profilNutri.setPreferences((String) e.getProperty("ProfilNutriPreferences"));
		profilNutri.setViande((String) e.getProperty("ProfilNutriViande"));
		
		return profilNutri;
	}

	
	
	private static Iterable<Entity> getByUser(String user) {
		return Util.listEntities("ProfilNutriId", "ProfilNutriUser", user);
	}
	
	
	
	public static List<ProfilNutri> getProfilNutriByUser(String user) {
		List<ProfilNutri> listeProfilNutri = new ArrayList<ProfilNutri>();
		for (Entity entity : getByUser(user)) {
			listeProfilNutri.add(getProfilNutri(entity));
		}
		return listeProfilNutri;
	}
	
	
	
	
	
	public static void createOrUpdateProfilNutri(ProfilNutri profilNutri) {
		Entity storedProfilNutri = getEntity(profilNutri);
		// create
		if (storedProfilNutri == null) {
			storedProfilNutri = new Entity("ProfilNutriId", NEXTID);
			NEXTID++;
			
			storedProfilNutri.setProperty("ProfilNutriAlergie", profilNutri.getAlergie());
			storedProfilNutri.setProperty("ProfilNutriAnimal", profilNutri.getAnimal());
			storedProfilNutri.setProperty("ProfilNutriBle", profilNutri.getBle());
			storedProfilNutri.setProperty("ProfilNutriFruits", profilNutri.getFruits());
			storedProfilNutri.setProperty("ProfilNutriFruitscoque", profilNutri.getFruitscoque());
			storedProfilNutri.setProperty("ProfilNutriFruitsmer", profilNutri.getFruitsmer());
			storedProfilNutri.setProperty("ProfilNutriHuitres", profilNutri.getHuitres());
			storedProfilNutri.setProperty("ProfilNutriLegumes", profilNutri.getLegumes());
			storedProfilNutri.setProperty("ProfilNutriMorue", profilNutri.getMorue());
			storedProfilNutri.setProperty("ProfilNutriMotivations", profilNutri.getMotivations());
			storedProfilNutri.setProperty("ProfilNutriMoules", profilNutri.getMoules());
			storedProfilNutri.setProperty("ProfilNutriPoissons", profilNutri.getPoissons());
			storedProfilNutri.setProperty("ProfilNutriPorcorc", profilNutri.getPorcorc());
			storedProfilNutri.setProperty("ProfilNutriPreferences", profilNutri.getPreferences());
			storedProfilNutri.setProperty("ProfilNutriUser", profilNutri.getUser());
			storedProfilNutri.setProperty("ProfilNutriViande", profilNutri.getViande());

		}
		// update
		else {
			storedProfilNutri.setProperty("ProfilNutriAlergie", profilNutri.getAlergie());
			storedProfilNutri.setProperty("ProfilNutriAnimal", profilNutri.getAnimal());
			storedProfilNutri.setProperty("ProfilNutriBle", profilNutri.getBle());
			storedProfilNutri.setProperty("ProfilNutriFruits", profilNutri.getFruits());
			storedProfilNutri.setProperty("ProfilNutriFruitscoque", profilNutri.getFruitscoque());
			storedProfilNutri.setProperty("ProfilNutriFruitsmer", profilNutri.getFruitsmer());
			storedProfilNutri.setProperty("ProfilNutriHuitres", profilNutri.getHuitres());
			storedProfilNutri.setProperty("ProfilNutriLegumes", profilNutri.getLegumes());
			storedProfilNutri.setProperty("ProfilNutriMorue", profilNutri.getMorue());
			storedProfilNutri.setProperty("ProfilNutriMotivations", profilNutri.getMotivations());
			storedProfilNutri.setProperty("ProfilNutriMoules", profilNutri.getMoules());
			storedProfilNutri.setProperty("ProfilNutriPoissons", profilNutri.getPoissons());
			storedProfilNutri.setProperty("ProfilNutriPorcorc", profilNutri.getPorcorc());
			storedProfilNutri.setProperty("ProfilNutriPreferences", profilNutri.getPreferences());
			storedProfilNutri.setProperty("ProfilNutriUser", profilNutri.getUser());
			storedProfilNutri.setProperty("ProfilNutriViande", profilNutri.getViande());
		}
		// persist
		Util.persistEntity(storedProfilNutri);
	}

	

}

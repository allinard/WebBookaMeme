package com.atal.bookameme.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.atal.bookameme.bean.Recette;
import com.atal.bookameme.bean.Repas;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class RepasDAO {
	/**
	 * ID de la prochaine recette
	 */
	public static int NEXTID = nextId();

	/**
	 * Methode permettant de créer ou de mettre a jour une recette
	 * 
	 * @param l
	 *            'recette a creer ou mettre a jour
	 */
	public static void createOrUpdateRepas(Repas repas) {
		Entity storedRepas = getEntity(repas);
		// create
		if (storedRepas == null) {
			storedRepas = new Entity("RepasId", NEXTID);
			NEXTID++;
		}	
		// update
		storedRepas.setProperty("RepasEntree", repas.getEntree());
		storedRepas.setProperty("RepasPlat", repas.getPlat());
		storedRepas.setProperty("RepasDessert", repas.getDessert());
		storedRepas.setProperty("RepasCalories", repas.getCalories());
		// persist
		Util.persistEntity(storedRepas);
	}

	/**
	 * Retrun all the products
	 * 
	 * @param kind
	 *            : of kind product
	 * @return products
	 */
	public static Iterable<Entity> getAllEntities() {
		return Util.listEntities("RepasId", null, null);
	}

	/**
	 * Get product entity
	 * 
	 * @param name
	 *            : name of the product
	 * @return: product entity
	 */
	public static Entity getEntity(Repas repas) {
		try {
			Key key = KeyFactory.createKey("RepasId", repas.getId());
			return Util.findEntity(key);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Delete product entity
	 * 
	 * @param productKey
	 *            : product to be deleted
	 * @return status string
	 */
	public static String deleteRepas(Repas repas) {
		Key key = KeyFactory.createKey("RepasId", repas.getId());
		Util.deleteEntity(key);
		return "Repas deleted successfully";
	}

	private static Repas getRepas(Entity e) {
		Repas repas = new Repas();
		repas.setId((int) e.getKey().getId());
		repas.setEntree((Recette) e.getProperty("RepasEntree"));
		repas.setPlat((Recette) e.getProperty("RepasPlat"));
		repas.setDessert((Recette) e.getProperty("RepasDessert"));
		repas.setCalories((int) e.getProperty("RepasCalories"));
		
		return repas;
	}

	/**
	 * Methode retournant la liste de toutes les recettes en cours
	 * 
	 * @return la liste de toutes les recettes en cours
	 */
	public static List<Repas> getAllRepas() {
		List<Repas> listeRepas = new ArrayList<Repas>();
		Set<Repas> tempListe = new TreeSet<Repas>();
		for (Entity entity : getAllEntities()) {
			tempListe.add(getRepas(entity));
		}
		listeRepas.addAll(tempListe);
		return listeRepas;
	}

	/**
	 * Méthode pour la suppression d'une recette
	 * 
	 * @param recetteId
	 *            l'ID de l'recette a supprimer
	 * @return Success ou non
	 */
	public static String deleteRepasWithId(int repasId) {
		Key key = KeyFactory.createKey("RepasId", repasId);
		Util.deleteEntity(key);
		return "Repas deleted successfully";
	}

	public static int nextId() {
		List<Repas> listeRepas = getAllRepas();
		int plusGrand = 0;

		for (Repas repas: listeRepas) {
			if (repas.getId() > plusGrand) {
				plusGrand = repas.getId();
			}
		}

		return plusGrand + 1;
	}
}

package com.atal.bookameme.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.atal.bookameme.bean.Planning;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class PlanningDAO {
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
	public static void createOrUpdatePlanning(Planning planning) {
		Entity storedPlanning = getEntity(planning);
		// create
		if (storedPlanning == null) {
			storedPlanning = new Entity("PlanningId", NEXTID);
			NEXTID++;
		}
		// update
		storedPlanning.setProperty("PlanningDate", planning
				.getDate().replaceAll("\'", " "));
		storedPlanning.setProperty("PlanningPetitDejeuner", planning.getPetitDejeuner());
		storedPlanning.setProperty("PlanningDejeuner", planning.getDejeuner());
		storedPlanning.setProperty("PlanningDiner",
				planning.getDiner());
		
		// persist
		Util.persistEntity(storedPlanning);
	}

	/**
	 * Retrun all the products
	 * 
	 * @param kind
	 *            : of kind product
	 * @return products
	 */
	public static Iterable<Entity> getAllEntities() {
		return Util.listEntities("PlanningId", null, null);
	}

	/**
	 * Get product entity
	 * 
	 * @param name
	 *            : name of the product
	 * @return: product entity
	 */
	public static Entity getEntity(Planning planning) {
		try {
			Key key = KeyFactory.createKey("PlanningId", planning.getId());
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
	public static String deletePlanning(Planning planning) {
		Key key = KeyFactory.createKey("PlanningId", planning.getId());
		Util.deleteEntity(key);
		return "Planning deleted successfully";
	}

	private static Planning getPlanning(Entity e) {
		Planning planning = new Planning();
		planning.setId((int) e.getKey().getId());
			
		planning.setDate((String) e.getProperty("PlanningDate"));
		planning.setPetitDejeuner((String) e.getProperty("PlanningPetitDejeuner"));
		planning.setDejeuner((String) e.getProperty("PlanningDejeuner"));
		planning.setDiner((String) e.getProperty("PlanningDiner"));
				
		return planning;
	}

	/**
	 * Methode retournant la liste de toutes les planning en cours
	 * 
	 * @return la liste de toutes les planning en cours
	 */
	public static List<Planning> getAllPlanning() {
		List<Planning> listePlanning = new ArrayList<Planning>();
		Set<Planning> tempListe = new TreeSet<Planning>();
		for (Entity entity : getAllEntities()) {
			tempListe.add(getPlanning(entity));
		}
		listePlanning.addAll(tempListe);
		return listePlanning;
	}

	/**
	 * Méthode pour la suppression d'une recette
	 * 
	 * @param recetteId
	 *            l'ID de l'recette a supprimer
	 * @return Success ou non
	 */
	public static String deletePlanningWithId(int planningId) {
		Key key = KeyFactory.createKey("PlanningId", planningId);
		Util.deleteEntity(key);
		return "Planning deleted successfully";
	}

	public static int nextId() {
		List<Planning> listePlanning = getAllPlanning();
		int plusGrand = 0;

		for (Planning planning : listePlanning) {
			if (planning.getId() > plusGrand) {
				plusGrand = planning.getId();
			}
		}

		return plusGrand + 1;
	}
	
	private static Iterable<Entity> getByDate(String date) {
		return Util.listEntities("PlanningId", "PlanningDate", date);
	}
	
}

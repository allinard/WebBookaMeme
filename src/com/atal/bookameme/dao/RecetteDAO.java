package com.atal.bookameme.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.atal.bookameme.bean.Recette;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.atal.bookameme.dao.Util;

/**
 * Classe RecetteDAO pour la persistance des recettes
 * 
 * @author alexis
 * 
 */
public class RecetteDAO {

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
	public static void createOrUpdateRecette(Recette recette) {
		Entity storedRecette = getEntity(recette);
		// create
		if (storedRecette == null) {
			storedRecette = new Entity("RecetteId", NEXTID);
			NEXTID++;
			storedRecette.setProperty("RecetteNomRecette", recette
					.getModePreparation().replaceAll("\'", " "));
			storedRecette.setProperty("RecetteIngredients", recette
					.getIngredients().replaceAll("\'", " "));
			storedRecette.setProperty("RecetteBudget", recette.getBudget());
			storedRecette.setProperty("RecetteCreePar", recette.getCreePar());
			storedRecette.setProperty("RecetteIndiceFacilite",
					recette.getIndiceFacilite());
			storedRecette.setProperty("RecetteModePreparation", recette
					.getModePreparation().replaceAll("\'", " "));
			storedRecette.setProperty("RecettePhotoLink",
					recette.getPhotoLink());
			storedRecette.setProperty("RecetteTempsCuisson",
					recette.getTempsCuisson());
			storedRecette.setProperty("RecetteTempsPrepa",
					recette.getTempsPrepa());
		}
		// update
		else {
			storedRecette.setProperty("RecetteNomRecette", recette
					.getModePreparation().replaceAll("\'", " "));
			storedRecette.setProperty("RecetteIngredients", recette
					.getIngredients().replaceAll("\'", " "));
			storedRecette.setProperty("RecetteBudget", recette.getBudget());
			storedRecette.setProperty("RecetteCreePar", recette.getCreePar());
			storedRecette.setProperty("RecetteIndiceFacilite",
					recette.getIndiceFacilite());
			storedRecette.setProperty("RecetteModePreparation", recette
					.getModePreparation().replaceAll("\'", " "));
			storedRecette.setProperty("RecettePhotoLink",
					recette.getPhotoLink());
			storedRecette.setProperty("RecetteTempsCuisson",
					recette.getTempsCuisson());
			storedRecette.setProperty("RecetteTempsPrepa",
					recette.getTempsPrepa());
		}
		// persist
		Util.persistEntity(storedRecette);
	}

	/**
	 * Retrun all the products
	 * 
	 * @param kind
	 *            : of kind product
	 * @return products
	 */
	public static Iterable<Entity> getAllEntities() {
		return Util.listEntities("RecetteId", null, null);
	}

	/**
	 * Get product entity
	 * 
	 * @param name
	 *            : name of the product
	 * @return: product entity
	 */
	public static Entity getEntity(Recette recette) {
		try {
			Key key = KeyFactory.createKey("RecetteId", recette.getId());
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
	public static String deleteRecette(Recette recette) {
		Key key = KeyFactory.createKey("RecetteId", recette.getId());
		Util.deleteEntity(key);
		return "Recette deleted successfully";
	}

	private static Recette getRecette(Entity e) {
		Recette recette = new Recette();
		recette.setId((int) e.getKey().getId());
			
		recette.setBudget((int) e.getProperty("RecetteBudget"));
		recette.setCreePar((int) e.getProperty("RecetteCreePar"));
		recette.setIndiceFacilite((int) e.getProperty("RecetteIndiceFacilite"));
		recette.setIngredients((String) e.getProperty("RecetteIngredients"));
		recette.setModePreparation((String) e.getProperty("RecetteModePreparation"));
		recette.setPhotoLink((String) e.getProperty("RecettePhotoLink"));
		recette.setTempsCuisson((int) e.getProperty("RecetteTempsCuisson"));
		recette.setTempsPrepa((int) e.getProperty("RecetteTempsPrepa"));
		recette.setNomRecette((String)e.getProperty("RecetteNomRecette"));
		
		return recette;
	}

	/**
	 * Methode retournant la liste de toutes les recettes en cours
	 * 
	 * @return la liste de toutes les recettes en cours
	 */
	public static List<Recette> getAllRecettes() {
		List<Recette> listeRecette = new ArrayList<Recette>();
		Set<Recette> tempListe = new TreeSet<Recette>();
		for (Entity entity : getAllEntities()) {
			tempListe.add(getRecette(entity));
		}
		listeRecette.addAll(tempListe);
		return listeRecette;
	}

	/**
	 * Méthode pour la suppression d'une recette
	 * 
	 * @param recetteId
	 *            l'ID de l'recette a supprimer
	 * @return Success ou non
	 */
	public static String deleteRecetteWithId(int recetteId) {
		Key key = KeyFactory.createKey("RecetteId", recetteId);
		Util.deleteEntity(key);
		return "Recette deleted successfully";
	}

	public static int nextId() {
		List<Recette> listeRecettes = getAllRecettes();
		int plusGrand = 0;

		for (Recette recette : listeRecettes) {
			if (recette.getId() > plusGrand) {
				plusGrand = recette.getId();
			}
		}

		return plusGrand + 1;
	}
	

	private static Iterable<Entity> getByIngredients(String ingredients) {
		return Util.listEntities("RecetteId", "RecetteIngredients", ingredients);
	}

	
	public static List<Recette> getRecetteByAdresse(String ingredients) {
		List<Recette> listeRecette = new ArrayList<Recette>();
		Set<Recette> tempListe = new TreeSet<Recette>();
		for (Entity entity : getByIngredients(ingredients)) {
			tempListe.add(getRecette(entity));
		}
		listeRecette.addAll(tempListe);
		return listeRecette;
	}
	
	
	private static Iterable<Entity> getByFacilite(String facilite) {
		return Util.listEntities("RecetteId", "RecetteIndiceFacilite", facilite);
	}

	
	public static List<Recette> getRecetteByFacilite(String facilite) {
		List<Recette> listeRecette = new ArrayList<Recette>();
		Set<Recette> tempListe = new TreeSet<Recette>();
		for (Entity entity : getByFacilite(facilite)) {
			tempListe.add(getRecette(entity));
		}
		listeRecette.addAll(tempListe);
		return listeRecette;
	}

}

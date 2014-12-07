package com.atal.bookameme.action;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	
	
	public static List<String> getListeAlergies()
	{
		List<String> listeCat = new ArrayList<String>();
		listeCat.add("Aucune");
		listeCat.add("Œuf");
		listeCat.add("Arachide");
		listeCat.add("Poisson");
		listeCat.add("Lait");
		listeCat.add("Soja");
		listeCat.add("Pois");
		listeCat.add("Bœuf");
		listeCat.add("Crustacés");
		listeCat.add("Moutarde");
		listeCat.add("Noisette");
		listeCat.add("Noix de coco");
		listeCat.add("Porc");
		listeCat.add("Poulet");
		listeCat.add("Ail");
		listeCat.add("Tournesol");
		listeCat.add("Carotte");
		listeCat.add("Amande");
		listeCat.add("Pêche");
		listeCat.add("Blé");
		listeCat.add("Tomate");
		listeCat.add("Banane");
		listeCat.add("Avocat");
		listeCat.add("Kiwi");
		listeCat.add("Moules)");
		listeCat.add("Pommes de terre");
		listeCat.add("Mangue");
		return listeCat;
	}
	
	
	
	
	
	public static List<String> getListePreferences()
	{
		List<String> listeCat = new ArrayList<String>();
		listeCat.add("Aucune");
		listeCat.add("Viande");
		listeCat.add("Légumes");
		listeCat.add("Soupes");
		listeCat.add("Végétarien");
		listeCat.add("Végétalien");
		return listeCat;
	}
	
	
	
	
	
	public static List<String> getListeMotivation()
	{
		List<String> listeCat = new ArrayList<String>();
		listeCat.add("Aucune");
		listeCat.add("Maigrir");
		listeCat.add("Dépenser moins");
		return listeCat;
	}
	
	
}

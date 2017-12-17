package org.sid.services;

import java.util.List;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;

public interface BeerServiceInterface {
    public Beer ConsulterBeerId(Long Id);
	public List<Beer> ConsulterBeerType(String type);
	public Beer ConsulterBeerNom(String nom);
	public void ajouterBeer(Beer b);

	public List<Bar> trouverBarBeerNom(String nomBeer);
	public List<Bar> trouverBarBeerType(String type);
	
	
	//public List<Personne> ConsulterPersonner();
	//public Personne ChercherPersonne(Long id);
	//public Personne ChercherPersonne(String nom);
	//public List<Beer> BeerPrefere(Personne p);
	//public List<Bar> BarPrefere(Personne p);
	
	
	//public void noterBeer(Long id);
	//public void supprimerBeer(Long id);
	


}

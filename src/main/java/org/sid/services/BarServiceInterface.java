package org.sid.services;

import java.util.List;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;

public interface BarServiceInterface {
	public List<Bar> listerBar();
	public Bar chercherBarId(Long id);
	public Bar chercherBarNom(String Nom);
	
	public void ajouterBar(Bar b);

	public Bar ajouterBeerToBar(Beer be,Bar ba);
	public void suprimerBeerFromBar(Beer be,Bar ba);

	public List<Personne> ListeClientDeMonBar(Bar Ba);
	public List<Beer> ListerBeerBar(Bar ba);


}

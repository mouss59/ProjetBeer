package org.sid.services;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;

import java.util.List;

public interface PersonneInterface {
    public Personne chercherPersonneId(Long Id);
    public Personne chercherPersonneLoginPass(String Login, String Password);
    public List<Personne> chercherPersonneStatus(String Status);

    public List<Bar> barPrefereParPersonne(Personne P);
    public List<Beer> beerPrefereParPersonne(Personne P);


    public void ajouterBeerPrefere(Personne P ,Beer be);
    public Personne ajouterBarPrefere(Personne P ,Bar ba);
    public Personne trouverPersonneLoginPassword(String login, String password);




}

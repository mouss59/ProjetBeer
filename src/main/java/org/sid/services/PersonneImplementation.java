package org.sid.services;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;
import org.sid.dao.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PersonneImplementation implements PersonneInterface {


    @Autowired
    PersonneRepository personneRepository;

    @Override
    public Personne chercherPersonneId(Long id) {

        return personneRepository.findByIdPersonne(id);
    }

    @Override
    public Personne chercherPersonneLoginPass(String login, String password) {
        return personneRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public List<Personne> chercherPersonneStatus(String status) {

        return personneRepository.findByStatus(status);
    }

    @Override
    public List<Bar> barPrefereParPersonne(Personne P) {

        return P.getBarsPreferes();
    }

    @Override
    public List<Beer> beerPrefereParPersonne(Personne P) {

        return P.getBeersPreferes();
    }

    @Override
    public Personne ajouterBeerPrefere(Personne P, Beer be) {
        P.getBeersPreferes().add(be);
        return personneRepository.save(P);
    }

    @Override
    public Personne ajouterBarPrefere(Personne P, Bar ba) {
        P.getBarsPreferes().add(ba);
        return personneRepository.save(P);
    }

    @Override
    public Personne trouverPersonneLoginPassword(String login, String password) {
        return personneRepository.findByLoginAndPassword(login,password);
    }

}

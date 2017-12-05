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

    /*
    @Autowired
    PersonneRepository personneRepository;

    @Override
    public Personne chercherPersonneId(Long Id) {
        return personneRepository.findByIdPersonne();
    }

    @Override
    public Personne chercherPersonneLoginPass(String Login, String Password) {
        return personneRepository.findByLoginAndPassword();
    }

    @Override
    public List<Personne> chercherPersonneStatus(String Status) {
        return personneRepository.findByStatus();
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
    public void ajouterBeerPrefere(Personne P, Beer be) {
        P.getBeersPreferes().add(be);
        personneRepository.save(P);
    }

    @Override
    public void ajouterBarPrefere(Personne P, Bar ba) {
        P.getBarsPreferes().add(ba);
        personneRepository.save(P);
    }
    */
}

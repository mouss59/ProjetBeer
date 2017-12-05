package org.sid.services;

import java.util.List;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;
import org.sid.dao.BarRepository;
import org.sid.dao.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BarServicesImplementation implements BarServiceInterface {
	@Autowired
	BarRepository barRepository;
	@Autowired
	BeerRepository beerRepository;
	@Override
	public List<Bar> listerBar() {
		// TODO Auto-generated method stub
		return  barRepository.findAll();
	}

	@Override
	public Bar chercherBarId(Long id) {
		// TODO Auto-generated method stub
		return barRepository.findByIdBar(id);
	}

	@Override
	public Bar chercherBarNom(String Nom) {
		// TODO Auto-generated method stub
		return barRepository.findByNom(Nom);
	}

	@Override
	public void ajouterBar(Bar b) {
		// TODO Auto-generated method stub
		barRepository.save(b);
	}

	@Override
	public Bar ajouterBeerToBar(Beer be, Bar ba) {
		// TODO Auto-generated method stub
		ba.getBeers().add(be);
		return barRepository.save(ba);
		
	}


	@Override
	public void suprimerBeerFromBar(Beer be, Bar ba) {
		ba.getBeers().remove(be);
		barRepository.save(ba);
		
	}

    @Override
    public List<Personne> ListeClientDeMonBar(Bar Ba) {
        return Ba.getPersonnes();
    }

    @Override
    public List<Beer> ListerBeerBar(Bar ba) {
        return ba.getBeers();
    }


}

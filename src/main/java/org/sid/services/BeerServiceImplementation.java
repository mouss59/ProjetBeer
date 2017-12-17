package org.sid.services;

import java.util.ArrayList;
import java.util.List;


import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.dao.BarRepository;
import org.sid.dao.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BeerServiceImplementation implements BeerServiceInterface {

	@Autowired
	BeerRepository beerRepository;
	@Autowired
    BarRepository barRepository;
	
	




    @Override
    public Beer ConsulterBeerId(Long id) {
        return beerRepository.findByIdBeer(id);
    }

    @Override
	public List<Beer> ConsulterBeerType(String type) {
		// TODO Auto-generated method stub
		return beerRepository.findByTypeBeer(type);
	}


	@Override
	public Beer ConsulterBeerNom(String nom) {
		// TODO Auto-generated method stub
		return beerRepository.findByNomBeer(nom);
	}


	@Override
	public void ajouterBeer(Beer b) {
		beerRepository.save(b);
		
	}

	@Override
	public List<Bar> trouverBarBeerNom(String nomBeer) {
    	Beer b = beerRepository.findByNomBeer(nomBeer);
		return b.getBars();
	}

	@Override
	public List<Bar> trouverBarBeerType(String type) {

    	List<Beer> lb= ConsulterBeerType(type);
		List<Bar> lbar=new ArrayList<Bar>();
    	for(int i=0 ; i < lb.size() ; i++){
			for(int j = 0; j < lb.get(i).getBars().size() ; j++){
				lbar.add(lb.get(i).getBars().get(j));
			}
		}

    	return lbar;
	}


}

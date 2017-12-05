package org.sid.dao;

import java.util.List;

import org.sid.Entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long>{
	public List<Beer> findAll();
	public Beer findByIdBeer(Long id);
	public List<Beer> findByTypeBeer(String type);
	public Beer findByNomBeer(String nom);

	
}

package org.sid.dao;

import java.util.List;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Long> {
	public List<Bar> findAll();
	public Bar findByNom(String nom);
	public Bar findByIdBar(Long id);
	public Bar findByAdresse(String Adress);


	
}

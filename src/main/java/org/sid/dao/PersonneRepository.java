package org.sid.dao;

import org.sid.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
        public Personne findByIdPersonne(Long id);
        public Personne findByNom(String nom);
        public Personne findByLoginAndPassword(String login, String password);
        public List<Personne> findByStatus(String Status);


}

package org.sid.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;
@Entity
public class Bar implements Serializable {
	@Id @GeneratedValue
	private Long idBar;
	private String nom;
	private String adresse;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name="BAR_BEER",
			joinColumns=@JoinColumn(name="BAR_ID", referencedColumnName="idBar"),
			inverseJoinColumns=@JoinColumn(name="BEER_ID", referencedColumnName="idBeer"))
	private List<Beer> beers=new ArrayList<Beer>();

	@ManyToMany(mappedBy = "barsPreferes")
	private List<Personne> personnes = new ArrayList<Personne>();

	public Bar() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Bar(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}


	public Long getId() {
		return idBar;
	}


	public void setId(Long id) {
		this.idBar = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public List<Beer> getBeers() {
		return beers;
	}


	public void setBeers(List<Beer> beerPropose) {
		this.beers = beerPropose;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}


	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}


	@Override
	public String toString() {
		return "Bar{" +
				", nom='" + nom + '\'' +


				'}';
	}
}

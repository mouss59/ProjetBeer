package org.sid.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
public class Personne implements Serializable {
	@Id @GeneratedValue
	private Long idPersonne;
	private String nom;
	private String login;
	private String password;
	private String status;
	private String prenom;
	private String email;
	private String adress;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		      name="Personne_Bar",
		      joinColumns=@JoinColumn(name="PERSONNE_ID", referencedColumnName="idPersonne"),
		      inverseJoinColumns=@JoinColumn(name="BAR_ID", referencedColumnName="idBar"))
	private List<Bar> barsPreferes=new ArrayList<Bar>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		      name="Personne_Beer",
		      joinColumns=@JoinColumn(name="PERSONNE_ID", referencedColumnName="idPersonne"),
		      inverseJoinColumns=@JoinColumn(name="BEER_ID", referencedColumnName="idBeer"))
	private List<Beer> beersPreferes  = new ArrayList<Beer>();
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(String nom, String prenom, String login ,String password, String status, String email, String adress) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login=login;
		this.password=password;
		this.status=status;
		this.email = email;
		this.adress = adress;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public Long getId() {
		return idPersonne;
	}
	public void setId(Long id) {
		this.idPersonne = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public List<Bar> getBarsPreferes() {
		return barsPreferes;
	}
	public void setBarsPreferes(List<Bar> barsPreferes) {
		this.barsPreferes = barsPreferes;
	}
	public List<Beer> getBeersPreferes() {
		return beersPreferes;
	}
	public void setBeersPreferes(List<Beer> beersPreferes) {
		this.beersPreferes = beersPreferes;
	}
	
	
}

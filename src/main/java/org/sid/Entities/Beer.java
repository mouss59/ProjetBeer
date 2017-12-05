package org.sid.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Beer implements Serializable {
	@Id @GeneratedValue
	private Long idBeer;
	private String nomBeer;
	private String typeBeer;
	private int note;
	@ManyToMany(mappedBy = "beers")
	private List<Bar> bars = new ArrayList<Bar>();
	@ManyToMany(mappedBy = "beersPreferes")
	private List<Personne> personnes= new ArrayList<Personne>();

	public Beer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beer(String nomBeer, String typeBeer, int note) {
		super();
		this.nomBeer = nomBeer;
		this.typeBeer = typeBeer;
		this.note = note;
	}
	public Long getIdBeer() {
		return idBeer;
	}
	public void setIdBeer(Long idBeer) {
		this.idBeer = idBeer;
	}
	public String getNomBeer() {
		return nomBeer;
	}
	public void setNomBeer(String nomBeer) {
		this.nomBeer = nomBeer;
	}
	public String getTypeBeer() {
		return typeBeer;
	}
	public void setTypeBeer(String typeBeer) {
		this.typeBeer = typeBeer;
	}
	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public List<Bar> getBars() {
		return bars;
	}

	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	@Override
	public String toString() {
		return "Beer [nomBeer=" + nomBeer + ", typeBeer=" + typeBeer + ", note=" + note + "]";
	}
	
	

}

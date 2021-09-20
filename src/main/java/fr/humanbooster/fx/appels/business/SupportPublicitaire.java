package fr.humanbooster.fx.appels.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SupportPublicitaire {

	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String nom;

     public SupportPublicitaire(String typeSupport) {
		this.nom = typeSupport;
	}

	public SupportPublicitaire() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "SupportPublicitaire [id=" + id + ", nom=" + nom + "]";
	}
     
}
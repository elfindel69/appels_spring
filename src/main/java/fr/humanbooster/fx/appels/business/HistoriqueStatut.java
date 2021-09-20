package fr.humanbooster.fx.appels.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoriqueStatut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Appel appel;

    @ManyToOne
    private Statut statut;

    private Date dateHistorique;

    public HistoriqueStatut() {
		dateHistorique= new Date();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Appel getAppel() {
		return appel;
	}

	public void setAppel(Appel appel) {
		this.appel = appel;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Date getDateHistorique() {
		return dateHistorique;
	}

	public void setDateHistorique(Date dateHistorique) {
		this.dateHistorique = dateHistorique;
	}

	@Override
	public String toString() {
		return "HistoriqueStatut [id=" + id + ", appel=" + appel + ", statut=" + statut + ", dateHistorique="
				+ dateHistorique + "]";
	}
    
}

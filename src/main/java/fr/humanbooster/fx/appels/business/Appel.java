package fr.humanbooster.fx.appels.business;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Appel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDebut;

    @NotBlank(message="Merci de renseigner l''objet de l''appel")
    @Lob
    private String objet;

    @ManyToMany(fetch=FetchType.EAGER)
    @NotEmpty(message="Merci de sélectionner le ou les employés concernés")
    private List<Employe> employesConcernes;

    @ManyToOne
    @NotNull(message="Merci de préciser l''employé ayant saisi cet appel")
    private Employe operateur;

    @ManyToOne
    private SupportPublicitaire supportPublicitaire;

    @ManyToOne
    @NotNull(message="Merci de préciser le type d''appelant")
    private TypeAppelant typeAppelant;

    @NotBlank(message="Merci de préciser le nom de l''appelant")
    private String nomAppelant;
    
    @NotBlank(message="Merci de préciser le prénom de l''appelant")
    private String prenomAppelant;
    
    @Pattern(regexp="^[0-9]+$", message="Merci de saisir uniquement des chiffres")
    private String numeroDeTelephoneAppelant;

    @OneToMany(mappedBy="appel", cascade=CascadeType.REMOVE)
    private List<HistoriqueStatut> historiqueStatuts;

	@ManyToOne
	private Statut statut;

    public Appel() {
    	dateDebut = new Date();
	}

	public Appel(Employe operateur) {
		this();
		this.operateur = operateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public List<Employe> getEmployesConcernes() {
		return employesConcernes;
	}

	public void setEmployesConcernes(List<Employe> employesConcernes) {
		this.employesConcernes = employesConcernes;
	}

	public Employe getOperateur() {
		return operateur;
	}

	public void setOperateur(Employe operateur) {
		this.operateur = operateur;
	}

	public SupportPublicitaire getSupportPublicitaire() {
		return supportPublicitaire;
	}

	public void setSupportPublicitaire(SupportPublicitaire supportPublicitaire) {
		this.supportPublicitaire = supportPublicitaire;
	}

	public TypeAppelant getTypeAppelant() {
		return typeAppelant;
	}

	public void setTypeAppelant(TypeAppelant typeAppelant) {
		this.typeAppelant = typeAppelant;
	}

	public String getNomAppelant() {
		return nomAppelant;
	}

	public void setNomAppelant(String nomAppelant) {
		this.nomAppelant = nomAppelant;
	}

	public String getPrenomAppelant() {
		return prenomAppelant;
	}

	public void setPrenomAppelant(String prenomAppelant) {
		this.prenomAppelant = prenomAppelant;
	}

	public String getNumeroDeTelephoneAppelant() {
		return numeroDeTelephoneAppelant;
	}

	public void setNumeroDeTelephoneAppelant(String numeroDeTelephoneAppelant) {
		this.numeroDeTelephoneAppelant = numeroDeTelephoneAppelant;
	}

	public List<HistoriqueStatut> getHistoriqueStatuts() {
		return historiqueStatuts;
	}

	public void setHistoriqueStatuts(List<HistoriqueStatut> historiqueStatuts) {
		this.historiqueStatuts = historiqueStatuts;
	}

	@Override
	public String toString() {
		return "Appel [id=" + id + ", dateDebut=" + dateDebut + ", objet=" + objet + ", operateur=" + operateur
				+ ", supportPublicitaire=" + supportPublicitaire + ", typeAppelant=" + typeAppelant + ", nomAppelant="
				+ nomAppelant + ", prenomAppelant=" + prenomAppelant + ", numeroDeTelephoneAppelant="
				+ numeroDeTelephoneAppelant + "]";
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}
}
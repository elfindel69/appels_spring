package fr.humanbooster.fx.appels.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String email;
    @Size(min=4)
    private String motDePasse;

    @OneToMany(mappedBy="operateur")
    private List<Appel> appelsRecus;

    @ManyToMany(mappedBy="employesConcernes")
    private List<Appel> appelsConcernes;

    public Employe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Appel> getAppelsRecus() {
        return appelsRecus;
    }

    public void setAppelsRecus(List<Appel> appelsRecus) {
        this.appelsRecus = appelsRecus;
    }

    public List<Appel> getAppelsConcernes() {
        return appelsConcernes;
    }

    public void setAppelsConcernes(List<Appel> appelsConcernes) {
        this.appelsConcernes = appelsConcernes;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}

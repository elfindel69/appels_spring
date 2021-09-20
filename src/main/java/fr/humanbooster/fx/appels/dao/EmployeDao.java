package fr.humanbooster.fx.appels.dao;

import fr.humanbooster.fx.appels.business.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeDao extends JpaRepository<Employe, Long> {
    Employe findByEmailAndMotDePasse(String email, String password);

    Employe findByEmail(String email);
}

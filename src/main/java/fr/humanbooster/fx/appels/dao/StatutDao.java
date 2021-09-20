package fr.humanbooster.fx.appels.dao;

import fr.humanbooster.fx.appels.business.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutDao extends JpaRepository<Statut, Long> {
}

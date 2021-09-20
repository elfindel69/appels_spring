package fr.humanbooster.fx.appels.dao;

import fr.humanbooster.fx.appels.business.HistoriqueStatut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueStatutDao extends JpaRepository<HistoriqueStatut,Long> {
}

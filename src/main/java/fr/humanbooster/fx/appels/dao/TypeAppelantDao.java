package fr.humanbooster.fx.appels.dao;

import fr.humanbooster.fx.appels.business.TypeAppelant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAppelantDao extends JpaRepository<TypeAppelant,Long> {
}

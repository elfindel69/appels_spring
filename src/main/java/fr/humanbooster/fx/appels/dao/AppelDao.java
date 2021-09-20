package fr.humanbooster.fx.appels.dao;

import fr.humanbooster.fx.appels.business.Appel;
import fr.humanbooster.fx.appels.business.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppelDao extends JpaRepository<Appel,Long> {

    @Query(value="SELECT a FROM Appel a WHERE a.nomAppelant LIKE :nomAppelant OR :employe MEMBER OF a.employesConcernes")
    Page<Appel> findAppelsByNomAppelantContainingOrEmployesConcernesIn(String nomAppelant, Employe employe, Pageable pageable);

    Page<Appel> findAppelsByNomAppelantContaining(String nomAppelant, Pageable pageable);
}

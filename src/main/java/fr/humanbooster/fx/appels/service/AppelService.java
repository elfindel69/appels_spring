package fr.humanbooster.fx.appels.service;

import fr.humanbooster.fx.appels.business.Appel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppelService {
    List<Appel> recupererAppels();

    Page<Appel> recupererAppelsParFiltres(String nomAppelant, Long employeId, Pageable pageable);

    Appel recupererAppelParId(Long id);

    Appel enregisterAppel(Appel appel);

    boolean supprimerAppel(Long id);
}

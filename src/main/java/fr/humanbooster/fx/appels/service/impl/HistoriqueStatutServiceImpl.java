package fr.humanbooster.fx.appels.service.impl;

import fr.humanbooster.fx.appels.business.Appel;
import fr.humanbooster.fx.appels.business.HistoriqueStatut;
import fr.humanbooster.fx.appels.business.Statut;
import fr.humanbooster.fx.appels.dao.HistoriqueStatutDao;
import fr.humanbooster.fx.appels.service.HistoriqueStatutService;
import org.springframework.stereotype.Service;

@Service
public class HistoriqueStatutServiceImpl implements HistoriqueStatutService{

    private final HistoriqueStatutDao historiqueStatutDao;

    public HistoriqueStatutServiceImpl(HistoriqueStatutDao historiqueStatutDao) {
        this.historiqueStatutDao = historiqueStatutDao;
    }

    @Override
    public HistoriqueStatut ajouter(Appel appel, Statut statut) {
        HistoriqueStatut hs = new HistoriqueStatut();
        hs.setAppel(appel);
        hs.setStatut(statut);
        return historiqueStatutDao.save(hs);
    }
}

package fr.humanbooster.fx.appels.service.impl;

import fr.humanbooster.fx.appels.business.Statut;
import fr.humanbooster.fx.appels.dao.StatutDao;
import fr.humanbooster.fx.appels.service.StatutService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutServiceImpl implements StatutService {

    private final StatutDao statutDao;

    public StatutServiceImpl(StatutDao statutDao) {
        this.statutDao = statutDao;
    }

    @Override
    public List<Statut> recupererStatuts() {
        return statutDao.findAll();
    }

    @Override
    public Statut ajouterStatut(String statut) {
        return statutDao.save(new Statut(statut));
    }
}

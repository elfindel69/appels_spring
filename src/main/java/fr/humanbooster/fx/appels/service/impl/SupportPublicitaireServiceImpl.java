package fr.humanbooster.fx.appels.service.impl;

import fr.humanbooster.fx.appels.business.SupportPublicitaire;
import fr.humanbooster.fx.appels.dao.SupportPublicitaireDao;
import fr.humanbooster.fx.appels.service.SupportPublicitaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportPublicitaireServiceImpl implements SupportPublicitaireService {

    private final SupportPublicitaireDao supportPublicitaireDao;

    public SupportPublicitaireServiceImpl(SupportPublicitaireDao supportPublicitaireDao) {
        this.supportPublicitaireDao = supportPublicitaireDao;
    }

    @Override
    public List<SupportPublicitaire> recupererSupportsPublicitaires() {
        return supportPublicitaireDao.findAll();
    }

    @Override
    public SupportPublicitaire ajouterSupportPublicitaire(String typeSupport) {
        return supportPublicitaireDao.save(new SupportPublicitaire(typeSupport));
    }
}

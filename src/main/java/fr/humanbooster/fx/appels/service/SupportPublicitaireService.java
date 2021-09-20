package fr.humanbooster.fx.appels.service;

import fr.humanbooster.fx.appels.business.SupportPublicitaire;


import java.util.List;

public interface SupportPublicitaireService {
    List<SupportPublicitaire> recupererSupportsPublicitaires();

    SupportPublicitaire ajouterSupportPublicitaire(String typeSupport);
}

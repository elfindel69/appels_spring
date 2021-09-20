package fr.humanbooster.fx.appels.service;

import fr.humanbooster.fx.appels.business.Appel;
import fr.humanbooster.fx.appels.business.HistoriqueStatut;
import fr.humanbooster.fx.appels.business.Statut;

public interface HistoriqueStatutService {
    HistoriqueStatut ajouter(Appel appel, Statut statut);
}

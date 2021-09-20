package fr.humanbooster.fx.appels.service;

import fr.humanbooster.fx.appels.business.Statut;

import java.util.List;

public interface StatutService {
    List<Statut> recupererStatuts();

    Statut ajouterStatut(String statut);
}

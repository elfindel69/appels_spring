package fr.humanbooster.fx.appels.service;

import fr.humanbooster.fx.appels.business.TypeAppelant;

import java.util.Collection;
import java.util.List;

public interface TypeAppelantService {
    List<TypeAppelant> recupererTypeAppelants();

    TypeAppelant ajouterTypeAppelant(String type);
}

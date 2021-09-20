package fr.humanbooster.fx.appels.service;

import fr.humanbooster.fx.appels.business.Employe;


import java.util.List;

public interface EmployeService {
    List<Employe> recupererEmployes();

    Employe ajouterEmploye(String email, String password);

    Employe recupererEmploye(String email, String password);

    Employe recupererEmploye(String email);

    Employe recupererEmploye(Long id);
}

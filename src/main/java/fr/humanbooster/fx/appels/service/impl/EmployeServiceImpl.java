package fr.humanbooster.fx.appels.service.impl;

import fr.humanbooster.fx.appels.business.Employe;
import fr.humanbooster.fx.appels.dao.EmployeDao;
import fr.humanbooster.fx.appels.service.EmployeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeDao employeDao;

    public EmployeServiceImpl(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }

    @Override
    public List<Employe> recupererEmployes() {
        return employeDao.findAll();
    }

    @Override
    public Employe ajouterEmploye(String email, String password) {
        Employe employe = new Employe();
        employe.setEmail(email);
        employe.setMotDePasse(password);
        return employeDao.save(employe);
    }

    @Override
    public Employe recupererEmploye(String email, String password) {
        System.out.println("email: "+email+", password: "+password);
        return employeDao.findByEmailAndMotDePasse(email,password);
    }

    @Override
    public Employe recupererEmploye(String email) {
        return employeDao.findByEmail(email);
    }

    @Override
    public Employe recupererEmploye(Long id) {
        return employeDao.findById(id).orElse(null);
    }
}

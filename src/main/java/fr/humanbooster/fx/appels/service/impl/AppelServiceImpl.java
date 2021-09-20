package fr.humanbooster.fx.appels.service.impl;

import fr.humanbooster.fx.appels.business.Appel;
import fr.humanbooster.fx.appels.business.Employe;
import fr.humanbooster.fx.appels.dao.AppelDao;
import fr.humanbooster.fx.appels.service.AppelService;
import fr.humanbooster.fx.appels.service.EmployeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppelServiceImpl implements AppelService {
    private final AppelDao appelDao;
    private final EmployeService employeService;

    public AppelServiceImpl(AppelDao appelDao, EmployeService employeService) {
        this.appelDao = appelDao;
        this.employeService = employeService;
    }

    @Override
    public List<Appel> recupererAppels() {
        return appelDao.findAll();
    }

    @Override
    public Page<Appel> recupererAppelsParFiltres(String nomAppelant, Long employeId, Pageable pageable) {
       Employe employe = employeService.recupererEmploye(employeId);
       if(employe!=null){
           System.out.println("employe: "+employe);
           return appelDao.findAppelsByNomAppelantContainingOrEmployesConcernesIn(nomAppelant,employe,pageable);
       }else{

           return appelDao.findAppelsByNomAppelantContaining(nomAppelant,pageable);
       }

    }

    @Override
    public Appel recupererAppelParId(Long id) {
        return appelDao.findById(id).orElse(null);
    }

    @Override
    public Appel enregisterAppel(Appel appel) {
        return appelDao.save(appel);
    }

    @Override
    public boolean supprimerAppel(Long id) {
        if(recupererAppelParId(id)!=null){
            appelDao.deleteById(id);
            if(recupererAppelParId(id)!=null){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }
}

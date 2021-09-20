package fr.humanbooster.fx.appels.service.impl;

import fr.humanbooster.fx.appels.business.TypeAppelant;
import fr.humanbooster.fx.appels.dao.TypeAppelantDao;
import fr.humanbooster.fx.appels.service.TypeAppelantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAppelantServiceImpl implements TypeAppelantService {

    private final TypeAppelantDao typeAppelantDao;

    public TypeAppelantServiceImpl(TypeAppelantDao typeAppelantDao) {
        this.typeAppelantDao = typeAppelantDao;
    }

    @Override
    public List<TypeAppelant> recupererTypeAppelants() {
        return typeAppelantDao.findAll();
    }

    @Override
    public TypeAppelant ajouterTypeAppelant(String type) {
       return typeAppelantDao.save(new TypeAppelant(type));
    }
}

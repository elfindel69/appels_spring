package fr.humanbooster.fx.appels.controller;

import fr.humanbooster.fx.appels.business.Appel;
import fr.humanbooster.fx.appels.business.Employe;
import fr.humanbooster.fx.appels.business.TypeAppelant;
import fr.humanbooster.fx.appels.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AppelsController {

    private final EmployeService employeService;
    private final TypeAppelantService typeAppelantService;
    private final SupportPublicitaireService supportPublicitaireService;
    private final StatutService statutService;
    private final AppelService appelService;

    private final HttpSession httpSession;
    private final HistoriqueStatutService historiqueStatutService;

    public AppelsController(EmployeService employeService, TypeAppelantService typeAppelantService,
                            SupportPublicitaireService supportPublicitaireService, StatutService statutService,
                            AppelService appelsService, HistoriqueStatutService historiqueStatutService,
                            HttpSession httpSession ) {
        this.employeService = employeService;
        this.typeAppelantService = typeAppelantService;
        this.supportPublicitaireService = supportPublicitaireService;
        this.statutService = statutService;
        this.appelService = appelsService;
        this.historiqueStatutService = historiqueStatutService;
        this.httpSession = httpSession;


    }


    @GetMapping({"/","index"})
    public ModelAndView connexionGet(){
        return new ModelAndView("index");
    }

    @PostMapping("connexion")
    public ModelAndView connexionPost(@RequestParam("email") String email, @RequestParam("password") String password){
        System.out.println("email: "+email+", password: "+password);
        Employe employe = employeService.recupererEmploye(email,password);
        System.out.println(employe);
        if(employe != null){
            httpSession.setAttribute("employe", employe);
            return new ModelAndView("redirect:appels");
        }else{
            return new ModelAndView("redirect:index");
        }
    }

    @GetMapping("appels")
    public ModelAndView appelsGet(@RequestParam(defaultValue = "", name="nomAppelant" ,required = false) String nomAppelant,
                                  @RequestParam(defaultValue = "0", name="employeId" ,required = false) Long employeId
                                         , @PageableDefault(size=5,page=0,sort="dateDebut") Pageable pageable){
        System.out.println("employe:"+employeId);
        ModelAndView mav = new ModelAndView("appels");
        Page<Appel> appels = appelService.recupererAppelsParFiltres(nomAppelant,employeId,pageable);
        System.out.println("appels\n"+appels.getContent());
        mav.addObject("employes",employeService.recupererEmployes());
        mav.addObject("appels",appels);

        return mav;
    }


    @GetMapping("/appel")
    public ModelAndView appelGet(@RequestParam(defaultValue = "0", name="id" ,required = false) Long id) {
        Appel appel;
        if(id!=null&&id >0){
            appel = appelService.recupererAppelParId(id);
        }else{
            appel = new Appel();
        }
        ModelAndView mav = new ModelAndView("appel");
        mav.addObject("appel",appel);
        mav.addObject("employes",employeService.recupererEmployes());
        List<TypeAppelant> types = typeAppelantService.recupererTypeAppelants();
        System.out.println(types);
        mav.addObject("types",types);
        mav.addObject("supports",supportPublicitaireService.recupererSupportsPublicitaires());
        mav.addObject("statuts",statutService.recupererStatuts());
        return mav;
    }
    @PostMapping("/appel")
    public ModelAndView appelPost(@Valid @ModelAttribute Appel appel, BindingResult result) {

        if(result.hasErrors()){
            ModelAndView mav = appelGet(appel.getId());
            mav.addObject("appel", appel);
            return mav;
        }else{
            System.out.println(appel);
            appelService.enregisterAppel(appel);
            historiqueStatutService.ajouter(appel,appel.getStatut());
            return new ModelAndView("redirect:appels");
        }
    }
    @GetMapping("/supprimerAppel")
    public ModelAndView deletePersonneGet(@RequestParam(name="id") Long id) {
        appelService.supprimerAppel(id);
        return new ModelAndView("redirect:appels");
    }

    @GetMapping("deconnexion")
    public ModelAndView deconnexionGet(){
        httpSession.invalidate();
        return new ModelAndView("redirect:index");
    }

    @PostConstruct
    public void init() {
        if(employeService.recupererEmployes().isEmpty()){
            employeService.ajouterEmploye("john@doe.fr","johnny");
            employeService.ajouterEmploye("sarah.connor@spynet.com","sarah");
            employeService.ajouterEmploye("tony@stark.com","tonyStark");
            employeService.ajouterEmploye("misty@cerulean.johto","misty");
        }

        if(typeAppelantService.recupererTypeAppelants().isEmpty()){
            typeAppelantService.ajouterTypeAppelant("Vendeur");
            typeAppelantService.ajouterTypeAppelant("Acquéreur");
        }

        if(supportPublicitaireService.recupererSupportsPublicitaires().isEmpty()){
            supportPublicitaireService.ajouterSupportPublicitaire("Panneau");
            supportPublicitaireService.ajouterSupportPublicitaire("Journal");
        }

        if(statutService.recupererStatuts().isEmpty()){
            statutService.ajouterStatut("En cours");
            statutService.ajouterStatut("Vendu");
            statutService.ajouterStatut("Annulé");
        }

    }
}

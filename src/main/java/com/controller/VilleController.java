package com.controller;

import com.blo.VilleBLO;
import com.dao.VilleDAO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class VilleController {
    @Autowired
    VilleBLO villeBLOService;
    @Autowired
    VilleDAO villeDAO;

    @PostMapping(value = "/createVille")
    public Ville postCreateVille(@RequestParam String codeCommune,
                                 @RequestParam String nomCommune,
                                 @RequestParam String codePostal) throws SQLException {
        Ville ville = new Ville(codeCommune, nomCommune, codePostal);
        return villeDAO.addNewVille(ville);
    }

    @PostMapping(value = "/modifyCodePostal")
    public Ville postModifyCodePostal(@RequestParam String codeCommune,
                                      @RequestParam String codePostal) throws SQLException {
        villeDAO.modifyCodePostal(codeCommune, codePostal);
        return villeBLOService.getInfoCodeCommune(codeCommune);
    }

    @PostMapping(value = "/modifyNomCommune")
    public Ville postModifyNomCommune(@RequestParam String codeCommune,
                                      @RequestParam String nomCommune) throws SQLException {
        villeDAO.modifyNomCommune(codeCommune, nomCommune);
        return villeBLOService.getInfoCodeCommune(codeCommune);
    }

    @PostMapping(value = "/modifyLibelle")
    public Ville postModifyLibelle(@RequestParam String codeCommune,
                                   @RequestParam String libelle) throws SQLException {
        villeDAO.modifyLibelle(codeCommune, libelle);
        return villeBLOService.getInfoCodeCommune(codeCommune);
    }

    @PostMapping(value = "/modifyLigne")
    public Ville postModifyLigne(@RequestParam String codeCommune,
                                 @RequestParam String ligne) throws SQLException {
        villeDAO.modifyLigne(codeCommune, ligne);
        return villeBLOService.getInfoCodeCommune(codeCommune);
    }

    @GetMapping(value = "/villes")
    public List<Ville> getAllVilles() throws SQLException {
        return villeBLOService.getAllVilles();
    }

    @GetMapping("/commune")
    public Ville getCommune(@RequestParam String nomCommune) throws SQLException {
        return villeBLOService.getInfoCommune(nomCommune);
    }

    @GetMapping("/codePostal")
    public Ville getCodePostal(@RequestParam String codePostal) throws SQLException {
        return villeBLOService.getInfoCodePostal(codePostal);
    }

    @GetMapping("/codeCommune")
    public Ville getCodeCommune(@RequestParam String codeCommune) throws SQLException {
        return villeBLOService.getInfoCodeCommune(codeCommune);
    }

    @PutMapping("/modifyVille")
    public Ville putModifyVille(@RequestParam String codeCommune, @RequestParam String nomCommune, @RequestParam String codePostal) throws SQLException {
        return villeDAO.modifyVille(codeCommune, nomCommune, codePostal);
    }

    @DeleteMapping("/deleteVille")
    public String deleteVille(@RequestParam String codeCommune) throws SQLException {
        return villeDAO.deleteVille(codeCommune);


    }


}




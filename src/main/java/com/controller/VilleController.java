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

    @PostMapping(value = "/commune/modifyCodePostal")
    public String postModifyVille(@RequestParam String nomCommune,
                                  @RequestParam String codePostal) throws SQLException {
        return villeDAO.modifyVilleCodePostal(nomCommune, codePostal);
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

    @PutMapping("/modifyVille")
    public Ville putModifyVille(@RequestParam String codeCommune, @RequestParam String nomCommune, @RequestParam String codePostal) throws SQLException {
        return villeDAO.modifyVille(codeCommune, nomCommune, codePostal);
    }

    @DeleteMapping("/deleteVille")
    public String deleteVille(@RequestParam String codeCommune) throws SQLException {
        return villeDAO.deleteVille(codeCommune);


    }


}




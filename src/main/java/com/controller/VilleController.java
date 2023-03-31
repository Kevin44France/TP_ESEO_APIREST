package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class VilleController {
    @Autowired
    VilleBLO villeBLOService;
    @GetMapping(value="villes")
    public List<Ville> allVilles() throws SQLException {

        return villeBLOService.getAllVilles();

        }
    @GetMapping("/commune")
    public Ville getRequestHandler(@RequestParam String nomCommune) throws SQLException {
        System.out.println("get : " + nomCommune);

        return villeBLOService.getInfoVille(nomCommune);
    }



    }




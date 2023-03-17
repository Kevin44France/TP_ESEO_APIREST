package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class VilleController {
    @Autowired
    VilleBLO villeBLOService;
    @RequestMapping(value="/ville",method = RequestMethod.GET)
    public ArrayList<Ville> get(@RequestParam(required = false, value="codePostal") String  codePostal) throws SQLException {
        System.out.println("get : " +codePostal);

        return villeBLOService.getInfoVilles(codePostal);

        }

    }




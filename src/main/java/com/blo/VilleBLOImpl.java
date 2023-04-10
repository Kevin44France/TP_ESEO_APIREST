package com.blo;


import com.dao.VilleDAO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VilleBLOImpl implements VilleBLO {

    @Autowired
    private VilleDAO villeDAO;

    public List<Ville> getAllVilles() throws SQLException {
        return villeDAO.findAllVilles();
    }

    public Ville getInfoCommune(String nomCommune) throws SQLException {
        ArrayList<Ville> listVilles;
        listVilles = villeDAO.findAllVilles();
        for (Ville ville : listVilles) {
            if (Objects.equals(ville.getNomCommune(), nomCommune)) {
                return ville;
            }
        }
        return null;
    }

    public Ville getInfoCodePostal(String codePostal) throws SQLException {
        ArrayList<Ville> listVilles;
        listVilles = villeDAO.findAllVilles();
        for (Ville ville : listVilles) {
            if (Objects.equals(ville.getCodePostal(), codePostal)) {
                return ville;
            }
        }
        return null;
    }
}

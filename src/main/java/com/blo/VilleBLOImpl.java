package com.blo;



import com.dao.VilleDAO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
@Service
public class VilleBLOImpl implements VilleBLO {

    @Autowired
    private VilleDAO villeDAO;

    public ArrayList<Ville> getInfoVilles(String codePostal) throws SQLException {

        ArrayList<Ville> listVille;

        listVille = villeDAO.findAllVilles();
        return listVille;
    }


}

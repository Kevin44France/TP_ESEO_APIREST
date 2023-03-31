package com.blo;



import com.dao.VilleDAO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.ListView;
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
    public Ville getInfoVille(String nomCommune) throws SQLException {

        ArrayList<Ville> listVilles;

        listVilles = villeDAO.findAllVilles();
        for (Ville ville : listVilles){
            if (Objects.equals(ville.getNomCommune(), nomCommune)){
                System.out.println("found");
                return ville;
            }

        }


        return null;
    }}

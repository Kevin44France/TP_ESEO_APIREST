package com.dao;

import com.dto.Ville;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VilleDAO {
    ArrayList<Ville> findAllVilles() throws SQLException;

    Ville addNewVille(Ville newVille) throws SQLException;

    String modifyVilleCodePostal(String nomCommune, String codePostal) throws SQLException;

    Ville modifyVille(String codeCommune, String nomCommune, String codePostal) throws SQLException;

    String deleteVille(String codeCommune) throws SQLException;
}


package com.dao;

import com.dto.Ville;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VilleDAO {
    ArrayList<Ville> findAllVilles() throws SQLException;

    Ville addNewVille(Ville newVille) throws SQLException;

    public String modifyCodePostal(String code_insee, String codePostal) throws SQLException;

    public String modifyNomCommune(String code_insee, String nouveau_nom) throws SQLException;

    public String modifyLibelle(String code_insee, String nouveau_libelle) throws SQLException;

    public String modifyLigne(String code_insee, String ligne) throws SQLException;

    Ville modifyVille(String codeCommune, String nomCommune, String codePostal) throws SQLException;

    String deleteVille(String codeCommune) throws SQLException;
}


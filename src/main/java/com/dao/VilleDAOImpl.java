package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
@Repository
public class VilleDAOImpl implements VilleDAO {


    public ArrayList<Ville> findAllVilles() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ville_france";
        String username = "root";
        String password = "root";

        ArrayList<Ville> listVille = new ArrayList<>();
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ville_france");

        while (rs.next()) {
            String codePostal = rs.getString("Code_postal");
            String nomCommune = rs.getString("Nom_commune");
            String ligne = rs.getString("Libelle_acheminement");
            Ville ville = new Ville(codePostal, ligne, nomCommune);
            listVille.add(ville);
        }


        conn.close();
        return listVille;
    }
}



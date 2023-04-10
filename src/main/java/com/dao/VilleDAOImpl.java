package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class VilleDAOImpl implements VilleDAO {
    String URL = "jdbc:mysql://localhost:3306/ville_france";
    String USERNAME = "root";
    String PASSWORD = "root";

    public ArrayList<Ville> findAllVilles() throws SQLException {

        ArrayList<Ville> listVille = new ArrayList<>();
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ville_france");

        while (rs.next()) {
            String codeCommune = rs.getString("Code_commune_INSEE");
            String nomCommune = rs.getString("Nom_commune");
            String codePostal = rs.getString("Code_postal");
            String libelle = rs.getString("Libelle_acheminement");
            String ligne = rs.getString("Ligne_5");
            String latitude = rs.getString("Latitude");
            String longitude = rs.getString("Longitude");
            Ville ville = new Ville(codeCommune, nomCommune, codePostal,
                    libelle, ligne, latitude, longitude);
            listVille.add(ville);
        }


        conn.close();
        return listVille;
    }

    public Ville addNewVille(Ville newVille) throws SQLException {

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "INSERT INTO ville_france (Code_commune_INSEE, " +
                "Nom_commune, Code_Postal, Libelle_acheminement, Ligne_5, " +
                "Latitude, Longitude) VALUES (?, ?, ?, ?,'','','')";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, newVille.getCodeCommune());
        stmt.setString(2, newVille.getNomCommune());
        stmt.setString(3, newVille.getCodePostal());
        stmt.setString(4, newVille.getLibelle());

        int rowsInserted = stmt.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("A new row has been inserted.");
        }
        conn.close();
        return newVille;
    }

    public String modifyVilleCodePostal(String nomCommune, String codePostal) throws SQLException {

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "UPDATE ville_france SET Code_Postal = ? WHERE Nom_commune = ?;";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, codePostal);
        stmt.setString(2, nomCommune);

        stmt.executeUpdate();
        conn.close();
        return ("Nouveau code postal = " + codePostal + " pour " + nomCommune);
    }

    public Ville modifyVille(String codeCommune, String nomCommune,
                             String codePostal) throws SQLException {

        Ville ville = new Ville(codeCommune, nomCommune, codePostal);

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "INSERT INTO ville_france (Code_commune_INSEE, " +
                "Nom_commune, Code_Postal, Libelle_acheminement, Ligne_5, " +
                "Latitude, Longitude) VALUES (?, ?, ?, ?,'','','') ON DUPLICATE KEY UPDATE Nom_commune = ?, Code_Postal = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, ville.getCodeCommune());
        stmt.setString(2, ville.getNomCommune());
        stmt.setString(3, ville.getCodePostal());
        stmt.setString(4, ville.getNomCommune());
        stmt.setString(5, ville.getNomCommune());
        stmt.setString(6, ville.getCodePostal());

        stmt.executeUpdate();


        stmt.executeUpdate();
        conn.close();
        return ville;
    }

    public String deleteVille(String codeCommune) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "DELETE FROM ville_france WHERE Code_Commune_INSEE = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, codeCommune);

        stmt.executeUpdate();
        conn.close();
        return "Ville supprimé avec succès !";
    }


}



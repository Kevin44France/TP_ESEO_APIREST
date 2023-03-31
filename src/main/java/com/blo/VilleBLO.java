package com.blo;

import com.dto.Ville;

import java.sql.SQLException;
import java.util.List;

public interface VilleBLO {
    public Ville getInfoVille(String codePostal) throws SQLException;

    public List<Ville> getAllVilles() throws SQLException;



}

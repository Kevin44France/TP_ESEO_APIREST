package com.blo;

import com.dto.Ville;


import java.sql.SQLException;
import java.util.List;

public interface VilleBLO {
    Ville getInfoCommune(String codePostal) throws SQLException;

    List<Ville> getAllVilles() throws SQLException;

    Ville getInfoCodePostal(String codePostal) throws SQLException;


}

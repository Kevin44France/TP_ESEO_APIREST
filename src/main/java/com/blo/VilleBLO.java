package com.blo;

import com.dto.Ville;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VilleBLO {
    public ArrayList<Ville> getInfoVilles(String codePostal) throws SQLException;



}

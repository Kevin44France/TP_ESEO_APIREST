package com.dao;

import com.dto.Ville;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VilleDAO {
    public ArrayList<Ville> findAllVilles() throws SQLException;
}


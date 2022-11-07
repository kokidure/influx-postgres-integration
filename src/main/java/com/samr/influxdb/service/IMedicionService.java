package com.samr.influxdb.service;

import java.sql.Timestamp;
import java.util.List;

import com.samr.influxdb.entities.Mediciones;

public interface IMedicionService {

    public void save(Mediciones m);

    public int createAndSave(Timestamp instante, Double valor, Integer idObis, Integer idMedidor, String nis);

    public int createAndSave();

    public List<Mediciones> listAll();
    
    public List<Mediciones> listLimit(int limit);
}

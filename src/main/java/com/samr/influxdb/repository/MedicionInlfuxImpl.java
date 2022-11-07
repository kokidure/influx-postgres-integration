package com.samr.influxdb.repository;

import java.time.OffsetDateTime;

import com.influxdb.client.InfluxDBClient;
import com.samr.influxdb.entities.MedicionesInflux;

public class MedicionInlfuxImpl implements IMedicionInflux{

    @Override
    public InfluxDBClient buildConnection() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean singlePointWrite() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean singlePointWrite(MedicionesInflux m) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean multiplePointWrite() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteRecord(InfluxDBClient client, OffsetDateTime start, OffsetDateTime end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void queryData(InfluxDBClient client) {
        // TODO Auto-generated method stub
        
    }
    
}

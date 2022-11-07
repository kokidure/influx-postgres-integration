package com.samr.influxdb.repository;

import java.time.OffsetDateTime;

import com.influxdb.client.InfluxDBClient;
import com.samr.influxdb.entities.MedicionesInflux;

public interface IMedicionInflux {
    public InfluxDBClient buildConnection();

    public boolean singlePointWrite();
 
    public boolean singlePointWrite(MedicionesInflux m);

    public boolean multiplePointWrite();

    public boolean deleteRecord(InfluxDBClient client, OffsetDateTime start, OffsetDateTime end);

    public void queryData(InfluxDBClient client);
}

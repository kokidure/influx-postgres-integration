package com.samr.influxdb.repository;

import java.time.OffsetDateTime;
import java.util.List;

import com.influxdb.client.InfluxDBClient;
import com.samr.influxdb.entities.MedicionesInflux;

public interface IMedicionInflux {
    public InfluxDBClient buildConnection(String url, String token, String bucket, String org);

    public boolean singlePointWrite(InfluxDBClient client, MedicionesInflux m);
 
    public boolean multiplePointWrite(InfluxDBClient client, List<MedicionesInflux> list);

    public boolean deleteRecord(InfluxDBClient client, OffsetDateTime start, OffsetDateTime end);

    public List<MedicionesInflux> queryData(InfluxDBClient client);
}

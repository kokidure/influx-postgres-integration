package com.samr.influxdb.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.influxdb.client.DeleteApi;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.samr.influxdb.entities.MedicionesInflux;

public class MedicionInfluxImpl implements IMedicionInflux{

    private String token;
    private String bucket;
    private String org;
    private String url;

    private final Logger LOG = LoggerFactory.getLogger(MedicionInfluxImpl.class);


    @Override
    public InfluxDBClient buildConnection(String url, String token, String bucket, String org) {
        setUrl(url);
        setToken(token);
        setBucket(bucket);
        setOrg(org);
        
        return InfluxDBClientFactory.create(getUrl(), getToken().toCharArray(), getOrg(), getBucket());
    }

    @Override
    public boolean singlePointWrite(InfluxDBClient client, MedicionesInflux m) {
        boolean flag = false;

        try {
            WriteApiBlocking writeApi = client.getWriteApiBlocking();
            writeApi.writeMeasurement(WritePrecision.MS, m);
            flag = true;
        } catch (InfluxException e) {
            LOG.error("Error al insertar en influx.", e);
        }

        return flag;
    }

    @Override
    public boolean multiplePointWrite(InfluxDBClient client, List<MedicionesInflux> list) {
        boolean flag = false;

        try {
            WriteApiBlocking writeApi = client.getWriteApiBlocking();

            if (list != null) {
                writeApi.writeMeasurements(WritePrecision.MS, list);
                flag = true;
            }
        } catch (InfluxException e) {
            LOG.error("Error al insertar en influx.", e);
        }
        
        return flag;
    }

    @Override
    public boolean deleteRecord(InfluxDBClient client, OffsetDateTime start, OffsetDateTime end) {
        boolean flag = false;
        DeleteApi deleteApi = client.getDeleteApi();

        try {
            String predicate = "_measurement=\"Medidor\"";

            deleteApi.delete(start, end, predicate, getBucket(), getOrg());

            flag = true;
        } catch (InfluxException e) {
            LOG.error("Error al insertar en influx.", e);
        }

        return flag;
    }

    @Override
    public List<MedicionesInflux> queryData(InfluxDBClient client) {
        QueryApi queryApi = client.getQueryApi();

        String flux = "from(bucket:\""+ getBucket()+"\") |> range(start:-15m) "
        + "|> filter(fn: (r) => r[\"_measurement\"] == \"Medidor\") "
        + "|> sort() |> yield(name: \"sort\")";

        List<FluxTable> table = queryApi.query(flux);

        for (FluxTable fluxTable : table) {
            List<FluxRecord> records = fluxTable.getRecords();

            for (FluxRecord r : records) {
                LOG.info(r.getValueByKey("id_medidor") + "\t" + r.getValueByKey("valor"));
            }
        }

        return null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

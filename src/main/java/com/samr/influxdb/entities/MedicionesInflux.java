package com.samr.influxdb.entities;

import java.time.Instant;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;

@Measurement(name="Medidor")
public class MedicionesInflux {
    @Column (tag = true)
    private Integer id;
    @Column (timestamp = true)
    private Instant instante;
    @Column
    private Double valor;
    @Column
    private Instant instanteMedidor;
    @Column
    private String adicional;
    @Column
    private Integer idObis;
    @Column
    private Integer idMedidor;
    @Column
    private String nis;
    @Column
    private String tipoConsumoAnde;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getInstante() {
        return instante;
    }

    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Instant getInstanteMedidor() {
        return instanteMedidor;
    }

    public void setInstanteMedidor(Instant instanteMedidor) {
        this.instanteMedidor = instanteMedidor;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public Integer getIdObis() {
        return idObis;
    }

    public void setIdObis(Integer idObis) {
        this.idObis = idObis;
    }

    public Integer getIdMedidor() {
        return idMedidor;
    }

    public void setIdMedidor(Integer idMedidor) {
        this.idMedidor = idMedidor;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getTipoConsumoAnde() {
        return tipoConsumoAnde;
    }

    public void setTipoConsumoAnde(String tipoConsumoAnde) {
        this.tipoConsumoAnde = tipoConsumoAnde;
    }

    
}


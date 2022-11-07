package com.samr.influxdb.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mediciones
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "instante")
    private Timestamp instante;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "instante_medidor")
    private Timestamp instanteMedidor;
    @Column(name = "adicional")
    private String adicional;
    @Column(name = "id_obis")
    private Integer idObis;
    @Column(name = "id_medidor")
    private Integer idMedidor;
    @Column(name = "nis")
    private String nis;
    @Column(name = "tipo_consumo_ande")
    private String tipoConsumoAnde;

    public Mediciones() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getInstante() {
        return instante;
    }

    public void setInstante(Timestamp instante) {
        this.instante = instante;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Timestamp getInstante_medidor() {
        return instanteMedidor;
    }

    public void setInstante_medidor(Timestamp instanteMedidor) {
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

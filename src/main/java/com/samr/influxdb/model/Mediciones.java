package com.samr.influxdb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mediciones
{
    @Id
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
        return instante_medidor;
    }

    public void setInstante_medidor(Timestamp instante_medidor) {
        this.instante_medidor = instante_medidor;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public Integer getId_obis() {
        return id_obis;
    }

    public void setId_obis(Integer id_obis) {
        this.id_obis = id_obis;
    }

    public Integer getId_medidor() {
        return id_medidor;
    }

    public void setId_medidor(Integer id_medidor) {
        this.id_medidor = id_medidor;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getTipo_consumo_ande() {
        return tipo_consumo_ande;
    }

    public void setTipo_consumo_ande(String tipo_consumo_ande) {
        this.tipo_consumo_ande = tipo_consumo_ande;
    }

    
    
    
}

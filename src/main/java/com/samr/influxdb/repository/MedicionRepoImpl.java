package com.samr.influxdb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.samr.influxdb.entities.Mediciones;


@Repository
public class MedicionRepoImpl{
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Mediciones> listLimit(int limit) {
        return entityManager.createQuery("SELECT m FROM Mediciones m", Mediciones.class).setMaxResults(limit).getResultList();
    }
}
package com.samr.influxdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samr.influxdb.entities.Mediciones;

@Repository
public interface IMedicionRepo extends JpaRepository<Mediciones, Integer> {
    
}

package com.samr.influxdb.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samr.influxdb.entities.Medicion;
import com.samr.influxdb.repository.IMedicionRepo;

@Service
public class MedicionService implements IMedicionService {

    @Autowired
    private IMedicionRepo repo;

    @Override
    public void save(Medicion m) {
        repo.save(m);
    }

    @Override
    public int createAndSave(Timestamp instante, Double valor, Integer idObis, Integer idMedidor, String nis) {
        Medicion m = new Medicion();

        m.setInstante(instante);
        m.setValor(valor);
        m.setIdObis(idObis);
        m.setIdMedidor(idMedidor);
        m.setNis(nis);

        repo.save(m);
        
        return idMedidor;
    }

    @Override
    public int createAndSave() {
        Timestamp instante = Timestamp.from(Instant.now());
		double valor = generateRandomNumber(0,1000);
		int idObis = generateRandomNumber(0,100);
		int idMedidor = generateRandomNumber(100, 200);
		String nis = "" + generateRandomNumber(10000, 20000);

        Medicion m = new Medicion();

        m.setInstante(instante);
        m.setValor(valor);
        m.setIdObis(idObis);
        m.setIdMedidor(idMedidor);
        m.setNis(nis);

        repo.save(m);

        return idMedidor;
    }
    
    private static int generateRandomNumber(int min, int max){
		Random random = new Random();
		int number = min + random.nextInt(max);
		
		return number;
	}

    @Override
    public List<Medicion> listAll() {
        List<Medicion> mediciones = repo.findAll();
        
        return mediciones;
    }
}

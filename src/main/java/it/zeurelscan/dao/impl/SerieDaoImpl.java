package it.zeurelscan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import it.zeurelscan.dao.SerieDao;
import it.zeurelscan.model.Serie;


@Component
public class SerieDaoImpl implements SerieDao{

	Logger log = Logger.getLogger(SerieDaoImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	
	@Override
	public Serie findSerieById(int id) {
		Serie city = entityManager.find(Serie.class, id);		
		return city;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Serie> getSerie() {
		try {
			return  entityManager.createNamedQuery("getSerie").getResultList();
		} catch (Exception e) {
			log.debug("problemi con il recupero delle serie",e);
			return null;
		}
		
	}

}

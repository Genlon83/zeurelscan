package it.zeurelscan.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import it.zeurelscan.dao.PaginaDao;
import it.zeurelscan.model.Pagina;

@Component
public class PaginaDaoImpl implements PaginaDao{

	
	@PersistenceContext
	EntityManager entityManager;
	
	Logger log = Logger.getLogger(Pagina.class);
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pagina> getPagine(){
		try {
			  return  entityManager.createNamedQuery("getPagine").getResultList();
		} catch (Exception e) {
			log.debug("Errore nel recupero pagine ", e);
			 return null;
		}
      
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Pagina> getPagineBySerieName(String titolo) {
		try {
			return  entityManager.createNamedQuery("getPagineBySerieName").setParameter("titolo", titolo).getResultList();
		} catch (Exception e) {
			log.debug("Errore nel recupero pagine per serie", e);
			return null;
		}
	
		
	}

	
	
	
	
}

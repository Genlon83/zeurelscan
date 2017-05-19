package it.zeurelscan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.zeurelscan.dao.SerieDao;
import it.zeurelscan.model.Serie;
import it.zeurelscan.service.SerieService;

@Service("serieService")
@Transactional
public class SerieServiceImpl implements SerieService{

	@Autowired
	SerieDao serieDao;
	
	
	
	@Override
	public List<Serie> getSerie() {
		List<Serie> lista = serieDao.getSerie();
		return lista;
	}




}

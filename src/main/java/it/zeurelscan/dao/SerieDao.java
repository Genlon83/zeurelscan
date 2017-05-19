package it.zeurelscan.dao;

import java.util.List;

import it.zeurelscan.model.Serie;

public interface SerieDao {

	
	public List<Serie> getSerie();
	
	public Serie findSerieById(int id);
}

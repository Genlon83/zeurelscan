package it.zeurelscan.dao;

import java.util.List;

import it.zeurelscan.model.Pagina;

public interface PaginaDao {
	
	
	public List<Pagina> getPagine();
	
	public List<Pagina> getPagineBySerieName(String titolo);

}

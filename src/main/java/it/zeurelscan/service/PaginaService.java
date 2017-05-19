package it.zeurelscan.service;

import java.util.List;

import it.zeurelscan.model.Pagina;

public interface PaginaService {

	
	public List<Pagina> getPagine();
	
	public List<Pagina> getPagineBySerieName(String titolo);
}

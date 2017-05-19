package it.zeurelscan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.zeurelscan.dao.PaginaDao;
import it.zeurelscan.model.Pagina;
import it.zeurelscan.service.PaginaService;

@Service("immaginiService")
@Component
@Transactional
public class PaginaServiceImpl implements PaginaService{

	@Autowired
	PaginaDao paginaDao;
	
	
	
	@Override
	public List<Pagina> getPagine() {
		List<Pagina> lista = paginaDao.getPagine();
		return lista;
	}

	
	@Override
	public List<Pagina> getPagineBySerieName(String titolo){
		return paginaDao.getPagineBySerieName(titolo);
	}
	
	
}

package it.zeurelscan.serviceRest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.zeurelscan.model.Pagina;
import it.zeurelscan.service.PaginaService;
@Controller
public class PaginaServiceRest {

	@Autowired
	PaginaService pagineService;	

	private Logger logger = Logger.getLogger(PaginaServiceRest.class);



	@RequestMapping(value = "/pagine", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pagina>> getImmagini() {
		try {
			List<Pagina> immagini = pagineService.getPagine();
			return new ResponseEntity<List<Pagina>>(immagini, HttpStatus.OK);

		} catch (Exception e) {
			logger.debug("problema con il servizio immagini", e);
			return new ResponseEntity<List<Pagina>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		} 
	}



	@RequestMapping(value = "/pagine2",method=RequestMethod.GET)
	public String immagini2(){
		System.out.println();

		
		return "home";
	}


	@RequestMapping(value="/index/{titolo}",method=RequestMethod.GET)
	public String getPagineByTitolo(@PathVariable(value="titolo") String titolo , HttpSession session){
		String reindirizzamento = "pagina";

		List<Pagina> lista = pagineService.getPagineBySerieName(titolo);
		
		if(lista== null || lista.isEmpty())
			reindirizzamento = "redirect:/serie2";
		
		session.setAttribute("pagine", lista);
		
		session.setAttribute("titoloSerieAttuale", titolo);
		
		session.setAttribute("paginaAttuale",1);
		
		return reindirizzamento;
		
	}

	
	
	@RequestMapping(value="/index/{titolo}/{capitolo}",method=RequestMethod.GET)
	public String getPagineByTitoloCap(@PathVariable(value="titolo") String titolo , @PathVariable(value="capitolo") int capitolo, HttpSession session){
		String reindirizzamento = "pagina";
		
		List<Pagina> lista = pagineService.getPagineBySerieName(titolo);
	
		if(lista== null || lista.isEmpty())
			reindirizzamento = "redirect:/serie2";
		
		session.setAttribute("pagine", lista);
		
		session.setAttribute("paginaAttuale",capitolo);
		
		session.setAttribute("titoloSerieAttuale", titolo);
		
		return reindirizzamento;
		
	}
	
	
	
	
	
	
	
}

package it.zeurelscan.serviceRest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.zeurelscan.model.Serie;
import it.zeurelscan.service.SerieService;


@SessionAttributes("lista")


@Controller
public class SerieServiceRest {

	
	
	
	
	
	@Autowired
	SerieService serieService;	

	private Logger logger = Logger.getLogger(SerieServiceRest.class);


	

	

	@RequestMapping(value = "/serie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Serie>> getImmagini() {
		try {
			List<Serie> serie = serieService.getSerie();
			return new ResponseEntity<List<Serie>>(serie, HttpStatus.OK);

		} catch (Exception e) {
			logger.debug("problema con il servizio Serie", e);
			return new ResponseEntity<List<Serie>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		} 
	}


	@RequestMapping(value = "/serie2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getSerie2(HttpSession session) {
		List<Serie> lista = serieService.getSerie();
		
		session.setAttribute("listaSerie", lista);
		return "home";
	}

	@RequestMapping(value = "/serie3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getSerie3(HttpSession session) {
//		List<Serie> lista = serieService.getSerie();
//		
//		session.setAttribute("listaSerie", lista);
		return "home";
	}

	@RequestMapping("/**")
	public String unmappedRequest(HttpServletRequest request) {
	    request.getRequestURI();
	    return " ";
	}

}

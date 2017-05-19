package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import it.zeurelscan.dao.PaginaDao;
import it.zeurelscan.model.Pagina;
import it.zeurelscan.service.PaginaService;	

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-servlet-context.xml",
"classpath:test-context.xml"})
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class,
})
@ActiveProfiles("local")
public class PagineTest {

	@Autowired
	PaginaDao paginaDao;
	
	@Autowired
	PaginaService paginaService;
	
	@Test
	public void immaginiTest(){
		List<Pagina> lista = paginaDao.getPagine();
		assertTrue(!lista.isEmpty());
	}
	
	
	
	@Test 
	public void serieByNameTest(){
		
		List<Pagina> prova = paginaDao.getPagineBySerieName("Bastard");
		
		assertTrue(!prova.isEmpty());
		
		
	}
	
	
	
	@Test 
	public void serieByNameServiceTest(){
		
		List<Pagina> prova = paginaService.getPagineBySerieName("Bastard");
		
		assertTrue(!prova.isEmpty());
		
		
	}
	
	
}

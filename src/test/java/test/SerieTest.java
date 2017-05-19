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

import it.zeurelscan.dao.SerieDao;
import it.zeurelscan.model.Serie;
import it.zeurelscan.service.SerieService;	

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-servlet-context.xml",
"classpath:test-context.xml"})
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class,
})
@ActiveProfiles("local")
public class SerieTest {

	@Autowired
	SerieDao serieDao;
	
	@Autowired
	SerieService serieService;
	
	@Test
	public void serieTest(){
		List<Serie> lista = serieDao.getSerie();
		assertTrue(!lista.isEmpty());
	}
	
	@Test
	public void serieServiceTest(){
		List<Serie> lista = serieService.getSerie();
		assertTrue(!lista.isEmpty());
		
		
	}
	
	
}

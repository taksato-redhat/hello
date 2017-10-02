package local.hello.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import local.hello.entity.Hello;

public class HelloDaoBeanTest {
	
	private EntityManager em;
	private HelloDaoBean dao = new HelloDaoBean();
	
	@Before
	public void setUp() {
		em = Persistence.createEntityManagerFactory("HelloPU").createEntityManager();
		dao.em = em;
	}
	
	@After
	public void tearDown() {
		em.close();
	}
	
	@Test
	public void testPersist() {
		
		String name = "Mike";
		
		Hello hello = new Hello();
		hello.setName(name);
		
		em.getTransaction().begin();
		dao.persist(hello);
		em.getTransaction().commit();

		assert hello.getId() > 0;
		
	}
	
	@Test
	public void testFindAll() {
		
		String name = "Mike";
		
		Hello hello = new Hello();
		hello.setName(name);
		
		em.getTransaction().begin();
		dao.persist(hello);
		List<Hello> results = dao.findAll();
		em.getTransaction().commit();

		assert results.size() > 0;
		
		results.forEach(h -> System.out.println(h));
		
	}
	
}

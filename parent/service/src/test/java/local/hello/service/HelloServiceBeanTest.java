package local.hello.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import local.hello.dao.HelloDaoBean;

public class HelloServiceBeanTest {
	
	private EntityManager em;
	private HelloDaoBean dao = new HelloDaoBean();
	private HelloServiceBean service = new HelloServiceBean();
	
	@Before
	public void setUp() {
		em = Persistence.createEntityManagerFactory("HelloPU").createEntityManager();
		dao.em = em;
		service.dao = dao;
	}
	
	@After
	public void tearDown() {
		em.close();
	}
	
	@Test
	public void testHello() {
		String name = "Mike";
		Assert.assertEquals("Verify hello method result.", "Hello " + name + "! - " + HelloServiceBean.VERSION_NAME, service.hello(name));
	}
	
	@Test
	public void testBye() {
		String name = "Mike";
		Assert.assertEquals("Verify bye method result.", "Bye " + name + "! - " + HelloServiceBean.VERSION_NAME, service.bye(name));
	}
	
	@Test
	public void testNames() {
		String name = "Mike";
		em.getTransaction().begin();
		service.hello(name);
		em.getTransaction().commit();
		Assert.assertEquals("Verify names method result (size).", 1, service.names().size());
		Assert.assertEquals("Verify names method result (name).", name, service.names().get(0).getName());
	}

}

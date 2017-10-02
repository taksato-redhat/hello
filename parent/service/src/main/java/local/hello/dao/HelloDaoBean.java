package local.hello.dao;

import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.hello.entity.Hello;

@Stateless
public class HelloDaoBean implements HelloDao {

	@PersistenceContext(unitName = "HelloPU")
	public EntityManager em;

	@Override
	public void persist(Hello hello) {
		Objects.requireNonNull(hello);
		em.persist(hello);
	}

	@Override
	public List<Hello> findAll() {
		return em.createNamedQuery(Hello.FIND_ALL, Hello.class).getResultList();
	}

}

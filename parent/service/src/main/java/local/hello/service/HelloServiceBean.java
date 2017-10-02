package local.hello.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import local.hello.dao.HelloDao;
import local.hello.entity.Hello;

@Stateless
public class HelloServiceBean implements HelloService {
	
	public static final String VERSION_NAME = "Hello Service v2";
	
	@Inject
	HelloDao dao;

	@Override
	public String hello(String name) {
		Hello hello = new Hello();
		hello.setName(name);
		dao.persist(hello);
		return "Hello " + name + "! - " + VERSION_NAME;
	}

	@Override
	public String bye(String name) {
		return "Bye " + name + "! - " + VERSION_NAME;
	}

	@Override
	public List<Hello> names() {
		return dao.findAll();
	}

}

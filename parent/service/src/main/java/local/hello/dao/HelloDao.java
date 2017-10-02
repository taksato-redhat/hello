package local.hello.dao;

import java.util.List;

import local.hello.entity.Hello;

public interface HelloDao {

	public void persist(Hello hello);

	public List<Hello> findAll();

}

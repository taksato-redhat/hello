package local.hello.service;

import java.util.List;

import local.hello.entity.Hello;

public interface HelloService {
	
	String hello(String name);
	
	String bye(String name);
	
	List<Hello> names();

}

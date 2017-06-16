package yzwTax.itcast.nsfw.dept.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import yzwTax.itcast.nsfw.user.entity.User;

public class Dept implements Serializable {

	private String id;
	private String name;
	private Set<User> users = new HashSet<User>();

	public Dept() {

	}

	public Dept(String id, String name, Set<User> users) {

		this.id = id;
		this.name = name;
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}

//package com.player;
/*
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MusicCircle extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
*/
package com.player;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class MusicCircle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	
	@Basic(optional = false)
	String name;
	
	@Basic(optional = false)
	String owner;
	
	@Basic(optional = false)
	List<String> members;
	
	public Key getId() {
		return id;
	}
	
	public void setId(Key id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}
	
	
}
	

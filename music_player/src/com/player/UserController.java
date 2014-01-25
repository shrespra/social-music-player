/*package com.player;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class UserController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
*/

//package com.jiunes.music;

package com.player;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/*import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
 private static final EntityManagerFactory emfInstance = Persistence
 	 .createEntityManagerFactory("transactions-optional");
*/

@SuppressWarnings("serial")
public class UserController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("User sent GET reqeust");
		
		//get entity Manager
		EntityManager mgr = getEntityManager();
		
		//select all users
		Query query = mgr.createQuery("select from " + User.class.getName());
		List<User> users = query.getResultList();
		
		//convert list of users to string
		String response = toJson(users);
		
		// send a message to client
		resp.getWriter().write(response);
	}
	
public static void main ( String[] args){
	System.out.println(User.class.getName());
}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("User sent POST reqeust");
		//Get input stream
		InputStream in = req.getInputStream();
		
		//convert input stream to string
		String request = inputStreamToString(in);

		// convert string to user
		User user = fromJson(request);

		//get entity manager
		EntityManager mgr = getEntityManager();

		try {
			//write to database using entity manager
			mgr.persist(user); // save

		} finally {
			mgr.close();
		}

	}
	

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

	private User fromJson(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, User.class);
	}

	private String toJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	private String inputStreamToString(InputStream in) {
		Scanner sc = new Scanner(in);
		sc.useDelimiter("\\Z+");
		return sc.next();
	}
}

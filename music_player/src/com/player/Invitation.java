package com.player;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Invitation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	
	@Basic (optional = false)
	String from;
	
	@Basic(optional = false)
	String to;
	
	@Basic(optional = false)
	String token;
	
	@Basic(optional = false)
	String status;
	
	@Basic(optional = false)
	long circleId;
	

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getCircleId() {
		return circleId;
	}

	public void setCircleId(long circleId) {
		this.circleId = circleId;
	}


	
	
	
}
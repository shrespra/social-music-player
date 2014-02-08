package com.player;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Song {
	@Basic(optional = false)
	String name;
	
	@Basic(optional = false)
	long circleId;
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Key id;
	
	@Basic(optional = false)
	String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCircleId(long circleId) {
		this.circleId = circleId;
	}
	
	public long getCircleId() {
		return circleId;
	}
}
package com.pizzapos.model;
import java.util.Date;
import com.pizzapos.utils.*;

public abstract class AbstractEntity {
	private String id;
	private String updatedAt;
	private String updatedBy;
	
	public AbstractEntity() {
		this.id = UUIDGenerator.generateUUID();
		this.updatedAt = new Date().toString();
		this.updatedBy = getCurrentUserId();
	}
	
	public AbstractEntity(String id) {
		this.id = id;
		this.updatedAt = new Date().toString();
		this.updatedBy = getCurrentUserId();
	}
	
	public void update() {
		this.updatedAt = new Date().toString();
		this.updatedBy = getCurrentUserId();
	}
	
	public String getId() {
		return id;
	}
	
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}	
	
	public String getCurrentUserId() {
		User currentUser = Session.getCurrentUser();
		return (currentUser !=null) ? currentUser.getId() : null;
	}
}

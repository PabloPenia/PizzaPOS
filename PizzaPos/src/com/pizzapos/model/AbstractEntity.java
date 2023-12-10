package com.pizzapos.model;
import java.util.Date;
import com.pizzapos.utils.*;

public abstract class AbstractEntity {
	private String id;
	private Date updatedAt;
	private String updatedBy;
	
	public AbstractEntity() {
		this.id = UUIDGenerator.generateUUID();
		this.updatedAt = new Date();
		this.updatedBy = State.getCurrentUser();
	}
	
	public void update(String id) {
		this.id = id;
		this.updatedAt = new Date();
		this.updatedBy = State.getCurrentUser();
	}
	
	public void displayInfo() {
		System.out.println("ID: " + id);
		System.out.println("UPDATED_AT: " + updatedAt);
		System.out.println("UPDATED_BY: " + updatedBy);
	}
}

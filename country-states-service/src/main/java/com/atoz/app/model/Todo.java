package com.atoz.app.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

public class Todo {
	
	private int id;
	private String user;
	private String desc;
	private Date targetDate;
	private String sTargetDate;
	private boolean done;
	private String updId;
	public Todo(int id, String user, String desc, Date targetDate, boolean done) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	

	

}

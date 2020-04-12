package com.atoz.app.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;
@Data
@NoArgsConstructor

public class Todo {
	
	private int id;
	private String user;
	private String desc;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
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

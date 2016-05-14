package com.luonguc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="position")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Position {
	@Id
	@Column(name="pid")
	private int pid;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="description")
	private String description;
	
	public Position() {}
	
	public Position(int pid, String name, String description) {
		this.pid = pid;
		this.pname = name;
		this.description = description;
	}

	public int getId() {
		return pid;
	}

	public void setId(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return pname;
	}

	public void setName(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

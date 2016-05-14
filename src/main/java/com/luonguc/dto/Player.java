package com.luonguc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect
@Entity
@Table(name="player")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Player {
	@Id
	@Column(name="PLAYER_ID")
	private int playerId;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team team;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="POSITION")
	private String position;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE_NO")
	private String phoneNo;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="BIRTHDAY")
	private String birthDate;
	
	public Player() {}

	public Player(int playerId, Team team, String firstName, String lastName,
			String position, String address, String phoneNo, String email,
			String birthDate) {
		this.playerId = playerId;
		this.team = team;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.birthDate = birthDate;
	}



	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
}



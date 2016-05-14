package com.luonguc.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="team")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Team {
	@Id
	@Column(name="TEAM_ID")
	private int teamId;
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	@Column(name="LEAGUE_1")
	private String isLeagueOne;
	
	@Column(name="LEAGUE_2")
	private String isLeagueTwo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="team")
	private List<Player> Player;
	
	

	public Team(int teamId, String teamName, String isLeagueOne,
			String isLeagueTwo, List<com.luonguc.dto.Player> player) {
		this.teamId = teamId;
		this.teamName = teamName;
		this.isLeagueOne = isLeagueOne;
		this.isLeagueTwo = isLeagueTwo;
		Player = player;
	}

	public Team() {}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Player> getPlayer() {
		return Player;
	}

	public void setPlayer(List<Player> player) {
		Player = player;
	}

	public String getIsLeagueOne() {
		return isLeagueOne;
	}

	public void setIsLeagueOne(String isLeagueOne) {
		this.isLeagueOne = isLeagueOne;
	}

	public String getIsLeagueTwo() {
		return isLeagueTwo;
	}

	public void setIsLeagueTwo(String isLeagueTwo) {
		this.isLeagueTwo = isLeagueTwo;
	}
}





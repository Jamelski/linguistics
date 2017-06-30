package com.arl.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private String gameNum;
	private int teamScore;
	private List<Integer> targetLocations;
	private List<GameParticipant> gameParticipants;
	
	public Game(){}
	

	public Game(String gameNum, int teamScore, List<Integer> targetLocations) {
		super();
		this.gameNum = gameNum;
		this.teamScore = teamScore;
		this.targetLocations = targetLocations;
		this.gameParticipants = new ArrayList<GameParticipant>();
	}



	public String getGameNum() {
		return gameNum;
	}

	public void setGameNum(String gameNum) {
		this.gameNum = gameNum;
	}

	public int getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

	public List<Integer> getTargetLocations() {
		return targetLocations;
	}

	public void setTargetLocations(List<Integer> targetLocations) {
		this.targetLocations = targetLocations;
	}


	public List<GameParticipant> getGameParticipants() {
		return gameParticipants;
	}


	public void setGameParticipants(List<GameParticipant> gameParticipants) {
		this.gameParticipants = gameParticipants;
	}
	
	
	
	
}

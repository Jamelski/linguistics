package com.arl.game;

import java.util.ArrayList;
import java.util.List;

public class Participant {
	private String participantID;
	private List<GameParticipant> gameParticipants;
	
	public Participant(){}
	
	public Participant(String participantID){
		this.participantID = participantID;
		this.gameParticipants = new ArrayList<GameParticipant>();
	}

	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public List<GameParticipant> getGameParticipants() {
		return gameParticipants;
	}

	public void setGameParticipants(List<GameParticipant> gameParticipants) {
		this.gameParticipants = gameParticipants;
	}
	
	
}

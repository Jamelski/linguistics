package com.arl.speech;

public class UtteranceEntity {
	private String participantID;
	private String phrase;
	
	public UtteranceEntity(){}

	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	@Override
	public String toString() {
		return "UtteranceEntity [participantID=" + participantID + ", phrase=" + phrase + "]";
	}
	
	
	
	
}

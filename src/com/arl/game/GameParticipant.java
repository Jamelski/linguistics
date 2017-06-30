package com.arl.game;

import java.io.Serializable;

public class GameParticipant {
	public static class Id implements Serializable{
		private String participantID;
		
		private String gameID;
		
		public Id(){}

		public Id(String participantID, String gameID) {
			super();
			this.participantID = participantID;
			this.gameID = gameID;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((gameID == null) ? 0 : gameID.hashCode());
			result = prime * result + ((participantID == null) ? 0 : participantID.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (gameID == null) {
				if (other.gameID != null)
					return false;
			} else if (!gameID.equals(other.gameID))
				return false;
			if (participantID == null) {
				if (other.participantID != null)
					return false;
			} else if (!participantID.equals(other.participantID))
				return false;
			return true;
		}
	}
	
	private Id id = new Id();
	
	private String choices;
	
	private int hits;
	
	private Game game;
	
	private Participant participant;
	
	public GameParticipant(){}
	
	public GameParticipant(String choices, int hits, Game game, Participant participant){
		this.choices = choices;
		this. hits = hits;
		
		this.game = game;
		this.participant = participant;
		
		game.getGameParticipants().add(this);
		participant.getGameParticipants().add(this);
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	
	
}

package com.arl.speech;

import java.util.ArrayList;
import java.util.List;

public class ConversationEntity {
	//instance variables
	private List<UtteranceEntity> utterances;
	private String conversationID;
	
	//no-args constructor
	ConversationEntity(){
		conversationID = new String();
		utterances = new ArrayList<UtteranceEntity>();
	}
	
	//add an utterance to list of utterances
	public void addUtterance(UtteranceEntity utterance){
		utterances.add(utterance);
	}
	
	public List<UtteranceEntity> getUtterances(){
		return this.utterances;
	}

	public String getConversationID() {
		return conversationID;
	}

	public void setConversationID(String conversationID) {
		this.conversationID = conversationID;
	}
	
}

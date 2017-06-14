package com.arl.speech;

import java.util.List;

public class AdjPairs {
	private int lineCount, adjCount;
	
	public AdjPairs(){
		this.lineCount = 0;
		this.adjCount = 0;
	}
	
	public void countAdjPairs(ConversationEntity conversation){
		System.out.println("ConversationID: " + conversation.getConversationID());
		List<UtteranceEntity> utterances = conversation.getUtterances();
		this.lineCount = utterances.size();
		for(int i=0; i < this.lineCount-1; i++){
			if (!utterances.get(i).getParticipantID().equals(utterances.get(i+1).getParticipantID())){
				this.adjCount++;
			}
		}
		System.out.println("Line Count: " + lineCount);
		System.out.println("Adjacency Pairs: " + adjCount);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversationList conversationList = new ConversationList();
		conversationList.createConversationList();
		
		AdjPairs adjPairs = new AdjPairs();
		adjPairs.countAdjPairs(conversationList.getConversationList().get(7));
		
		/*
		for(ConversationEntity convo:conversationList.getConversationList()){
			System.out.println(convo.getConversationID());
		}
		*/
	}

}

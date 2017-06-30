package com.arl.speech;

public class ConversationCountsRow {
	private String conversationID;
	private int adjacancyPairCount;
	private int lineCount;
	
	public ConversationCountsRow(){}
	
	public ConversationCountsRow(String conversationID, int adjacancyPairCount, int lineCount) {
		super();
		this.conversationID = conversationID;
		this.adjacancyPairCount = adjacancyPairCount;
		this.lineCount = lineCount;
	}


	public String getConversationID() {
		return conversationID;
	}


	public void setConversationID(String conversationID) {
		this.conversationID = conversationID;
	}


	public int getAdjacancyPairCount() {
		return adjacancyPairCount;
	}


	public void setAdjacancyPairCount(int adjacancyPairCount) {
		this.adjacancyPairCount = adjacancyPairCount;
	}


	public int getLineCount() {
		return lineCount;
	}


	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	@Override
	public String toString() {
		return "ConversationCountsRow [conversationID=" + conversationID + ", adjacancyPairCount=" + adjacancyPairCount
				+ ", lineCount=" + lineCount + "]";
	}
	
	
}

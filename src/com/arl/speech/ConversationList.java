package com.arl.speech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversationList {
	private List<ConversationEntity> conversations;
	
	public ConversationList(){
		conversations = new ArrayList<ConversationEntity>();
	}
	
	public List<ConversationEntity> getConversationList(){
		return this.conversations;
	}
	
	public void addConversation(ConversationEntity conversation){
		conversations.add(conversation);
	}
	
	public void createConversationList(String csvFile){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int mycount = 0;
            ConversationEntity currentConversation = null;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] variable = line.split(cvsSplitBy);
                
                //Skip headers of CSV file
                if (mycount < 2){
                	mycount++;
            		continue;
            	}
                
                
                if(currentConversation == null){
                	UtteranceEntity utterance = new UtteranceEntity();
                	currentConversation = new ConversationEntity();
                	currentConversation.setConversationID(variable[0]);
                	utterance.setParticipantID(variable[1]);
                	utterance.setPhrase(variable[4]);
                	currentConversation.addUtterance(utterance);
                	continue;
                }
                if(currentConversation.getConversationID().equals(variable[0])){
                	UtteranceEntity utterance = new UtteranceEntity();
                	utterance.setParticipantID(variable[1]);
                	utterance.setPhrase(variable[4]);
                	currentConversation.addUtterance(utterance);
                }
                else{
                	this.conversations.add(currentConversation);
                	currentConversation = null;
                	UtteranceEntity utterance = new UtteranceEntity();
                	currentConversation = new ConversationEntity();
                	currentConversation.setConversationID(variable[0]);
                	utterance.setParticipantID(variable[1]);
                	utterance.setPhrase(variable[4]);
                	currentConversation.addUtterance(utterance);
                }
                
                mycount++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	public ConversationList removeNonAdjPairConvos(){
		ConversationList cleanConversationList = new ConversationList();
		for(int i=0; i<this.conversations.size(); i++){
			AdjPairs adjPairs = new AdjPairs();
			ConversationEntity checkConversation = new ConversationEntity(this.getConversationList().get(i));
			int numberOfAdjPairs = adjPairs.countAdjPairs(checkConversation);
			if(numberOfAdjPairs > 0){
				cleanConversationList.addConversation(checkConversation);
			}
		}
		return cleanConversationList;
	}
	
	public void exportConversationListToExcel(String fileName){
		String csvFile = fileName;
		FileWriter writer;
		try {
			writer = new FileWriter(csvFile);
			CSVUtils.writeLine(writer, Arrays.asList("GameNum", "Participant", "Message", /*"AdjGameNum",*/ "AdjacencyPairs", "LineCount"));
			for(ConversationEntity conversation:this.conversations){

				AdjPairs adjPairAndLineCount = new AdjPairs(conversation);
				
				String tempConversationID = conversation.getConversationID();
				int adjPairCount = adjPairAndLineCount.getAdjCount();
				int lineCount = adjPairAndLineCount.getLineCount();
			
				
				for(UtteranceEntity ue:conversation.getUtterances()){
					CSVUtils.writeLine(writer, Arrays.asList(tempConversationID,
																ue.getParticipantID(),
																ue.getPhrase(),
																/*tempConversationID,*/
																String.valueOf(adjPairCount),
																String.valueOf(lineCount)));
				}			
				
			}
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void exportAdjacencyPairsToExcel(String fileName){
		List<ConversationCountsRow> conversationCountsTable 
		= new ArrayList<ConversationCountsRow>();


		for(ConversationEntity conversation:this.conversations){
		ConversationCountsRow tempRow;
		AdjPairs adjPairAndLineCount = new AdjPairs(conversation);
		
		tempRow = new ConversationCountsRow();
		tempRow.setConversationID(conversation.getConversationID());
		tempRow.setAdjacancyPairCount(adjPairAndLineCount.getAdjCount());
		tempRow.setLineCount(adjPairAndLineCount.getLineCount());
		
		conversationCountsTable.add(tempRow);
		System.out.println(tempRow);
		}
		
		String csvFile = fileName;
		FileWriter writer;
		try {
			writer = new FileWriter(csvFile);
			CSVUtils.writeLine(writer, Arrays.asList("GameNum", "AdjacencyPairs", "LineCount"));
			for(ConversationCountsRow ccr:conversationCountsTable){
				CSVUtils.writeLine(writer, Arrays.asList(ccr.getConversationID()
															,String.valueOf(ccr.getAdjacancyPairCount())
															,String.valueOf(ccr.getLineCount())));
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversationList conversationList = new ConversationList();
		conversationList.createConversationList("/Users/jlawson/Desktop/Chat_Data.csv");
		
		conversationList = conversationList.removeNonAdjPairConvos();
		
		conversationList.exportConversationListToExcel("/Users/jlawson/Desktop/Adjacency_Conversations.csv");
		
		conversationList.exportAdjacencyPairsToExcel("/Users/jlawson/Desktop/Adjacency_ByGame_Conversations.csv");
	
	}


}

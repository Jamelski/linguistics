package com.arl.speech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConversationList {
	private List<ConversationEntity> conversations;
	
	public ConversationList(){
		conversations = new ArrayList<ConversationEntity>();
	}
	
	public List<ConversationEntity> getConversationList(){
		return this.conversations;
	}
	public void createConversationList(){
		String csvFile = "/Users/jlawson/Desktop/Chat_Data.csv";
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversationList conversationList = new ConversationList();
		conversationList.createConversationList();
		
		System.out.println(conversationList);
		System.out.println(conversationList.conversations.get(0));
		for(ConversationEntity conversation:conversationList.conversations){
			List<UtteranceEntity> tempConvo = conversation.getUtterances();
			for(UtteranceEntity showUtterance:tempConvo){
				System.out.println(showUtterance);
			}
			
			System.out.println();
		}
	
	}


}

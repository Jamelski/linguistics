package com.arl.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.arl.speech.ConversationEntity;
import com.arl.speech.UtteranceEntity;

public class ShadowForceTables {
	private List<Game> games;
	private List<GameParticipant> gameParticipants;
	private List<Participant> participants;
	
	public void createShadowForceTable(String csvFile){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int mycount = 0;
            Game currentGame = null;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] variable = line.split(cvsSplitBy);
                
                //Skip headers of CSV file
                if (mycount < 2){
                	mycount++;
            		continue;
            	}
                
                /*
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
                */
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
}

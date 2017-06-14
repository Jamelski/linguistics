package com.arl.speech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		String csvFile = "/Users/jlawson/Desktop/Chat_Data.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int mycount = 0;
            System.out.println("Hi");
            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
                String[] variable = line.split(cvsSplitBy);
                
                //Skip headers of CSV file
                if (mycount < 2){
                	mycount++;
            		continue;
            	}
                System.out.println("Hi");
                for(String var:variable){
                	System.out.print(var + " ");
                }
                mycount++;
                System.out.println();
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

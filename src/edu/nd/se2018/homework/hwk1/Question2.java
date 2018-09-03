package edu.nd.se2018.homework.hwk1;
import java.util.*;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		for(String word : input.split(" ")) {
			// Every time a word shows up increase count
			if(!stopwords.contains(word) && hmap.containsKey(word) ) {
				int count= hmap.get(word);
				hmap.put(word, count+1);
			}
			// If first time then add to the hmap
			else {
				hmap.put(word, 1);
			}
		}
		
		// Figure out what the highest count is
		int max=Collections.max(hmap.values());
		int winners=0;
		String winner="";
		
		// Find which key(s) the max value is associated with by checking each hmap element
		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
		    String word = entry.getKey();
		    if(entry.getValue() == max) {
		    	winner = word;
		    	winners++;
		    }
		    
		}
		// If only one key then return it otherwise if many with the max return null
		if(winners==1) 
			return winner;
		
		return null;
	}
}

package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	
	private Map<String, Word> dictionary;
	
	public Dictionary() {
		dictionary = new HashMap<>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		if(!dictionary.containsKey(alienWord))
			dictionary.put(alienWord, new Word(alienWord));
		
		dictionary.get(alienWord).addTranslation(translation);
	}
	
	public String translate(String alienWord) {
		if(dictionary.containsKey(alienWord))
			return dictionary.get(alienWord).getTranslations();
		else
			return null;
	}

	
	public String translateWordWildCard(String alienWildCard) {

		// Utilizzo le regular expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere
		alienWildCard = alienWildCard.replaceAll("\\?", ".");

		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (Word w : dictionary.values()) {
			if (w.getAlienWord().matches(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTranslations());
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}	
	
	
	
}
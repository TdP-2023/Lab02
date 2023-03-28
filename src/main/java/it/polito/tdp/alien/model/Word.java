package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.Set;

public class Word {
	private String alienWord;
	private Set<String> translations;
	
	public Word(String alienWord) {
		super();
		this.alienWord = alienWord;
		this.translations = new HashSet<String>();
	}
	
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public void addTranslation(String translation) {
		this.translations.add(translation);
	}
	
	public String getTranslations() {
		String s = "";
		for (String a : translations) {
			s += a + "\n";
		}
		return s;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
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
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	
}
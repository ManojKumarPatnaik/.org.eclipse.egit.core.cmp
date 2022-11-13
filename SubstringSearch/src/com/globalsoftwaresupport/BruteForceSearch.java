package com.globalsoftwaresupport;

public class BruteForceSearch {

	public int search(String text, String pattern) {
	
		// the length() method runs in O(1)
		int lengthOfText = text.length();
		int lengthOfPattern = pattern.length();
		
		// consider all the letters of the text
		for(int i=0;i<=lengthOfText-lengthOfPattern;++i) {
			
			// this j is going to track the letters of the pattern
			int j;
			
			// we have to compare the letters (pattern and text)
			for(j=0;j<lengthOfPattern;++j) {
				if(text.charAt(i+j)!=pattern.charAt(j)) {
					break;
				}
			}
			
			// check whether we have considered all the letters of the pattern
			if(j == lengthOfPattern)
				return i;
		}
		
		// search miss (pattern does not exist in the text)
		return -1;
	}
}

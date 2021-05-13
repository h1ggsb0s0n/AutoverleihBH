package ch.autoverleih;

public class EmailValidator {
	/*
	public static boolean isMailValid(String email)
	{      
	String regex =^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";     "

	return email.matches(regex);
	}*/
	
	public boolean isMailValid(String email)
	{
		
	
	//Check Local Part
	String localPart = getLocalPart(email);
	boolean noDotBeginningAndEnd = dotIsNotFirstOrLast(localPart);
	boolean NoDoubleDot = doesNotContainDoubleDot(localPart);
	boolean noDoubleAt = containsOneAtCharacter(email); 


	//Check DomainPart
	
	String domainPart = getDomainPart(email);
	
	boolean containsAtLeastOneDot = containsOneDot(domainPart);
	
	return noDotBeginningAndEnd && NoDoubleDot && noDoubleAt && containsAtLeastOneDot;
	
	}
	
	private boolean containsOneAtCharacter(String input) {
		char atCharacter = '@';
		long count = input.chars().filter(ch -> ch == atCharacter).count();
		
		if (count == 1 ) {
			return true;
		}
		return false;
	}
	
	
	private boolean doesNotContainDoubleDot(String text) {
		return !text.contains("..");
	}
	
	private boolean dotIsNotFirstOrLast(String text) {
		//Example: .example. -> returns false
		
		boolean noDotBefore = text.charAt(0) != '.';
		boolean noDotAfter = text.charAt(text.length() -1) != '.';
		return noDotBefore && noDotAfter;
		
	}
	
	private boolean hypenIsNotFirstOrLast(String text) {
		//Example: .example. -> returns false
		boolean noHypenBefore = text.charAt(0) != '-';
		boolean noHypenAfter = text.charAt(text.length() -1) != '-';
		return noHypenBefore && noHypenAfter;
		
	}
	
	private boolean containsOneDot(String text) {
		return countCharactersOfType(text, '.') >= 1;
	}
	
	
	private boolean NotLongerThan255Char(String text) {
		if(countCharacters(text) > 255) {
			return false;
		}
		return true;
	}
	
	
	
	//Helper Methods
	
	private String getDomainPart(String email) {
		return email.substring(email .indexOf("@") + 1);
	}
	
	private String getLocalPart(String email) {
		return email.substring(0, email .indexOf("@"));
	}
	
	
	private int countCharacters(String stringToCount) {
		int count = 0;    
		for(int i = 0; i < stringToCount.length(); i++) {    
			if(stringToCount.charAt(i) != ' ')    
				count++;    
		}
		return count;
	}
	
	
	private int countCharactersOfType(String stringToCount, char character) {
		int count = 0;    
		for(int i = 0; i < stringToCount.length(); i++) {    
			if(stringToCount.charAt(i) == character) {    
				count++;    
			}
		}
		return count;
	}
}

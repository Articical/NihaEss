package uk.rythefirst.nihaess.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageFilter {
	
	String regex = "\\b(http|https|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	
	Pattern pattern = Pattern.compile(regex);
	
	public boolean IsUrlMatch(String s) {
        try {
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (RuntimeException e) {
        	if(s.contains("https") || s.contains("http") || s.contains("ftp")) {
        		return true;
        	}
        return false;
        }
    }       

}

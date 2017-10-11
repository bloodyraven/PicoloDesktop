package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String splitLine = "langue : <1>. :)";
		Pattern p = Pattern.compile("<[1-9]+>");
		Matcher m = p.matcher(splitLine);
		if(m.find()) {
			System.out.println(splitLine+" is matching");
			splitLine = splitLine.replace(m.group(0).trim(), Test.getEffet(m.group(0).trim()));
		}
		System.out.println(splitLine);
	}
	
	public static String getEffet(String s) {
		switch (s) {
		case "<1>":
			String[] accents = {"allemand", "anglais", "chinois", "africain", "caille-ra", "du sud", "belge", "ch'ti"};
			return accents[((int)(Math.random()*accents.length))];

		default:
			return "";
		}
	}

}

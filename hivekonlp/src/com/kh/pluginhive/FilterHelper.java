package com.kh.pluginhive;

public class FilterHelper {

	public static String filter(String x)
	{
		x = x.replaceAll("\\\\n", " ");
		x = x.replaceAll("\\\n", " ");
		String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
		x = x.replaceAll(regex, "");//remove links
		x = x.replaceAll("@([A-Za-z0-9_]+)", "");
		x = x.replaceAll("gt|lt|‘|’", "");
		//x = x.replaceAll("RT .*", "");
		x = x.replaceAll("RT", "");
		x = x.replaceAll("[\\p{Punct}]"," ");
		x = x.replaceAll("…"," ");
		x = x.replaceAll("[+ㅎ]|[+ㅋ]|[+ㅜ]|[+ㅠ]", "");
		x = x.replaceAll(" +"," ");
		
		x = x.trim();
		return x;
	}
}

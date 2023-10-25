package com.rajan.junit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class SyncExample {

	public static void main(String[] args) {// starting Thread
		/*
		 * String a = "ccc"; String b = "cccccc"; int k = 1; if (a != null) {
		 * for (int i = 0; i < (a.length() - 1); i++) { for (int j = k; j <
		 * (a.length()); j++) { if (a.substring(i, (i + 1)).equalsIgnoreCase(
		 * a.substring(j, (j + 1)))) { System.out.println(a.charAt(i)); break; }
		 * } k++; } } int acii = 0; if (a != null && b!=null) { char[] aa =
		 * a.toCharArray(); char[] bb = b.toCharArray(); List<String> as=new
		 * ArrayList<String>(); List<String> bs=new ArrayList<String>(); for
		 * (int i=0;i<aa.length;i++) {
		 * as.add(String.valueOf(aa[i]).toLowerCase()); } for (int
		 * i=0;i<bb.length;i++) { bs.add(String.valueOf(bb[i]).toLowerCase()); }
		 * List<String> aas=new ArrayList<String>(); aas.addAll(as);
		 * //as.removeAll(bs); bs.removeAll(aas);
		 * System.out.println("first list"); for (String character : as) {
		 * System.out.println(character); } System.out.println("second list");
		 * for (String character : bs) { System.out.println(character); }
		 * 
		 * 
		 * //System.out.println(acii); }
		 */
		// first unique occurance
		/*
		 * String xxx="MorMning"; char[] aa = xxx.toCharArray();
		 * Map<Character,Integer> m=new LinkedHashMap<Character,Integer>(); for
		 * (int i=0;i<aa.length;i++) { if (!m.containsKey(aa[i])) { m.put(aa[i],
		 * 1); }else{ m.put(aa[i], (m.get(aa[i])+1)); } } Iterator
		 * itr=m.keySet().iterator(); while(itr.hasNext()){ Character
		 * s=(Character) itr.next(); if(m.get(s)==1){ System.out.println(s);
		 * break; } }
		 */

		// String reverse
		// Recurssion
		String rev1 = "Hello";
		System.out.println(reverseString(rev1));
		String rev = "Rajan";
		// Iteration
		String reversedString = "";
		for (int i = rev.length(); i > 0; i--) {
			if (rev.length() < 1) {
				System.out.println(rev);
			} else {
				reversedString = reversedString + rev.substring(i - 1, i);
			}
		}
		System.out.println(reversedString);

		// RegExpression
		String aaa = "sd fsf sf";
		String bbb = "1121313";
		Pattern pattern = Pattern.compile("\\s");
		System.out.println(pattern.matcher(aaa).replaceAll("%20"));
		System.out.println(pattern.matcher(bbb).matches());

		// String to int
		String ccc = "123213";
		String ccc1 = "-123213";
		char cc = '0';
		int i = 0;
		int j = 0;
		int l = 0;
		try {
			i = Integer.valueOf(ccc).intValue();
			j = Integer.parseInt(ccc);
			char[] c = ccc.toCharArray();
			int kk = 1;
			for (int k = c.length - 1; k >= 0; k--) {
				l = l + (((int) (c[k]) - (int) (cc)) * kk);
				kk = kk * 10;
			}
			System.out.println(l);
			System.out.println(i);
			System.out.println(j);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("int value is large to be handled");
		}

		SimpleDateFormat gmtDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Current Date Time in GMT
		System.out.println("Current Date and Time in GMT time zone: "
				+ gmtDateFormat.format(new Date()));

		// Current Date time in Local time zone
		SimpleDateFormat localDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		// Current Date Time in Local Timezone
		System.out.println("Current Date and Time in local timezone: "
				+ localDateFormat.format(new Date()));

		int a = 13;
		List values = arrayValue(a);

	}

	static String reverseString(String str) {
		String revString = null;
		if (str.length() < 2) {
			return str;
		}
		revString = reverseString(str.substring(1, str.length()))
				+ str.charAt(0);
		return revString;
	}

	static List arrayValue(int i) {
		int j = 1;
		int k = 2;
		List<Integer> l = new ArrayList<Integer>();
		if (i == 1) {
			l.add(0);
			return l;
		}
		if (k < i) {
			k = k * 2;
			j++;
		} else {
			i = i - k;
			l.add(j);
			arrayValue(i);
		}
		return l;
	}

}

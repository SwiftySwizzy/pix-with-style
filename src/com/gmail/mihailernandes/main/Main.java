package com.gmail.mihailernandes.main;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


import com.gmail.mihailernandes.abstr.AbstractFilter;
import com.gmail.mihailernandes.impl.Sepia;
import com.gmail.mihailernandes.impl.Vintage;
import com.gmail.mihailernandes.impl.Grayscale;
import com.gmail.mihailernandes.impl.Negative;

public class Main {

	public static void main(String[] args) {

		Hashtable<String, AbstractFilter> filterNames = new Hashtable<String, AbstractFilter>();

		filterNames.put("grayscale", new Grayscale(0.299, 0.587, 0.114));
		filterNames.put("sepia", new Sepia());
		filterNames.put("negative", new Negative());
		filterNames.put("vintage", new Vintage());

		for (String input : args) {
			if (input.equals("help")) {
				Iterator<Map.Entry<String, AbstractFilter>> it = filterNames.entrySet().iterator();	
				while(it.hasNext()) {
					Map.Entry<String, AbstractFilter> entry = it.next();
					System.err.println(entry.getKey());
				}
			}
			if (filterNames.containsKey(input)) {
				AbstractFilter filter = filterNames.get(input);
				filter.filter(args[0]);
			}
		}
	}
}

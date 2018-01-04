package com.gmail.mihailernandes.main;

import java.util.Hashtable;

import com.gmail.mihailernandes.abstr.AbstractFilter;
import com.gmail.mihailernandes.impl.Sepia;
import com.gmail.mihailernandes.impl.Vintage;
import com.gmail.mihailernandes.impl.Grayscale;
import com.gmail.mihailernandes.impl.Negative;

public class Main {

	public static void main(String[] args) {
		String path = args[0];
		String filterName = args[1];
		
		Hashtable<String, AbstractFilter> filterNames = new Hashtable<String, AbstractFilter>();
		
		filterNames.put("grayscale", new Grayscale(0.299, 0.587, 0.114));
		filterNames.put("sepia", new Sepia());
		filterNames.put("negative", new Negative());
		filterNames.put("vintage", new Vintage());
		
		if (filterNames.containsKey(filterName)) {
			AbstractFilter filter = filterNames.get(filterName);
			filter.filter(path);
		}
		
	}

}

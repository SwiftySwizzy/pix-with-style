package com.gmail.mihailernandes.main;

import java.util.Hashtable;

import com.gmail.mihailernandes.abstr.AbstractFilter;
import com.gmail.mihailernandes.impl.Bayer;
import com.gmail.mihailernandes.impl.Grayscale;

public class Main {

	public static void main(String[] args) {
		String path = args[0];
		String filterName = args[1];
		
		Hashtable<String, AbstractFilter> filterNames = new Hashtable<String, AbstractFilter>();
		
		filterNames.put("grayscale", new Grayscale(0.299, 0.587, 0.114));
		filterNames.put("bayer", new Bayer(0.5, 0.25, 0.25));
		
		if (filterNames.containsKey(filterName)) {
			AbstractFilter filter = filterNames.get(filterName);
			filter.filter(path);
		}
		
	}

}

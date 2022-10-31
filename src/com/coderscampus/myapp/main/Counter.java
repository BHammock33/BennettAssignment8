package com.coderscampus.myapp.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Counter {

	public Map<Integer, Integer> count (List<Integer> collectedNumbers){
		
		Map<Integer, Integer> count = collectedNumbers.stream().collect(Collectors.toMap(i->i, i->1,(oldValue, newValue) -> oldValue +1));
		return count;
	}


}

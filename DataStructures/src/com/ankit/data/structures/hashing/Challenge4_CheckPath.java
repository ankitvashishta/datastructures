package com.ankit.data.structures.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a HashMap with the source and destinations provided, find the starting
 * point of a journey and print out the complete path from start to end.
 * 
 * Example : map = {
 * 					 "NewYork" -> "Chicago"
 * 					 "Boston" -> "Texas" 
 * 					 "Missouri" -> "NewYork" 
 * 					 "Texas" -> "Missouri" 
 * 					}
 * 
 * Output : "Boston->Texas, Texas->Missouri, Missouri->NewYork, NewYork->Chicago, "
 * 
 * @author ankit
 *
 */
public class Challenge4_CheckPath {
	
	/*
	 * Time Complexity : O(n) where n is the number of source-destination pairs.
	 * 
	 * Space Complexity : O(n) where the HashSet stores the cities.
	 */
	public static String tracePath(Map<String, String> map) {
		String result = "";
		HashSet<String> cities = new HashSet<>();
		for (String key : map.keySet()) {
			String city = map.get(key);
			if (cities.contains(city))
				cities.remove(city);
			else
				cities.add(city);
			if (cities.contains(key))
				cities.remove(key);
			else
				cities.add(key);
		}
		String source = null;
		for (String city : cities) {
			if (map.containsKey(city)) {
				source = city;
			}
		}
		while (map.containsKey(source)) {
			String destination = map.get(source);
			result += source + "->" + destination + ", ";
			source = destination;
		}
		return result;
	}
	
	public static void main(String[] args) {
		HashMap<String, String> hMap = new HashMap<>();

		hMap.put("NewYork", "Chicago");
		hMap.put("Boston", "Texas");
		hMap.put("Missouri", "NewYork");
		hMap.put("Texas", "Missouri");

		String actual_output = tracePath(hMap);

		System.out.println(actual_output);
	}
}

package com.central.perthnow;

import java.util.ArrayList;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Creates Event objects with test data
 * @author Andrea
 *
 */

public class EventTestUtils {
	
	private static final String[] TIMES = {
		"10:00", "08:30", "21:00", "23:00",};
	
	private static final String[] DATES = {
		"20/04", "21/04", "22/04", "23/04",};
	
	private static final String[] SUBURB = {
		"Perth", "Mount Lawley", "Cottesloe", "Scarborough",};
	
	private static final String[] PRICE = {
		"FREE", "$40", "$300", "FREE",};
	
	private static final String[] EVENT = {
		"Brunch at Perth Now", "Breakkie in Hipster Town", "Rock at the Beach", "International Beach Bum Festival",};
	
	private final Random mRandom;
	
	/**
	 * Constructs a new EventTestUtils object with the specified seed
	 * 
	 * @param seed
	 * 			long to seed the {@link Random} with
	 */
	public EventTestUtils(long seed){
		mRandom = new Random(seed);
	}
	
	//public static int[] id = int[TIMES.length];
	/**
	 * Returns ArrayList of Event objects
	 * 
	 * @param count
	 * 			int number of Event objects to return
	 * @return ArrayList of Event objects
	 */
	public ArrayList<Event> getNewEvents(int count){
		final ArrayList<Event> list = new ArrayList<Event>();
		for(int i = 0; i < count; i++){
			list.add(getNewEvent());
		}
		return list;
	}
	
	/**
	 * Returns new Event filled with test data
	 * 
	 * @return new Event filled with test data
	 */
	public Event getNewEvent(){
		
		final JSONObject json = new JSONObject();
		try{
			int randomValue = mRandom.nextInt(TIMES.length);
			json.put(Event.JSON_KEY_TIMES, TIMES[randomValue]);
			randomValue = mRandom.nextInt(DATES.length);
			json.put(Event.JSON_KEY_DATES, DATES[randomValue]);
			randomValue = mRandom.nextInt(SUBURB.length);
			json.put(Event.JSON_KEY_SUBURB, SUBURB[randomValue]);
			randomValue = mRandom.nextInt(PRICE.length);
			json.put(Event.JSON_KEY_PRICE, PRICE[randomValue]);
			randomValue = mRandom.nextInt(EVENT.length);
			json.put(Event.JSON_KEY_EVENT, EVENT[randomValue]);
			return new Event(json);
		}catch (JSONException e){
			//This should never happen
			throw new RuntimeException(e);
		}
	}
	
	
}



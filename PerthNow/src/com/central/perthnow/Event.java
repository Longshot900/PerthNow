package com.central.perthnow;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Event implements Parcelable{
	
	private static final String TAG = "Event";
	
	public static final String JSON_KEY_TIMES = "time";
	public static final String JSON_KEY_DATES = "date";
	public static final String JSON_KEY_SUBURB = "suburb";
	public static final String JSON_KEY_PRICE = "displayPrice";
	public static final String JSON_KEY_EVENT = "event";
	
	/**
	 * The time of the event
	 */
	private final String mTime;
	
	/**
	 * the date of the event
	 */
	private final String mDate;
	
	/**
	 * the name of the suburb
	 */
	private final String mSuburb;
	
	/**
	 * the displaybable price of the event
	 */
	private final String mPrice;
	
	/**
	 * the event name
	 */
	private final String mEvent;
	
	/**
	 * the raw JSON representation of the object
	 */
	private final String mRawJson;
	
	public Event(JSONObject json) throws JSONException {
		
		mTime = json.getString(JSON_KEY_TIMES);
		mDate = json.getString(JSON_KEY_DATES);
		mSuburb = json.getString(JSON_KEY_SUBURB);
		mPrice = json.getString(JSON_KEY_PRICE);
		mEvent = json.getString(JSON_KEY_EVENT);
		mRawJson = json.toString();
	}
	
	@Override
	public int describeContents(){
		return 0;
	}
	
	/**
	 * Returns the event time
	 */
	public String getTime(){
		return mTime;
	}
	
	/**
	 * Returns the date
	 */
	public String getDate(){
		return mDate;
	}
	
	/**
	 * Returns the name of the suburb
	 */
	public String getSuburb(){
		return mSuburb;
	}
	
	/**
	 * Returns the displayable price of the event
	 */
	public String getPrice(){
		return mPrice;
	}
	
	/**
	 * Returns the name of the event
	 */
	public String getEvent(){
		return mEvent;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeString(mRawJson);
	}
	
	/** 
	 * Parcelable. Creator required to construct an Event object from a Parcel.
	 */
	public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
		@Override
		public Event createFromParcel(Parcel source){
			final String rawJson = source.readString();
			try{
				final JSONObject jsonObject = new JSONObject(rawJson);
				return new Event(jsonObject);
			} catch(JSONException e){
				//In theory, it's impossible to get here
				Log.e(TAG, "Failed to create Event from JSON String: " + e.getMessage());
				return null;
			}
		}
		
		@Override
		public Event[] newArray(int size){
			return new Event[size];
		}
	};
	
	
}

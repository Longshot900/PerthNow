package com.central.perthnow;

import java.util.GregorianCalendar;
import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;

public class SendEvent {
	
	static void sendEvents(Intent calIntent, int id) {
		
		//initialized values to be linked with Database
		int year=0, month=0, day=0, Shour=0, Sminute=0, Ehour=0, Eminute=0;
		
		//decides if event is allday
		@SuppressWarnings("unused")
		boolean allday= true;
		
		if (id==2) {
			//calIntent.setData(CalendarContract.Events.CONTENT_URI);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "homecoming" );
			calIntent.putExtra(Events.EVENT_LOCATION, "Your Place");
			calIntent.putExtra(Events.DESCRIPTION, "come over and see the wacky new world of old");
		}
		//gets event values
		getYear(year);
		getMonth(month);
		getDay(day);
		getStartHour(Shour);
		getStartMinute(Sminute);
		getEndHour(Ehour);
		getEndMinute(Eminute);

		GregorianCalendar startDate = new GregorianCalendar(year, month, day, Shour, Sminute);
		GregorianCalendar endDate = new GregorianCalendar(year, month, day, Ehour, Eminute);
		
		if (allday = true) {
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,startDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,startDate.getTimeInMillis());
		}
		if (allday = false) {
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,startDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endDate.getTimeInMillis());
		}
		
	}
	
	//methods to get event values
	private static int getYear(int year){
		year = 2014;
		return year;
	}
	private static int getMonth(int month){
		month = 4;
		return month;
	}
	private static int getDay(int day){
		day = 14;
		return day;
	}
	private static int getStartHour(int Shour){
		Shour = 7;
		return Shour;
	}
	private static int getStartMinute(int Sminute){
		Sminute = 30;
		return Sminute;
	}
	private static int getEndHour(int Ehour){
		Ehour = 16;
		return Ehour;
	}
	private static int getEndMinute(int Eminute){
		Eminute = 0;
		return Eminute;
	}
}

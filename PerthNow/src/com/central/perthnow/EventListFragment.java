package com.central.perthnow;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
//import android.content.res.Resources;
import android.widget.Toast;

public class EventListFragment extends ListFragment implements
		OnItemClickListener {

	private List<Event> events;
	private static final String ARGUMENT_KEY_EVENTS = "events";

	/**
	 * Static constructor to create a new Instance of a EventListFragment
	 * 
	 * @param events
	 *            ArrayList of Event objects to store in the Fragment
	 * @return EventListFragment with the passed Event objects stored as args
	 */
	public static EventListFragment newInstance(ArrayList<Event> events) {
		final Bundle args = new Bundle();
		args.putParcelableArrayList(ARGUMENT_KEY_EVENTS, events);

		final EventListFragment f = new EventListFragment();
		f.setArguments(args);
		return f;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		events = getArguments().getParcelableArrayList(
				ARGUMENT_KEY_EVENTS);
		setListAdapter(new EventListAdapter(getActivity(), events));

		getListView().setOnItemClickListener(this);
	}
	
	/**
	 * when an event is clicked
	 */
	public void onItemClick(AdapterView<?> container, View view, int position,
			long arg3) {
		//event position that was clicked
		Event eventsss = events.get(position);
		
		
		//button that opens up eventPageFragment
		Button eventDescription = (Button) view.findViewById(R.id.event);
		eventDescription.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(),
						EventPageFragment.class);
				myIntent.putExtra(eventsss, 5);
				startActivityForResult(myIntent, 0);
			}
		});

//		//String of event name to be passed into Toast
//		String eventName = (String) ((TextView) view.findViewById(R.id.event)).getText();
//		//displays text using toast notification
//		Toast.makeText(getActivity(), eventName, Toast.LENGTH_SHORT).show();
	}

	/**
	 * ArrayAdapter that displays Event objects.
	 */
	private static class EventListAdapter extends ArrayAdapter<Event> {

		private final LayoutInflater mInflater;

		// private final String mTime;
		// private final String mDate;

		public EventListAdapter(Context context, List<Event> objects) {
			super(context, -1, objects);
			mInflater = LayoutInflater.from(context);
			// final Resources res = context.getResources();
			// String mTime = " " + res.getString(R.string.time);
			// mDate = " " + res.getString(R.string.date);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final Event event = getItem(position);

			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.event_listitem,
						parent, false);
			}

			// This will be made more efficient in a future development
			TextView tv = (TextView) convertView.findViewById(R.id.suburb);
			tv.setText(event.getSuburb());
			tv = (TextView) convertView.findViewById(R.id.price);
			tv.setText(event.getPrice());
			tv = (TextView) convertView.findViewById(R.id.event);
			tv.setText(event.getEvent());
			tv = (TextView) convertView.findViewById(R.id.date);
			tv.setText(event.getDate());
			tv = (TextView) convertView.findViewById(R.id.time);
			tv.setText(event.getTime());

			return convertView;
		}
	}

}

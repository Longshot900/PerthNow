package com.central.perthnow;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//controls the created event_page_description fragment
public class EventPageFragment extends Activity {

	double[] coOrds = new double[-31.9530044], [115.85746930000005];
	protected void onActivityCreate(Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_page_description);
		
		//when send to calendar button is clicked
		Button Activity1 = (Button) findViewById(R.id.calendarIntent);
		Activity1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				//Temporary id of the event selected
				int id = 2;
				
				Intent calIntent = new Intent(Intent.ACTION_INSERT);
				SendEvent.sendEvents(calIntent, id);
				

				//Verify it resolves
				PackageManager packageManager = getPackageManager();
				List<ResolveInfo> activities = packageManager.queryIntentActivities(calIntent, 0);
				boolean isIntentSafe = activities.size() > 0;

				//Start an activity if it's safe
				if (isIntentSafe) {
					startActivity(calIntent);
				}
			}
			
		});
		
		//when map button is clicked
		Button mapButton = (Button) findViewById(R.id.mapsIntent);
		mapButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				
				Intent mapIntent = new Intent(Intent.ACTION_INSERT);
				SendEvent.sendEvents(mapIntent, 0);
				
				//Verify it resolves
				PackageManager packageManager = getPackageManager();
				List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
				boolean isIntentSafe = activities.size() > 0;

				//Start an activity if it's safe
				if (isIntentSafe) {
					startActivity(mapIntent);
				}
			}
			
		});
	}

	

//		@Override
//		public boolean onCreateOptionsMenu(Menu menu) {
//			// Inflate the menu; this adds items to the action bar if it is present.
//			getMenuInflater().inflate(R.menu.main, menu);
//			return true;
//		}
		


	}
	


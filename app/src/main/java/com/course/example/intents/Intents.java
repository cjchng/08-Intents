/*
 * This is a demo of explicit and implicit intents.
 * The implicit intents call existing Android applications
 * Notice the permission in the Manifest file. We need this because
 * the app is placing a call, not just opening the dialer.
 */


package com.course.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.content.ComponentName;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Intents extends Activity implements OnClickListener {
    /** Called when the activity is first created. */ 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Dialog);
        setContentView(R.layout.main);
        
     // Set up click listeners for all the buttons
        Button continueButton = (Button)findViewById(R.id.first_button);
        continueButton.setOnClickListener(this);
        
        Button newButton = (Button)findViewById(R.id.second_button);
        newButton.setOnClickListener(this);
        
        Button aboutButton = (Button)findViewById(R.id.third_button);
        aboutButton.setOnClickListener(this);
        
        Button newAppButton = (Button)findViewById(R.id.fourth_button);
        newAppButton.setOnClickListener(this);
        
        Button exitButton = (Button)findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        
    }
    
    public void onClick(View v) {
        switch (v.getId()) { 
        
        //explicit intent
        case R.id.first_button:       	
        	Intent i1 = new Intent(this, LifeCycleTest.class);
            startActivity(i1);
           break;
      
         //implicit intent, call GoogleMaps 
        case R.id.second_button:
        	Uri uri2 = Uri.parse("geo:42.3889167,-71.2208033?z=18");
        	//Uri uri2 = Uri.parse("geo:0,0?q=175+forest+street+waltham+ma");
        	Intent i2 = new Intent(Intent.ACTION_VIEW,uri2);
          
           /*For API18 and 19 Google Maps is not on Launch Pad
             so should first check if Package is present to avoid app crashing.
            */
            if (i2.resolveActivity(getPackageManager()) != null) {
    	        startActivity(i2);
    	    }
            
            
           break;
       
        //implicit intent, call dialer
        case R.id.third_button:
        	Uri uri3 = Uri.parse("tel:6175551212");
        	Intent i3 = new Intent(Intent.ACTION_CALL,uri3);
            startActivity(i3);
           break;
           
         //explicit intent for an Activity in another application
         //format is ComponentName(package, class)
         //be sure other app has been run at least once so that its package
         //is in the file system.
        case R.id.fourth_button:
        	Intent i4 = new Intent();
        	i4.setComponent(new ComponentName("com.course.example.widgets",
        			"com.course.example.widgets.Widgets"));  
            startActivity(i4);
           break;
           
        case R.id.exit_button:
           finish();
           break;
        }
     }
     
    
}
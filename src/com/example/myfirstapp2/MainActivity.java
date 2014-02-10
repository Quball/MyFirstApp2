package com.example.myfirstapp2;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp2.MESSAGE";
	private Button b;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
        
        b = (Button) findViewById(R.id.notify_btn);
        b.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /* Send notification */
    
    public void onClick(View v) {
    	Intent intent = new Intent();
    	PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		NotificationManager notificationManager =(NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    	
    	NotificationCompat.Builder notificationBuild = new NotificationCompat.Builder(this)
    		.setTicker("New notification!")
    		.setContentTitle("New speakR notification")
    		.setContentText("You recieved a message from speakR")
    		.setSmallIcon(R.drawable.new_ic_launcher)
    		.setContentIntent(pIntent);
    	
    	/*Create notification with builder*/
		Notification notification = notificationBuild.build();
		notificationManager.notify(0, notification);
    }
    
    /* Send message to DisplayMessageActivity.class */
    
    public void sendMessage(View view){
    	
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	
    	String message = editText.getText().toString();
    	
    	intent.putExtra(EXTRA_MESSAGE, message);
    	
    	startActivity(intent);
    }
    
    /* Set background color and vibrate */
    
    public void setColor(View view){
    	
    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    	v.vibrate(500);
    	
    	Spinner spinner = (Spinner)findViewById(R.id.spinner);
    	String color = spinner.getSelectedItem().toString();
    	LinearLayout main = (LinearLayout)findViewById(R.id.main_view);
    	
    	System.out.println(color);
    	
    	if (color.equals("Red")) {
    		main.setBackgroundColor(Color.parseColor("#FF0000"));
    	} else if (color.equals("Green")) {
    		main.setBackgroundColor(Color.parseColor("#00FF00"));
    	} else if (color.equals("Blue")) {
    		main.setBackgroundColor(Color.parseColor("#0000FF"));
    	} else if (color.equals("Default")) {
    		main.setBackgroundColor(Color.parseColor("#FFFFFF"));
    	}
    }
    
    /* Start activity that handles fragments */
    
    public void startFragment1(View view){
    	
    	Intent fragmentActivity = new Intent(this, FragmentActivity.class);
    	startActivity(fragmentActivity);
    }
    
    /* Start camera activity */
    
    public void startCamera(View view) {
    	
    	Intent cameraIntent = new Intent(this, CameraActivity.class);
    	startActivity(cameraIntent);
    }
}

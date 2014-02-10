package com.example.myfirstapp2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends Activity {
	
	ImageView imgFavorite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		imgFavorite = (ImageView)findViewById(R.id.imageView1);
		imgFavorite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				open();
			}
		});
	}

	public void open() {
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == 0) {
	        if (resultCode == RESULT_OK) {
	            
	        	// everything should be OK and you can process the expected result
	        	super.onActivityResult(requestCode, resultCode, data);
	    		Bitmap bp = (Bitmap) data.getExtras().get("data");
	    		imgFavorite.setImageBitmap(bp);
	    		
	        } else if (resultCode == RESULT_CANCELED) {
	        	Toast.makeText(getApplicationContext(), 
	                    "You canceled the camera instance", Toast.LENGTH_LONG).show();
	        } else {
	            // not sure what happened here - but result isn't 'RESULT_OK' so 
	            // you shouldn't expect to process the expected result.
	        }
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}

}

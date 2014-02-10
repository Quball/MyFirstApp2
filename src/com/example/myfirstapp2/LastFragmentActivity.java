package com.example.myfirstapp2;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.view.Menu;

public class LastFragmentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Configuration config = getResources().getConfiguration();
        
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = 
        fragmentManager.beginTransaction();
        
    	if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LM_LastFragment ls_fragment = new LM_LastFragment();
            fragmentTransaction.replace(android.R.id.content, ls_fragment);
            fragmentTransaction.commit();
         }else{
            PM_LastFragment pm_fragment = new PM_LastFragment();
            fragmentTransaction.replace(android.R.id.content, pm_fragment);
            fragmentTransaction.commit();
         }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity1, menu);
		return true;
	}

}

package com.example.myfirstapp2;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PM_LastFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		
		/* Inflate the layout for this fragment */
		return inflater.inflate(R.layout.pm_last_fragment, container, false);
	}

}

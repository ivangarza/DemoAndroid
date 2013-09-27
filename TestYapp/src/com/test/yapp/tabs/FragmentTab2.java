package com.test.yapp.tabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.test.testyapp.ItemAdapter;
import com.test.testyapp.Model;
import com.test.testyapp.R;

public class FragmentTab2 extends SherlockFragment {

	 ListView listView;
	 Context fragContext;
	 
	 /*public FragmentTab2(Context context){
		 fragContext = context;
	 }*/
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragmenttab2, container, false);
		
		
		 	Model.LoadModel();
	        listView = (ListView)  view.findViewById(R.id.listCanales);
	        String[] ids = new String[Model.Items.size()];
	        for (int i= 0; i < ids.length; i++){

	            ids[i] = Integer.toString(i+1);
	        }

	        ItemAdapter adapter = new ItemAdapter(getActivity(),R.layout.row, ids);
	        listView.setAdapter(adapter);
		
		
		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
		
		
	}

}

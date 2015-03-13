package com.example.sidemenututorial;









import java.util.ArrayList;





import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment2 extends Fragment {
	LinearLayout layout ;
	ListView List;
	TestAdapter dbcnx;
	int[] icon;
	String[] txt1;
	String [] txt2;
	ArrayAdapter<liste> arrayAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.f2, container, false);
		
		Loadhotel(rootView);
		
		return rootView;
		
	
	
	
	}
	 public void Loadhotel(View v)
	    { try {
		 TestAdapter mDbHelper = new TestAdapter(getActivity());         
	    	mDbHelper.createDatabase();       
	    	mDbHelper.open(); 
	    	
	   
	    	Cursor testdata = mDbHelper.getTestData(); 
	List<liste> arraylist= mDbHelper.getAll();
	
	List = (ListView)v.findViewById(R.id.listhotel);
	
	 arrayAdapter =      
			      new ArrayAdapter<liste>(getActivity(),android.R.layout.simple_list_item_1, arraylist);
	
	
	     List.setAdapter(arrayAdapter);
	     List.setOnItemClickListener(new OnItemClickListener(){

				
	    	 
	    	 @Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					     long arg3) {
	    		 Intent intent = new Intent(getActivity(),hotel.class);
	             
	             startActivity(intent);
	    		 
				
				}

				
					});
	     
	     
	     
	    	Toast.makeText(getActivity(),"reussite!!!",Toast.LENGTH_SHORT).show();
	    }
	   catch (Exception  e)  
        { 
            Toast.makeText(getActivity(),"fail!!!",Toast.LENGTH_SHORT).show();
            
       
	    	
	    	

		
	
			
		
	    	
	    	
		 
		
	    }}}

	
	
	

	
	
	
	
	
	
	


package com.example.sidemenututorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class hotel extends ArrayAdapter<liste> {
	



	String[] txt1;
	
	String[] txt2;
	int [] img;
	Context context;
	
	LayoutInflater inflater;
	
	public hotel(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
TextView txtTitle;
TextView txtTitle1;
		ImageView imgIcon;
 
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.hotel_raw, parent,
				false);
 
		// Locate the TextViews in drawer_list_item.xml
		txtTitle = (TextView) itemView.findViewById(R.id.title);
	
 
		// Locate the ImageView in drawer_list_item.xml
		imgIcon = (ImageView) itemView.findViewById(R.id.icon);
 
		// Set the results into TextViews
		txtTitle.setText(txt1[position]);
		
		txtTitle.setText(txt2[position]);
		// Set the results into ImageView
		imgIcon.setImageResource(img[position]);
 
		return itemView;
		
		
		
		
		
	}


	
	
	
}

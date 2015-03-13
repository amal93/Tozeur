package com.example.sidemenututorial;


import android.content.res.Configuration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	// Declare Variables
		DrawerLayout mDrawerLayout;
		ListView mDrawerList;
		
		ActionBarDrawerToggle mDrawerToggle;
		MenuListAdapter mMenuAdapter;
		String[] title;
		String[] subtitle;
		int[] icon;
		Fragment fragment1 = new Fragment1();
		Fragment fragment2 = new Fragment2();
		Fragment fragment3 = new Fragment3();
		Fragment fragment4 = new Fragment3();
		private CharSequence mDrawerTitle;
		private CharSequence mTitle;
		
		NavigationDrawerFragment mNavigationDrawerFragment;
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */


	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	
		
		// Get the view from drawer_main.xml
				setContentView(R.layout.drawer_main);
		 
				// Get the Title
				mTitle = setmDrawerTitle(getTitle());
		 
				// Generate title
				title = new String[] { "Accueil","Hôtels et Residences", "Restaurants",
						"Les points d'interêt" };
		 
				// Generate subtitle
				
		 
				// Generate icon
				icon = new int[] {R.drawable.home, R.drawable.h, R.drawable.rest,
						R.drawable.pt };
		 
				// Locate DrawerLayout in drawer_main.xml
				mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		 
				// Locate ListView in drawer_main.xml
				mDrawerList = (ListView) findViewById(R.id.listview_drawer);
		 
				// Set a custom shadow that overlays the main content when the drawer
				// opens
				mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,GravityCompat.START);
		 
				// Pass string arrays to MenuListAdapter
				mMenuAdapter = new MenuListAdapter(MainActivity.this, title,
						icon);
		 
				// Set the MenuListAdapter to the ListView
				mDrawerList.setAdapter(mMenuAdapter);
				mDrawerList.setSelector(android.R.color.holo_blue_bright);
				// Capture listview menu item click
				mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		 
				// Enable ActionBar app icon to behave as action to toggle nav drawer
				getSupportActionBar().setHomeButtonEnabled(true);
				getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		 
				// ActionBarDrawerToggle ties together the the proper interactions
				// between the sliding drawer and the action bar app icon
				
		 
				mDrawerLayout.setDrawerListener(mDrawerToggle);
		 
				if (savedInstanceState == null) {
					selectItem(0);
				}
			}
		 



//ListView click listener in the navigation drawer
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		// Locate Position
		switch (position) {
		case 0:
			ft.replace(R.id.content_frame, fragment1);
			break;
		case 1:
			ft.replace(R.id.content_frame, fragment2);
			break;
		case 2:
			ft.replace(R.id.content_frame, fragment3);
			break;
		case 3:
			ft.replace(R.id.content_frame, fragment4);
			break;
		}
		ft.commit();
		mDrawerList.setItemChecked(position, true);

		// Get the title followed by the position
		setTitle(title[position]);
		// Close drawer
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	
	
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}


	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// TODO Auto-generated method stub
		
	}


	public CharSequence getmDrawerTitle() {
		return mDrawerTitle;
	}


	public CharSequence setmDrawerTitle(CharSequence mDrawerTitle) {
		this.mDrawerTitle = mDrawerTitle;
		return mDrawerTitle;
	}
	
	   @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == android.R.id.home) {
	        	
	        	if(mDrawerLayout.isDrawerOpen(mDrawerList)){
	        		mDrawerLayout.closeDrawer(mDrawerList);
	        		return true;	        		
	        	}else{
	        		mDrawerLayout.openDrawer(mDrawerList);
	        		return true;
	        	}
	        }
	        return super.onOptionsItemSelected(item);
	    }

	    

}

	
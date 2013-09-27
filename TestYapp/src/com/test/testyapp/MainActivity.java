package com.test.testyapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;
import com.slidingmenu.lib.SlidingMenu;
import com.test.yapp.SplashActivity;
import com.test.yapp.tabs.ViewPagerAdapter;

public class MainActivity extends SherlockFragmentActivity implements Menufragment.MenuClickInterFace{
	SlidingMenu menu;
    TextView text;
    ViewPager mPager;
	Tab tab;
	ActionBar ab;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ab = getSupportActionBar();
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(false);
		
		/*ab.setBackgroundDrawable(getApplicationContext().getResources()
			    .getDrawable(R.drawable.yapp_bar));*/
		  ab.setLogo(getResources().getDrawable(R.drawable.menu_alt));
		  ab.setDisplayShowTitleEnabled(true);
		  
		  //ab.setIcon(R.drawable.yapp_bar);	  
		
		
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
		menu.setMenu(R.layout.menu);
		menu.setSlidingEnabled(true);
		
		mPager = (ViewPager) findViewById(R.id.pager);
		
		// Activate Fragment Manager
		FragmentManager fm = getSupportFragmentManager();

		// Capture ViewPager page swipes
		ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				// Find the ViewPager Position
				ab.setSelectedNavigationItem(position);
			}
		};

		mPager.setOnPageChangeListener(ViewPagerListener);
		// Locate the adapter class called ViewPagerAdapter.java
		ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(fm);
		// Set the View Pager Adapter into ViewPager
		mPager.setAdapter(viewpageradapter);
		
		// Capture tab button clicks
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				mPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}
		};

		tab = ab.newTab().setText("Populares").setTabListener(tabListener);
		ab.addTab(tab);
		
		tab = ab.newTab().setText("Mis Canales").setTabListener(tabListener);
		ab.addTab(tab);
		
		tab = ab.newTab().setText("Recomenda").setTabListener(tabListener);
		ab.addTab(tab);
		
		
	}

	  @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        //MenuInflater inflater = getSupportMenuInflater();
	        //inflater.inflate(R.menu.tax_main, menu);
	        
	        getSupportMenuInflater().inflate(R.menu.activity_main, menu);
	        
	     // Get the SearchView and set the searchable configuration
		    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		    SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		    // Assumes current activity is the searchable activity
		    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		    // searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
	        
	        return true;
	    }
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		menu.toggle();
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onListitemClick(String item) {
		// TODO Auto-generated method stub
		text.setText(item);
	}
}

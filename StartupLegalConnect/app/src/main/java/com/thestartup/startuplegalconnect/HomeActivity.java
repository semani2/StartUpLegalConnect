package com.thestartup.startuplegalconnect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thestartup.startuplegalconnect.adapters.DrawerItemCustomAdapter;
import com.thestartup.startuplegalconnect.fragments.DemoFragment;
import com.thestartup.startuplegalconnect.models.NavigationDrawerDataModel;

public class HomeActivity extends AppCompatActivity {

    public static final String HOME_ACTVITY = "HomeActvity";
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private static int NUM_DRAWER_ITEMS = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        NavigationDrawerDataModel[] drawerItems = getNavDrawerItems();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItems);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
    }

    private void setupDrawerToggle() {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }

    private NavigationDrawerDataModel[] getNavDrawerItems() {
        NavigationDrawerDataModel[] dataModels = new NavigationDrawerDataModel[NUM_DRAWER_ITEMS];
        String[] itemNames = getResources().getStringArray(R.array.navigation_drawer_items_array);
        // Who we are
        dataModels[0] = new NavigationDrawerDataModel(R.mipmap.ic_people_black_24dp, itemNames[0]);
        //Where we fit in
        dataModels[1] = new NavigationDrawerDataModel(R.mipmap.ic_extension_black_24dp, itemNames[1]);
        //Common legal mistakes
        dataModels[2] = new NavigationDrawerDataModel(R.mipmap.ic_report_problem_black_24dp, itemNames[2]);
        //Steps for start ups
        dataModels[3] = new NavigationDrawerDataModel(R.mipmap.ic_list_black_24dp, itemNames[3]);
        //Cyber law essentials
        dataModels[4] = new NavigationDrawerDataModel(R.mipmap.ic_gavel_black_24dp, itemNames[4]);
        //Ask us
        dataModels[5] = new NavigationDrawerDataModel(R.mipmap.ic_feedback_black_24dp, itemNames[5]);

        return dataModels;
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(mTitle);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new AboutUs();
                break;
            case 1:
                //fragment = new FixturesFragment();
                break;
            case 2:
                //fragment = new TableFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e(HOME_ACTVITY, "Error in creating fragment");
        }
    }
}

package com.thestartup.startuplegalconnect;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.thestartup.startuplegalconnect.fragments.AboutUsFragment;
import com.thestartup.startuplegalconnect.fragments.ApplicabilityFragment;
import com.thestartup.startuplegalconnect.fragments.CommonLegalMistakesFragment;
import com.thestartup.startuplegalconnect.services.ServiceLocator;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);


                mDrawerLayout.closeDrawers();
                switch (item.getItemId()) {

                    case R.id.whoWeAre:
                        loadFragment(new AboutUsFragment());
                        setTitle(getResources().getString(R.string.who_are_we));
                        return true;

                    case R.id.whereWeFit:
                        loadFragment(new ApplicabilityFragment());
                        return true;

                    case R.id.commonLegalMistakes:
                        loadFragment(new CommonLegalMistakesFragment());
                        setTitle(getString(R.string.common_legel_mistakes));
                        return true;

                    case R.id.stepsForStartups:
                        return true;

                    case R.id.askUs:
                        return true;

                    default:
                        return true;

                }
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open_drawer, R.string.close_drawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        ServiceLocator.initAllServices(getApplicationContext());
        loadHomeFragment();
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    private void loadHomeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new AboutUsFragment()).commit();
        setTitle(getResources().getString(R.string.who_are_we));
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void setTitle(CharSequence title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}

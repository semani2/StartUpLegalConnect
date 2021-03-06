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
import com.thestartup.startuplegalconnect.fragments.AskUsFragment;
import com.thestartup.startuplegalconnect.fragments.CommonLegalMistakesFragment;
import com.thestartup.startuplegalconnect.fragments.LegalMentorFragment;
import com.thestartup.startuplegalconnect.fragments.StepsFragment;
import com.thestartup.startuplegalconnect.fragments.StartupStepsFragment;
import com.thestartup.startuplegalconnect.services.ServiceLocator;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout mDrawerLayout;

    private static final String spName = "com.thestartup.startuplegalconnect.navigation";
    private static final String key = "NAVIGATION_INDEX";

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
                        ServiceLocator.sharedpreferences().setInt(spName, key, 0);
                        return true;

                    case R.id.whereWeFit:
                        loadFragment(new ApplicabilityFragment());
                        setTitle("Where we fit in?");
                        ServiceLocator.sharedpreferences().setInt(spName, key, 1);
                        return true;

                    case R.id.commonLegalMistakes:
                        loadFragment(new CommonLegalMistakesFragment());
                        setTitle(getString(R.string.common_legel_mistakes));
                        ServiceLocator.sharedpreferences().setInt(spName, key, 2);
                        return true;

                    case R.id.stepsForStartups:
                        loadFragment(new StepsFragment());
                        setTitle("Steps for start-ups");
                        ServiceLocator.sharedpreferences().setInt(spName, key, 3);
                        return true;

                    case R.id.legalMentor:
                        loadFragment(new LegalMentorFragment());
                        setTitle(getString(R.string.legal_mentor));
                        ServiceLocator.sharedpreferences().setInt(spName, key, 4);
                        return true;

                    case R.id.askUs:
                        loadFragment(new AskUsFragment());
                        setTitle(getString(R.string.ask_us));
                        ServiceLocator.sharedpreferences().setInt(spName, key, 5);
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
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    private void loadLastSelectedFragment() {
        switch(ServiceLocator.sharedpreferences().getInt(spName, key, 0)) {
            case 0:
                loadFragment(new AboutUsFragment());
                setTitle(getResources().getString(R.string.who_are_we));
                navigationView.setCheckedItem(R.id.whoWeAre);
                break;

            case 1:
                loadFragment(new ApplicabilityFragment());
                setTitle(getResources().getString(R.string.where_we_fit));
                navigationView.setCheckedItem(R.id.whereWeFit);
                break;

            case 2:
                loadFragment(new CommonLegalMistakesFragment());
                setTitle(getResources().getString(R.string.common_legel_mistakes));
                navigationView.setCheckedItem(R.id.commonLegalMistakes);
                break;

            case 3:
                loadFragment(new StepsFragment());
                setTitle(getResources().getString(R.string.steps_for_startups));
                navigationView.setCheckedItem(R.id.stepsForStartups);
                break;

            case 4:
                loadFragment(new LegalMentorFragment());
                setTitle(getResources().getString(R.string.legal_mentor));
                navigationView.setCheckedItem(R.id.legalMentor);
                break;

            case 5:
                loadFragment(new AskUsFragment());
                setTitle(getResources().getString(R.string.ask_us));
                navigationView.setCheckedItem(R.id.askUs);
                break;

        }

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

    @Override
    protected void onResume() {
        super.onResume();
        loadLastSelectedFragment();
    }
}

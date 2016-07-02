package com.example.user8.padc_linkedin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.user8.padc_linkedin.R;
import com.example.user8.padc_linkedin.fragments.FlimFragment;
import com.example.user8.padc_linkedin.fragments.LinkInFragment;
import com.example.user8.padc_linkedin.fragments.PluseFragment;
import com.example.user8.padc_linkedin.fragments.SearchFragment;
import com.example.user8.padc_linkedin.fragments.WinzinFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout flcontainer;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FrameLayout flContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        Menu leftMenu = navigationView.getMenu();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (menuItem.getItemId()) {
                            case R.id.drawer_home:
                                navigateToHome();
                                break;
                            case R.id.drawer_search:
                                navigateToSearch();
                                break;
                            case R.id.drawer_pulse:
                                navigateToPulse();
                                break;
                            case R.id.drawer_flim:
                                navigateToFlim();
                                break;
                            case R.id.drawer_winzin:
                                navigateToWinzin();
                                break;
                        }
                    }
                }, 100); //to close drawer smoothly.

                return true;
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        flcontainer = (FrameLayout) findViewById(R.id.fl_container);
        if (savedInstanceState == null) {
            LinkInFragment fragment = new LinkInFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
//            case R.id.action_love:
//                Toast.makeText(getApplicationContext(), getString(R.string.lbl_love_the_joke), Toast.LENGTH_SHORT).show();
//                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void navigateToSearch() {
        SearchFragment fragmentSearch = new SearchFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragmentSearch)
                .commit();
    }

    private void navigateToPulse() {
        PluseFragment pluseFragment = new PluseFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, pluseFragment)
                .commit();
    }

    private void navigateToWinzin() {
         WinzinFragment winzinFragment = new WinzinFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, winzinFragment)
                .commit();
    }
    private void navigateToFlim() {
        FlimFragment flimFragment = new FlimFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, flimFragment)
                .commit();
    }

    private void navigateToHome() {
        LinkInFragment linkInFragment = new LinkInFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, linkInFragment)
                .commit();
    }
}

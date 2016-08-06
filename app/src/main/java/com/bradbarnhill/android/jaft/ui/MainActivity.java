package com.bradbarnhill.android.jaft.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bradbarnhill.android.jaft.R;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavView;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavView = (NavigationView) findViewById(R.id.drawer_nav);

        if (mDrawerLayout != null) {
            mDrawerLayout.setFadingEdgeLength(4);
        }

        populateDrawer();

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(final View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(final View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.setDrawerIndicatorEnabled(true);

        animateFloatingActionButton();
    }

    @Override
    protected void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    protected void onDestroy() {
        mDrawerLayout.removeDrawerListener(mDrawerToggle);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        final int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(final CharSequence title) {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private void animateFloatingActionButton() {
        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fabStartStop);
        final Animation anim = AnimationUtils.loadAnimation(floatingActionButton.getContext(), R.anim.fab_in);
        anim.setDuration(400L);
        anim.setInterpolator(new FastOutSlowInInterpolator());
        floatingActionButton.startAnimation(anim);
    }

    private void populateDrawer() {
        final Menu menu = mNavView.getMenu();
        final SubMenu subMenu = menu.addSubMenu(getString(R.string.drawer_stories_subheader_title));
        for (int i = 1; i <= 22; i++) {
            subMenu.add("SubMenu Item " + i);
        }
    }

    private void selectItem(final int position) {
        mDrawerLayout.closeDrawer(GravityCompat.START, false);
        //TODO selected new timer from drawer
    }

    public void onStartStopButtonClick(final View view) {
        //TODO start and stop timer when button is clicked
    }

    public void onSettingsButtonClick(final MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START, false);
        startActivity(new Intent(this, SettingsActivity.class));
    }
}

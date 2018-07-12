package com.ideeastudios.activity.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To apply the toolbar as the app bar, first make sure your activity extends from AppCompatActivity.
        // Then call setSupportActionBar() and pass the Toolbar object from your layout.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Enable the app bar's "home" button by calling setDisplayHomeAsUpEnabled(true), and then change it to use the menu icon by calling setHomeAsUpIndicator(int)
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        /*
        When an item is tapped, this code sets the selected item as checked, changing the list item's style to be highlighted
        because the list items are part of a checkable group (as shown above in the menu file).
        It also closes the drawer by calling closeDrawers().
        */
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (menuItem.getItemId()) {
                            case R.id.drawer_menu_page2:
                                MainActivity.this.startActivity(new Intent(MainActivity.this, Page2Activity.class));
                                overridePendingTransition(R.anim.enter, R.anim.exit);
                                return true;
                            case R.id.drawer_menu_page3:
                                MainActivity.this.startActivity(new Intent(MainActivity.this, Page3Activity.class));
                                overridePendingTransition(R.anim.enter, R.anim.exit);
                                return true;
                            case R.id.drawer_menu_page4:
                                MainActivity.this.startActivity(new Intent(MainActivity.this, Page4Activity.class));
                                overridePendingTransition(R.anim.enter, R.anim.exit);
                                return true;
                        }
                        return true;
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //we manually check the first item when this activity comes to front.
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    /*
    To open the drawer when the user taps on the nav drawer button, override onOptionsItemSelected()
    to hook into the options menu framework and listen for when the user taps the item with the ID android.R.id.home.
    Then call openDrawer() to open the nav drawer
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            //https://developer.android.com/training/implementing-navigation/ancestral
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //if the drawer is open, close it.
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}

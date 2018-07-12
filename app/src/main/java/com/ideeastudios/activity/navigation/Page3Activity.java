package com.ideeastudios.activity.navigation;


import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Page3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        //To apply the toolbar as the app bar, first make sure your activity extends from AppCompatActivity.
        // Then call setSupportActionBar() and pass the Toolbar object from your layout.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //To allow Up navigation with the app icon in the action bar, call setDisplayHomeAsUpEnabled():
        //This adds a left-facing caret alongside the app icon and enables it as an action button such that
        // when the user presses it, your activity receives a call to onOptionsItemSelected()
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                //add some nice animation on exit
                overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //add some nice animation on exit
        overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
    }

}

package com.example.a2davaa02.android5uis;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab1);
        fab.setOnClickListener (new View.OnClickListener() {

            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setPositiveButton("OK", null).
                        setMessage("The FloatingActionButton was clicked!").show();
            }
        });*/

       dLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        NavigationView view = (NavigationView)findViewById(R.id.navigationView);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem item) {
                Class clss = Frag1.class;
                switch(item.getItemId()) {
                    case R.id.save:
                        clss = Frag1.class;
                        break;
                    case R.id.settings:
                        clss = Frag2.class;
                        break;
                    case R.id.action_search:
                        clss = Frag3.class;
                        break;
                }
                if(clss!=null) {
                    dLayout.closeDrawers(); // Close the navigation drawer
                    try {
                        // Using the selected class, create an instance of the chosen 		// fragment
                        Fragment frag = (Fragment) clss.newInstance();
                        FragmentManager fmgr = getFragmentManager();
                        fmgr.beginTransaction().replace(R.id.frameLayout, frag).commit();
                    } catch (Exception e) {
                        new AlertDialog.Builder(MainActivity.this).setPositiveButton("OK",null).setMessage(e.toString()).show();
                    }
                }
                return false;

            }
        }
    );
        dLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        FragmentManager fm = getFragmentManager();
        try {
            fm.beginTransaction().replace(R.id.frameLayout, new Frag1()).commit();
        } catch(Exception e) {
            new AlertDialog.Builder(this).setPositiveButton("OK", null).
                    setMessage("Internal error trying to load fragment: " + e.getMessage()).show();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = (SearchView) MenuItemCompat.getActionView(item);
        sv.setOnQueryTextListener(new SearchHandler());
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.save)
        {
            new AlertDialog.Builder(MainActivity.this).setPositiveButton("OK", null).
                    setMessage("Saving..").show();
            return true;
        }
        return false;
    }
    class SearchHandler implements SearchView.OnQueryTextListener {


        public SearchHandler(){

        }

        public boolean onQueryTextChange(String txt) {
            // do nothing... (this method runs when the user types a new character)
            return true;
        }

        public boolean onQueryTextSubmit(String txt) {
            // show the search text in an alert dialog
            new AlertDialog.Builder(MainActivity.this).setPositiveButton("OK", null).
                    setMessage(txt).show();
            return true;
        }
    }

}

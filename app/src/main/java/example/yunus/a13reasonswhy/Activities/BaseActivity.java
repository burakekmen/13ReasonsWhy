package example.yunus.a13reasonswhy.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import example.yunus.a13reasonswhy.AppIntro.MyIntro;
import example.yunus.a13reasonswhy.Fragments.CharactersFragment;
import example.yunus.a13reasonswhy.Fragments.TapesFragment;
import example.yunus.a13reasonswhy.Fragments.MusicFragment;
import example.yunus.a13reasonswhy.R;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    public boolean isFirstStart;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("13 Reasons Why");
        setContentView(R.layout.activity_base);
        showSlide();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //ilk çağırım
        fragment = new TapesFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_container,fragment).commit();




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rate)
        {
            startActivity(new Intent(BaseActivity.this,InformationActivity.class));
        }

        else if (id == R.id.nav_info)
        {
            startActivity(new Intent(BaseActivity.this,InformationActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_character:
                    fragment = new CharactersFragment();
                    break;
                case R.id.navigation_tape:
                    fragment = new TapesFragment();
                    break;
                case R.id.navigation_music:
                    fragment = new MusicFragment();
                    break;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, fragment).commit();
            return true;
        }

    };

    public void showSlide()
    {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                //  Create a new boolean and preference and set it to true
                isFirstStart = getPrefs.getBoolean("firstStart", true);
                //  If the activity has never started before...
                if (isFirstStart) {
                    //  Launch app intro
                    startActivity(new Intent(BaseActivity.this, MyIntro.class));
                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();
                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);
                    //  Apply changes
                    e.apply();
                }
            }
        });
        // Start the thread
        t.start();
        Log.v("MyIntro","ilk baslama:"+String.valueOf(isFirstStart));
    }
}

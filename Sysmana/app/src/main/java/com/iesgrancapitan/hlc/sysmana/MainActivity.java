package com.iesgrancapitan.hlc.sysmana;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.iesgrancapitan.hlc.sysmana.mFragments.JuevesFragment;
import com.iesgrancapitan.hlc.sysmana.mFragments.LunesFragment;
import com.iesgrancapitan.hlc.sysmana.mFragments.MartesFragment;
import com.iesgrancapitan.hlc.sysmana.mFragments.MiercolesFragment;
import com.iesgrancapitan.hlc.sysmana.mFragments.MyPagerAdapter;
import com.iesgrancapitan.hlc.sysmana.mFragments.ViernesFragment;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    ViewPager vp;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //VIEWPAGER
        vp= (ViewPager) findViewById(R.id.mViewpager_ID);
        this.addPages();

        //TABLAYOUT
        tabLayout= (TabLayout) findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(this);

    }

    private void addPages()
    {
        MyPagerAdapter pagerAdapter=new MyPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new LunesFragment());
        pagerAdapter.addFragment(new MartesFragment());
        pagerAdapter.addFragment(new MiercolesFragment());
        pagerAdapter.addFragment(new JuevesFragment());
        pagerAdapter.addFragment(new ViernesFragment());

        //SET ADAPTER TO VP
        vp.setAdapter(pagerAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

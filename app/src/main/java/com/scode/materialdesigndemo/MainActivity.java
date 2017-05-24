package com.scode.materialdesigndemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.scode.materialdesigndemo.adapter.MyFragment;
import com.scode.materialdesigndemo.adapter.MyViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments;
    private String[] titles ;
    private TabLayout mtab;
    private ViewPager mvp;
    private MyViewPageAdapter mvpadapter;
    private Toolbar mtoolbar;
    private DrawerLayout drawerlayout;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mtoolbar);
        initDate();
        initView();//实例化组件

    }

    private void initDate() {
        titles = getResources().getStringArray(R.array.mytitle);
        fragments = new ArrayList<>();
        for (int i=0;i<titles.length;i++) {
            Fragment fragment=new MyFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("flag", i);
            fragment.setArguments(bundle);
            fragments.add(i,fragment);
        }

    }

    private void initView() {
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle drawertoggle = new ActionBarDrawerToggle(this,drawerlayout,mtoolbar,R.string.open,R.string.close);
        drawertoggle.syncState();
        drawerlayout.addDrawerListener(drawertoggle);
        mtab = (TabLayout) findViewById(R.id.main_tablayout);
        mvp = (ViewPager) findViewById(R.id.main_viewpage);
        mvpadapter = new MyViewPageAdapter(getSupportFragmentManager(), fragments, titles);
        mvp.setAdapter(mvpadapter);
        mtab.setupWithViewPager(mvp);
    }
}

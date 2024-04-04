package com.fer.aula08_fragmentsesensores;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private FragmentController adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        setupViewPager();
    }

    protected void setupViewPager(){
        adapter = new FragmentController(getSupportFragmentManager(), getLifecycle());

        adapter.addFragment(new Fragment01(), "fragment1");
        adapter.addFragment(new Fragment02(), "fragment2");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int position){
        viewPager.setCurrentItem(position);
    }

}
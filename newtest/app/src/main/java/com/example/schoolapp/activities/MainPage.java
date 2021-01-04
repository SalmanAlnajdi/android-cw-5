package com.example.schoolapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.schoolapp.R;
import com.example.schoolapp.adapter.FragmentAdp;
import com.google.android.material.tabs.TabLayout;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondarySwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.nio.file.attribute.AclEntry;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ViewPager vp = findViewById(R.id.vp);
        TabLayout tab = findViewById(R.id.tab);
        Toolbar toolbar = findViewById(R.id.toolbar);

       PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
       PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("History").withIcon(R.drawable.ic_baseline_history_edu_24);
       SecondarySwitchDrawerItem item3 = new SecondarySwitchDrawerItem().withIdentifier(3).withName("Dark Mode").withSwitchEnabled(false);

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),
                         item3

                )
                .build();

        tab.setupWithViewPager(vp);


        FragmentAdp adapter = new FragmentAdp(getSupportFragmentManager());
        vp.setAdapter(adapter);

        tab.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tab.getTabAt(1).setIcon(R.drawable.ic_baseline_class_24);
        tab.getTabAt(2).setIcon(R.drawable.ic_baseline_fiber_new_24);

    }


}
package com.example.menu.Activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.menu.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        prepareViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void prepareViewPager(ViewPager viewPager) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        ShowWebSite showWebSite = new ShowWebSite();
        MenuCodeHandler menuCodeHandler = new MenuCodeHandler();
        MenuWebHandler menuWebHandler = new MenuWebHandler();
        adapter.add();
        adapter.addFragment(showWebSite, menuCodeHandler, menuWebHandler);
        viewPager.setAdapter(adapter);

    }

    private class MainAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();

        public void add() {
            titleList.add("Sito WEB");
            titleList.add("Gestione Codici Menu");
            titleList.add("Gestione Web Menu");
        }

        public void addFragment(Fragment fragment, Fragment fragment2, Fragment fragment3) {
            fragmentList.add(fragment);
            fragmentList.add(fragment2);
            fragmentList.add(fragment3);
        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}

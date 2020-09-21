package com.t3h.buoi13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.t3h.buoi13.adapter.PageNewsAdapter;
import com.t3h.buoi13.fragments.FavoriteFragment;
import com.t3h.buoi13.fragments.NewsFragment;
import com.t3h.buoi13.fragments.SavedFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PageNewsAdapter adapter;

    private NewsFragment fmNews = new NewsFragment();
    private SavedFragment fmSaved = new SavedFragment();
    private FavoriteFragment fmFavorite = new FavoriteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.vp_news);
        adapter = new PageNewsAdapter(
                getSupportFragmentManager(),
                fmNews, fmSaved, fmFavorite
        );
        viewPager.setAdapter(adapter);

        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(viewPager);
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public NewsFragment getFmNews() {
        return fmNews;
    }

    public SavedFragment getFmSaved() {
        return fmSaved;
    }

    public FavoriteFragment getFmFavorite() {
        return fmFavorite;
    }
}
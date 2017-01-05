package com.example.basse.flickers.Adapters;

/**
 * Created by basse on 1/26/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.basse.flickers.Fragments.AboutUsFragment;
import com.example.basse.flickers.Fragments.CommitteesFragment;
import com.example.basse.flickers.Fragments.GalleryFragment;
import com.example.basse.flickers.Fragments.HistoryFragment;
import com.example.basse.flickers.Fragments.SponsorsFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // AboutUs fragment activity
                return new AboutUsFragment();
            case 1:
                // Departments fragment activity
                return new CommitteesFragment();
            case 2:
                // History fragment activity
                return new HistoryFragment();
            case 3:
                // Gallery fragment activity
                return new GalleryFragment();
            case 4:
                // Sponsors fragment activity
                return new SponsorsFragment();
        }

        return null;

    }

    @Override
    public int getCount() {
        // Show 5 total pages.
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "What's Flickers";
            case 1:
                return "Committees";
            case 2:
                return "History";
            case 3:
                return "Gallery";
            case 4:
                return "Sponsors";
        }
        return null;
    }
}


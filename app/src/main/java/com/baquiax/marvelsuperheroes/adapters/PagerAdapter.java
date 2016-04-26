package com.baquiax.marvelsuperheroes.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.baquiax.marvelsuperheroes.fragments.SearchFragment;

/**
 * Created by baquiax on 26/4/2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Marvel";
            case 1: return "Maps";
            default: return "";
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new SearchFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }
}

package com.example.saathi.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.saathi.Fragments.ConnectFragment;
import com.example.saathi.Fragments.ProcedureFragment;
import com.example.saathi.Fragments.SchemesFragment;
import com.example.saathi.Fragments.VideoFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {


    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0: return new SchemesFragment();
            case 1: return new ConnectFragment();
            case 2: return new ProcedureFragment();
            case 3: return new VideoFragment();
            default: return new SchemesFragment();
        }
    }

    @Override
    public int getCount() { return 4 ; }

    public CharSequence getPageTitle(int position) {
        String title = null;

        if(position==0){ title = "SCHEMES"; }
        if(position==1){ title = "CONNECT"; }
        if(position==2){ title = "INFO"; }
        if(position==3){ title = "CAMERA"; }
        return title;
    }
}


package unknowns.developer.coronaexpress.adapters;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import unknowns.developer.coronaexpress.fragments.CoronaFragment;
import unknowns.developer.coronaexpress.fragments.HelpFragment;
import unknowns.developer.coronaexpress.fragments.HomeFragment;
import unknowns.developer.coronaexpress.fragments.NewsFragment;
import unknowns.developer.coronaexpress.fragments.SettingsFragment;
import unknowns.developer.coronaexpress.fragments.StatisticsFragment;
import unknowns.developer.coronaexpress.fragments.TipsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if(position==0){
            fragment = new HomeFragment();
        }else if(position==1){
            fragment = new HelpFragment();
        }else if(position==2){
            fragment = new NewsFragment();
        }else if(position==3){
            fragment = new StatisticsFragment();
        }else if(position==4){
            fragment = new TipsFragment();
        }else if(position==5){
            fragment = new CoronaFragment();
        }else if(position==6){
            fragment = new SettingsFragment();
        }

        assert fragment != null;
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }
}

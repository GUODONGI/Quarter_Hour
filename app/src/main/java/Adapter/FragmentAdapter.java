package Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import fragment.Tab_fragment1;

/**
 * Created by GUODONG on 2017/11/25.
 */

public class FragmentAdapter extends FragmentPagerAdapter {


    private List<Fragment> list;
    private Context context;
    private String[] tieles = {"页面1","页面2"};

    public FragmentAdapter(FragmentManager fm, List<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tieles[position];
    }
}

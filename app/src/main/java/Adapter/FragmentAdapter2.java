package Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by GUODONG on 2017/11/25.
 */

public class FragmentAdapter2 extends FragmentPagerAdapter {


    private List<Fragment> list;
    private Context context;
    private String[] tieles = {"热门","附近 "};

    public FragmentAdapter2(FragmentManager fm, List<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;
    }

    public FragmentAdapter2(FragmentManager fm) {
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

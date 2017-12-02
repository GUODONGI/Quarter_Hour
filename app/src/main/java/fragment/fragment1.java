package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.FragmentAdapter;
import test.bwie.com.quarter_hour.R;

/**
 * Created by GUODONG on 2017/11/25.
 */

public class fragment1  extends Fragment {

    private List<Fragment> list;
    private TabLayout tablayout;
    private ViewPager view_pager;
    private FragmentAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.item2, null);


        list = new ArrayList<>();
        list.add(new Tab_fragment1());
        list.add(new Tab_fragment2());
        tablayout = view.findViewById(R.id.tablayout);
        view_pager = view.findViewById(R.id.view_pager);
        adapter = new FragmentAdapter(getActivity().getSupportFragmentManager(), list,getActivity());
        view_pager.setAdapter(adapter);
        tablayout.setupWithViewPager(view_pager);

        return view;

    }
}

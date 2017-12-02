package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import Adapter.ShiPingAdapter;
import Presenter.GetAdPresenter;
import base.BaseFragment;
import basemodel.BasePresenterr;
import bean.GetAd;
import bean.Product;
import test.bwie.com.quarter_hour.R;
import test.bwie.com.quarter_hour.SpacesItemDecoration;
import view.GetAdView;
import view.LogView;

/**
 * Created by GUODONG on 2017/11/25.
 */

public class Tab_fragment3 extends BaseFragment{

    private XRecyclerView x_rec;
    private List<Product> products;

    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }

    @Override
    public int getViewId() {
        return R.layout.spitem;
    }

    @Override
    public void initFragment() {
        x_rec = view.findViewById(R.id.x_rec);
        products = new ArrayList<>();

        //设置layoutManager
        x_rec.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        //设置adapter
        initData();
        ShiPingAdapter adapter=new ShiPingAdapter(products,getActivity());
        x_rec.setAdapter(adapter);

       //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(20);
        x_rec.addItemDecoration(decoration);
    }
    private void initData() {
        for (int i = 0; i <10 ; i++) {
            products.add(new Product(R.drawable.yi,"标题"+i));
        }
    }

    @Override
    public void resumFragment() {
    }
}

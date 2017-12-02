package fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.XRecyclerViewAdapter;
import Presenter.GetJokesPresenter;
import Presenter.PublishJokePresenter;
import base.BaseFragment;
import bean.Duan;
import bean.DuanZi;
import bean.PublishJoke;
import test.bwie.com.quarter_hour.R;
import view.GetJokesView;
import view.PublishJokeView;

/**
 * Created by GUODONG on 2017/11/25.
 */

public class fragment2 extends BaseFragment<GetJokesPresenter> implements GetJokesView {


    private List<Duan> list;
    private XRecyclerView rx_view;
    private XRecyclerViewAdapter adapter;

    @Override
    public void seccuss(DuanZi duanZi) {

        List<DuanZi.DataBean> data = duanZi.data;
        for (int i = 0; i <data.size() ; i++) {

            DuanZi.DataBean dataBean = data.get(i);
            Duan d = new Duan();
            d.content = dataBean.content;
            d.createTime = dataBean.createTime;
            DuanZi.DataBean.UserBean user = dataBean.user;
            d.icon = user.icon;
            d.nickname = user.nickname;
            d.imgUrls = dataBean.imgUrls+"";
            list.add(d);

        }

    }

    @Override
    public void error(String msg) {

        presenter.error(msg);

    }

    @Override
    public void Token(String msg) {

        presenter.Token(msg);
    }

    @Override
    public void netfailure(String msg) {

        presenter.netfailure(msg);
    }

    @Override
    public GetJokesPresenter initPresenter() {
        return new GetJokesPresenter(this,getActivity());
    }

    @Override
    public int getViewId() {
        return R.layout.item3;
    }

    @Override
    public void initFragment() {


        rx_view = view.findViewById(R.id.rx_view);
        list = new ArrayList<>();
        adapter = new XRecyclerViewAdapter(list,getActivity());
        rx_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        rx_view.setAdapter(adapter);
        rx_view.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                showToast("刷新列表");
            }

            @Override
            public void onLoadMore() {

                showToast("加载列表");
            }
        });



    }

    @Override
    public void resumFragment() {

        presenter.GetJokes("86");

    }
}

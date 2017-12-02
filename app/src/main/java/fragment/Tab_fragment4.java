package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import base.BaseFragment;
import basemodel.BasePresenterr;
import test.bwie.com.quarter_hour.R;

/**
 * Created by GUODONG on 2017/11/25.
 */

public class Tab_fragment4 extends BaseFragment {

    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }

    @Override
    public int getViewId() {
        return R.layout.guanzhuitem;
    }

    @Override
    public void initFragment() {

    }

    @Override
    public void resumFragment() {

    }
}

package test.bwie.com.quarter_hour;

import android.support.annotation.Nullable;
import android.os.Bundle;

import base.BaseActivity;
import basemodel.BasePresenterr;

public class ShuRuMiMa extends BaseActivity {


    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shu_ru_mi_ma;
    }

    @Override
    public void initView() {



    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}

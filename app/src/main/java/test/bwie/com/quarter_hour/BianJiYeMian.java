package test.bwie.com.quarter_hour;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import base.BaseActivity;
import basemodel.BasePresenterr;

public class BianJiYeMian extends BaseActivity {
    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_bian_ji_ye_mian;
    }
    @Override
    public void initView() {


        RelativeLayout re_sp = findViewById(R.id.re_sp);
        RelativeLayout re_dz = findViewById(R.id.re_dz);


        re_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BianJiYeMian.this, "视频", Toast.LENGTH_SHORT).show();
            }
        });
        re_dz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(DuanZiYeMian.class);
            }
        });
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}

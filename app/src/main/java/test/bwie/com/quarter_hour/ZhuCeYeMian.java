package test.bwie.com.quarter_hour;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Presenter.ZhuPresenter;
import base.BaseActivity;
import bean.Reg;
import view.RegView;

public class ZhuCeYeMian extends BaseActivity<ZhuPresenter>implements RegView {


    @Override
    public ZhuPresenter initPresenter() {

        return new ZhuPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_zhu_ce_ye_mian;
    }

    @Override
    public void initView() {

        TextView te_yiyou = findViewById(R.id.te_yi);
        final EditText ed_shou = findViewById(R.id.ed_shou);
        final EditText ed_mima = findViewById(R.id.ed_mima);
        Button te_zhuce = findViewById(R.id.te_zhuce);

        te_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.reg(ed_shou.getText().toString(),ed_mima.getText().toString(),"0");

            }
        });
        te_yiyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZhuCeYeMian.this,QiTaDengLu.class);
                startActivity(intent);

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
    @Override
    public void seccuss(Reg reg) {

       showToast(reg.msg);
    }

    @Override
    public void error(String msg) {

        showToast(msg);

    }
    @Override
    public void Token(String msg) {

    }
    @Override
    public void netfailure(String msg) {

    }
}

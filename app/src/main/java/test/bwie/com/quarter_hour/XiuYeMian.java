package test.bwie.com.quarter_hour;


import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import Presenter.UpdateNickNamePresenter;
import base.BaseActivity;
import bean.Update;
import view.UpdateView;

public class XiuYeMian extends BaseActivity<UpdateNickNamePresenter>implements UpdateView {

    private EditText ed_xiu;
    private TextView te_bao;
    private int uid;

    @Override
    public UpdateNickNamePresenter initPresenter() {
        return new UpdateNickNamePresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_xiu_ye_mian;
    }

    @Override
    public void initView() {


        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        uid = sp.getInt("uid", 0);
        ed_xiu = findViewById(R.id.ed_xiu);
        te_bao = findViewById(R.id.te_bao);
        te_bao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                presenter.update(uid+"",ed_xiu.getText().toString());

            }
        });



    }

    @Override
    public void seccuss(Update update) {

        showToast(update.msg);


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

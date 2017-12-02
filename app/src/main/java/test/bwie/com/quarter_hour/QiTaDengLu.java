package test.bwie.com.quarter_hour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Presenter.LoginPresenter;
import base.BaseActivity;
import bean.Deng;
import view.LogView;


public class QiTaDengLu extends BaseActivity<LoginPresenter> implements LogView{


    private SharedPreferences sp;
    private SharedPreferences sp1;

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_qi_ta_deng_lu;
    }

    @Override
    public void initView() {

        TextView te_you = findViewById(R.id.te_you);
        TextView te_wang = findViewById(R.id.te_wang);
        final EditText ed_phone = findViewById(R.id.ed_phone);
        final EditText ed_pass = findViewById(R.id.ed_pass);
        Button te_denglu = findViewById(R.id.te_denglu);
        TextView te_zhu = findViewById(R.id.te_zhu);
        this.sp = getSharedPreferences("token",MODE_PRIVATE);
        te_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    presenter.login(ed_phone.getText().toString(),ed_pass.getText().toString());
            }
        });

        te_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QiTaDengLu.this,ZhuCeYeMian.class);
                startActivity(intent);
            }
        });
        te_wang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(ZhaoHuiMiMa.class);
            }
        });

        te_you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QiTaDengLu.this,ZhuYeMian.class);
                startActivity(intent);
                SharedPreferences.Editor edit = sp.edit();
                edit.clear();
                edit.commit();

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
    public void seccuss(Deng deng) {


        Deng.DataBean data = deng.data;
        String token = data.token;
        int uid = data.uid;
        String icon = data.icon;
        String nickname = data.nickname;
        String mobile = data.mobile;
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("token",token);
        edit.putString("name",nickname);
        edit.putString("icon",icon);
        edit.putInt("uid",uid);
        edit.putString("moblie",mobile);
        edit.putString("nickname",nickname);
        edit.commit();
        startActivity(ZhuYeMian.class);


    }

    @Override
    public void error(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void Token(String msg) {



    }

    @Override
    public void netfailure(String msg) {

    }
}


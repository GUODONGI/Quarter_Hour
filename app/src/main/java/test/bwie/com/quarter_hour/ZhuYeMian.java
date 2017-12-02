package test.bwie.com.quarter_hour;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.kson.slidingmenu.SlidingMenu;
import com.meg7.widget.CustomShapeImageView;
import java.util.List;
import base.BaseActivity;

import basemodel.BasePresenterr;
import fragment.Left_fragment;
import fragment.Tab_fragment1;
import fragment.Tab_fragment2;
import fragment.Tab_fragment3;
import fragment.fragment1;
import fragment.fragment2;
import fragment.fragment3;


public class ZhuYeMian extends BaseActivity{

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private List<Fragment> list;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private CustomShapeImageView tv_touxiang;
    private SlidingMenu menu;
    private SharedPreferences sp;
    private TextView te_biaoti;
    private fragment.fragment1 fragment1;
    private fragment.fragment2 fragment2;
    private fragment.fragment3 fragment3;
    private ImageView iv_bianji;


    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }
    @Override
    public int getLayoutId() {

        return R.layout.activity_zhu_ye_mian;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void initView() {
        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        tv_touxiang = findViewById(R.id.tv_touxiang);
        te_biaoti = findViewById(R.id.te_biaoti);
        iv_bianji = findViewById(R.id.iv_bianji);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);


        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();
        getSupportFragmentManager().beginTransaction().add(R.id.fr_layout, fragment1).show(fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fr_layout, fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fr_layout, fragment3).hide(fragment3).commit();
        img1.setImageResource(R.mipmap.tj2);
        img2.setImageResource(R.mipmap.dz);
        img3.setImageResource(R.mipmap.sp);
        text1.setTextColor(Color.parseColor("#1580E7"));
        text2.setTextColor(Color.GRAY);
        text3.setTextColor(Color.GRAY);
        te_biaoti.setText("推荐");



        sp = getSharedPreferences("token", MODE_PRIVATE);
        String icon = sp.getString("icon", "");
        Glide.with(this).load(icon).into(tv_touxiang);

        tv_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.showMenu();
            }
        });
        menu = new SlidingMenu(this);
        menu.setMenu(R.layout.left);
        getSupportFragmentManager().beginTransaction().replace(R.id.left,new Left_fragment()).commit();
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setBehindOffsetRes(R.dimen.juli);
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);


        iv_bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZhuYeMian.this,BianJiYeMian.class);
                startActivity(intent);

            }
        });

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().show(fragment1).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment2).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment3).commit();
                img1.setImageResource(R.mipmap.tj2);
                img2.setImageResource(R.mipmap.dz);
                img3.setImageResource(R.mipmap.sp);
                text1.setTextColor(Color.parseColor("#1580E7"));
                text2.setTextColor(Color.GRAY);
                text3.setTextColor(Color.GRAY);
                te_biaoti.setText("推荐");
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().show(fragment2).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment1).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment3).commit();
                img1.setImageResource(R.mipmap.tj);
                img2.setImageResource(R.mipmap.dz2);
                img3.setImageResource(R.mipmap.sp);
                text2.setTextColor(Color.parseColor("#1580E7"));
                text1.setTextColor(Color.GRAY);
                text3.setTextColor(Color.GRAY);
                te_biaoti.setText("段子");
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().show(fragment3).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment2).commit();
                getSupportFragmentManager().beginTransaction().hide(fragment1).commit();
                img1.setImageResource(R.mipmap.tj);
                img2.setImageResource(R.mipmap.dz);
                img3.setImageResource(R.mipmap.sp2);
                text3.setTextColor(Color.parseColor("#1580E7"));
                text2.setTextColor(Color.GRAY);
                text1.setTextColor(Color.GRAY);
                te_biaoti.setText("视频");
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

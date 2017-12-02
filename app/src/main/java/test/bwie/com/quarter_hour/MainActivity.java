package test.bwie.com.quarter_hour;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import java.util.ArrayList;
import java.util.List;
import base.BaseActivity;
import basemodel.BasePresenterr;

public class MainActivity extends BaseActivity {


    private ViewPager vp;
    private List<Integer> list;
    private ImageView te_tu;
    private ImageView te_dian;

    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    public void initView() {

        vp = findViewById(R.id.vp);
        list = new ArrayList<>();
        list.add(R.mipmap.yiyiyi);
        list.add(R.mipmap.erer);
        list.add(R.mipmap.sansan);


        PagerAdapter adapter = new Adapter.PagerAdapter(list,this);
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {

                if (position==2){


                    startActivity(DengLu.class);

                }
/*
                if(position==3)
                {
                    View view = View.inflate(MainActivity.this, R.layout.item, null);
                    te_tu = findViewById(R.id.te_tu);
                    te_dian = findViewById(R.id.te_dian);
                    //加载动图
                    Glide.with(MainActivity.this).load(R.drawable.dong)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new GlideDrawableImageViewTarget(te_tu,1));
                    te_dian.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent  = new Intent(MainActivity.this,DengLu.class);
                            startActivity(intent);
                        }
                    });
                }*/
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}

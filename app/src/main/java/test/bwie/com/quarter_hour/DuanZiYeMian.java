package test.bwie.com.quarter_hour;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import Adapter.TuPianAdapter;
import Presenter.PublishJokePresenter;
import base.BaseActivity;
import bean.PublishJoke;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import view.PublishJokeView;

public class DuanZiYeMian extends BaseActivity<PublishJokePresenter> implements PublishJokeView {


    private EditText ed_shu;
    private TextView te_fa;
    private List<String> path;
    private RecyclerView re_view;
    private int uid;

    @Override
    public void seccuss(PublishJoke publishJoke) {
        showToast(publishJoke.getMsg());
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
    @Override
    public PublishJokePresenter initPresenter() {
        return new PublishJokePresenter(this,this);
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_duan_zi_ye_mian;
    }
    @Override
    public void initView() {

        ed_shu = findViewById(R.id.ed_shu);
        te_fa = findViewById(R.id.te_fa);
        ImageView te_jiatu = findViewById(R.id.te_jiatu);
        re_view = findViewById(R.id.re_view);
        SharedPreferences sp = getSharedPreferences("token",MODE_PRIVATE);
        uid = sp.getInt("uid", 0);
        te_jiatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiImageSelector.create(DuanZiYeMian.this)
                        .start(DuanZiYeMian.this, 100);
            }
        });



        te_fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                presenter.publishJoke(uid,ed_shu.getText().toString(),path);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                // 获取返回的图片列表
                path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);

                if(path.size()<3)
                {
                    re_view.setLayoutManager(new GridLayoutManager(this,path.size()));
                }else{
                    re_view.setLayoutManager(new GridLayoutManager(this,3));
                }
                re_view.setAdapter(new TuPianAdapter(this,path));


            }
        }
    }
}

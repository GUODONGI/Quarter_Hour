package test.bwie.com.quarter_hour;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import base.BaseActivity;
import basemodel.BasePresenterr;

public class DengLu extends BaseActivity {
    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_deng_lu;
    }
    @Override
    public void initView() {

        TextView te_qi = findViewById(R.id.te_qi);
        ImageView te_tui1 = findViewById(R.id.te_tui1);

        te_tui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(QiTaDengLu.class);

            }
        });
        te_qi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DengLu.this,QiTaDengLu.class);
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


}

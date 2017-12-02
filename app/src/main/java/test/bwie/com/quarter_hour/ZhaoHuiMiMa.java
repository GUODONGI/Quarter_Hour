package test.bwie.com.quarter_hour;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import base.BaseActivity;
import basemodel.BasePresenterr;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class ZhaoHuiMiMa extends BaseActivity {


    private EventHandler ev;

    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_zhao_hui_mi_ma;
    }

    @Override
    public void initView() {

        Button te_xia = findViewById(R.id.te_xia);
        TextView te_huo = findViewById(R.id.te_huo);
        final EditText ed_shouji = findViewById(R.id.ed_shouji);



        /*//获取手机验证码
        te_huo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String shouji = ed_shouji.getText().toString();
                SMSSDK.getVerificationCode("86",shouji);


            }
        });
*/


        te_xia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ZhaoHuiMiMa.this,ShuRuMiMa.class);
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


        ev = new EventHandler() {
            @Override
            public void afterEvent(final int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        Log.i("EventHandler", "获取验证码成功");
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                        Log.i("EventHandler", "返回支持发送验证码的国家列表");
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                    Log.i("EventHandler", "回调失败");
                }
            }
        };


    }
}

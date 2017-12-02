package test.bwie.com.quarter_hour;


import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
import base.BaseActivity;
import basemodel.BasePresenterr;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class DengLuMain2Activity extends BaseActivity {
    private RelativeLayout tv_rel1;
    private int num=0;
    private int mima = 0;
    private TextView te_qie;
    private RelativeLayout tv_rel2;
    private ImageView showmima;
    private EditText pass2;
    private int dao = 0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            dao=what;
            if(what==0)
            {
                yzm.setImageResource(R.mipmap.cxhq);
                daojishi.setVisibility(View.INVISIBLE);
                timer.cancel();
            }else{
                daojishi_text.setText(what+"s后");
            }
        }
    };

    private ImageView yzm;
    private RelativeLayout daojishi;
    private Timer timer;
    private TextView daojishi_text;
    private EventHandler eh;
    private EditText phone;
    private ImageView te_deng;

    @Override
    public BasePresenterr initPresenter() {
        return presenter;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_deng_lu_main2;
    }
    @Override
    public void initView() {
        //获取控件
        phone = findViewById(R.id.phone);
        yzm = findViewById(R.id.yzm);
        te_qie = findViewById(R.id.te_qie);
        tv_rel1 = findViewById(R.id.tv_rel1);
        tv_rel2 = findViewById(R.id.tv_rel2);
        showmima = findViewById(R.id.showmima);
        pass2 = findViewById(R.id.pass2);
        daojishi = findViewById(R.id.daojishi);
        daojishi_text = findViewById(R.id.daojishi_text);
        te_deng = findViewById(R.id.te_deng);
        showmima.setImageResource(R.mipmap.yc);
        pass2.setTransformationMethod(PasswordTransformationMethod.getInstance());

        te_qie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num++;
                if(num%2==1)
                {
                    tv_rel1.setVisibility(View.INVISIBLE);
                    tv_rel2.setVisibility(View.VISIBLE);
                    daojishi.setVisibility(View.INVISIBLE);
                    te_qie.setText("短信验证码登录方式");
                }else if(num%2==0)
                {
                    tv_rel2.setVisibility(View.INVISIBLE);
                    tv_rel1.setVisibility(View.VISIBLE);
                    daojishi.setVisibility(View.VISIBLE);
                    te_qie.setText("使用常规登录方式");
                }
            }
        });
        showmima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mima++;
                if(mima%2==0)
                {
                    showmima.setImageResource(R.mipmap.yc);
                    pass2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else if(mima%2==1)
                {
                    showmima.setImageResource(R.mipmap.xs);
                    pass2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        yzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dao>0)
                {
                    String phone1 = phone.getText().toString();
                    if(judgePhoneNums(phone1))
                    {
                        return;
                    }
                    SMSSDK.getVerificationCode("86",phone1);
                    System.out.println("电话："+phone1);
                }else{
                    daojishi.setVisibility(View.VISIBLE);
                    timer = new Timer();
                    TimerTask timerTask = new TimerTask() {
                        int t = 30;
                        @Override
                        public void run() {
                            t--;
                            Message obtain = Message.obtain();
                            obtain.what = t;
                            handler.sendMessage(obtain);
                        }
                    };
                    timer.schedule(timerTask,1000,1000);
                }
            }
        });

        te_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DengLuMain2Activity.this,DengLu.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //回调完成
        //获取验证码成功
        //返回支持发送验证码的国家列表
        eh = new EventHandler() {
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
    private boolean judgePhoneNums(String phoneNums) {
        if (isMatchLength(phoneNums, 11) && isMobileNO(phoneNums)) {
            return true;
        }
        Toast.makeText(this, "手机号码输入有误！", Toast.LENGTH_SHORT).show();
        return false;
    }
    public static boolean isMatchLength(String str, int length) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.length() == length ? true : false;
        }
    }
    public static boolean isMobileNO(String mobileNums) {
        String telRegex = "[1][3578]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }
}

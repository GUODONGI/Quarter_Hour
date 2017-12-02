package base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import basemodel.BasePresenterr;

/**
 * Created by GUODONG on 2017/11/14.
 */

public abstract class  BaseActivity <P extends BasePresenterr> extends AppCompatActivity{
    public P presenter;
    public abstract P initPresenter();
    public abstract int getLayoutId();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        presenter = initPresenter();
        initView();
    }
    public abstract void initView();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null)
        {
            presenter.destory();
        }
    }

    //吐司
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * 无参跳转
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }

    /**
     * 有参跳转
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

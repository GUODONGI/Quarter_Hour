package test.bwie.com.quarter_hour;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class MyApp extends Application{

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        LeakCanary.install(this);
    }
}

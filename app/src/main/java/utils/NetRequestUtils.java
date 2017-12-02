package utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import Interceptor.MyInterceptor;
import url.Uri;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class NetRequestUtils {


    public static NetRequestUtils utils;
    private MyJieKou myJieKou;

    public NetRequestUtils(MyJieKou myJieKou) {
        this.myJieKou = myJieKou;
    }

    public MyJieKou getMyJieKou() {
        return myJieKou;
    }

    public static class Builder{
        List<Converter.Factory> factories = new ArrayList<>();
        List<CallAdapter.Factory> factoryList = new ArrayList<>();
        public  Builder addConverterFactory(Converter.Factory factory)
        {

            factories.add(factory);
            return this;
        }
        public Builder addCallAdapterFactory(CallAdapter.Factory factory){
            factoryList.add(factory);
            return this;
        }
        public NetRequestUtils buulder(){

            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(Uri.Deng).client(okHttpClient);
            if(factories.size()==0)
            {
                builder.addConverterFactory(GsonConverterFactory.create());
            }else{
                for (Converter.Factory factory : factories) {
                    builder.addConverterFactory(factory);
                }
            }
            if(factoryList.size()==0)
            {
                builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            }else{
                for (CallAdapter.Factory factory : factoryList) {
                    builder.addCallAdapterFactory(factory);
                }
            }
            MyJieKou jieKou = builder.build().create(MyJieKou.class);
            utils = new NetRequestUtils(jieKou);
            return utils;
        }
    }
}

package Model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import utils.NetRequestUtils;
import bean.Deng;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GUODONG on 2017/11/15.
 */

public class ILoginModel {
    public LoginInterface login;

    public ILoginModel(LoginInterface deng) {
        this.login = deng;
    }
    public void network(String mobile,String password){

        new NetRequestUtils.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .buulder()
                .getMyJieKou()
                .login(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Deng>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(Deng deng) {

                String code = deng.code;
                if(code.equals("0"))
                {
                    login.seccuss(deng);

                }else{

                    login.error(deng.msg);
                }
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onComplete() {

            }
        });
    }
    public interface LoginInterface {

        void seccuss(Deng d);

        void error(String msg);

        void netfailure(String msg);
    }
}

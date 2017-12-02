package Model;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import bean.Deng;
import bean.DuanZi;
import bean.GeRen;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.NetRequestUtils;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class GetJokesModel {

    public GetJokesInterface jokesInterface;

    public GetJokesModel(GetJokesInterface j) {
        this.jokesInterface = j;

    }
    public void network(String uid){

        new NetRequestUtils.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .buulder()
                .getMyJieKou()
                .getJokes(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<DuanZi>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(DuanZi d) {


                String code = d.code;
                if(code.equals("0"))
                {
                    jokesInterface.seccuss(d);

                }else if(code.equals("1")){

                    jokesInterface.error(d.msg);
                }

            }
            @Override
            public void onError(Throwable e) {

                jokesInterface.netfailure("");
            }
            @Override
            public void onComplete() {
            }
        });
    }
    public interface GetJokesInterface {

        void seccuss(DuanZi d);

        void error(String msg);

        void netfailure(String msg);

        void Token(String msg);
    }
}

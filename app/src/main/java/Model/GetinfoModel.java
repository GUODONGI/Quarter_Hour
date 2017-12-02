package Model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import bean.Deng;
import bean.GeRen;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.NetRequestUtils;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class GetinfoModel {

    private InfoInterface infoInterface;

    public GetinfoModel(InfoInterface geren) {

        this.infoInterface = geren;
    }
    public void network(String uid){

        new NetRequestUtils.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .buulder()
                .getMyJieKou()
                .getinfo(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<GeRen>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(GeRen g) {

                String code = g.code;
                if(code.equals("0"))
                {
                    infoInterface.seccuss(g);

                }else if(code.equals("1")){

                    infoInterface.error(g.msg);
                }
            }
            @Override
            public void onError(Throwable e) {
                infoInterface.netfailure("");

            }
            @Override
            public void onComplete() {

            }
        });
    }


    public interface InfoInterface {

        void seccuss(GeRen g);

        void error(String msg);

        void netfailure(String msg);

        void Token(String msg);
    }
}

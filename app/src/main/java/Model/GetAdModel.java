package Model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import bean.GeRen;
import bean.GetAd;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.NetRequestUtils;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class GetAdModel  {

    private GetAdInterface getAdInterface;

    public GetAdModel(GetAdInterface getAdInterface) {
        this.getAdInterface = getAdInterface;
    }


    public void network(){

        new NetRequestUtils.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .buulder()
                .getMyJieKou()
                .getAd()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<GetAd>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(GetAd g) {

                String code = g.code;
                if(code.equals("0"))
                {
                    getAdInterface.seccuss(g);

                }else if(code.equals("1")){

                    getAdInterface.error(g.msg);
                }
            }
            @Override
            public void onError(Throwable e) {
                getAdInterface.netfailure("");

            }
            @Override
            public void onComplete() {

            }
        });
    }
    public interface GetAdInterface {

        void seccuss(GetAd g);

        void error(String msg);

        void netfailure(String msg);

        void Token(String msg);
    }
}

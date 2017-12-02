package Model;

import android.os.Environment;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import bean.Deng;
import bean.GeRen;
import bean.PublishJoke;
import bean.Reg;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.MyJieKou;
import utils.NetRequestUtils;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class PublishJokeModel {

    private InfoInterface infoInterface;

    public PublishJokeModel(InfoInterface p) {
        this.infoInterface = p;
    }
    public void network(List<MultipartBody.Part> parts){


        new NetRequestUtils.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .buulder()
                .getMyJieKou()
                .publish(parts)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PublishJoke>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PublishJoke r) {

                String code = r.getCode();
                if(code.equals("0"))
                {
                    infoInterface.seccuss(r);

                }else{

                    infoInterface.error(r.getMsg());
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

    public interface InfoInterface {

        void seccuss(PublishJoke p);

        void error(String msg);

        void netfailure(String msg);

        void Token(String msg);
    }
}

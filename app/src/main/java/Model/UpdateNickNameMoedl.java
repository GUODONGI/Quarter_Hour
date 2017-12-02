package Model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import bean.Reg;
import bean.Update;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.NetRequestUtils;

/**
 * Created by GUODONG on 2017/11/30.
 */

public class UpdateNickNameMoedl {



    private UpdateInterface updateInterface;

    public UpdateNickNameMoedl(UpdateInterface updateInterface) {
        this.updateInterface = updateInterface;
    }


    public void networkUpade(String uid, String nickname){

        new NetRequestUtils.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .buulder()
                .getMyJieKou()
                .update(uid,nickname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Update>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Update u) {

                String code = u.code;
                if(code.equals("0"))
                {
                    updateInterface.seccuss(u);
                }else{
                    updateInterface.error(u.msg);
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

    public interface UpdateInterface {

        void seccuss(Update u);

        void error(String msg);

        void netfailure(String msg);

    }

}

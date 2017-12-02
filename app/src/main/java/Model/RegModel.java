package Model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import utils.NetRequestUtils;
import bean.Reg;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class RegModel {

    public LoginInterface reg;

    public RegModel(LoginInterface reg) {
        this.reg = reg;
    }
    public void networkZhu(String mobile, String password,String regType){

        new NetRequestUtils.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .buulder()
                .getMyJieKou()
                .Reg(mobile,password,regType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Reg>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Reg r) {

                String code = r.code;
                if(code.equals("0"))
                {
                    reg.seccuss(r);
                }else{
                    reg.error(r.msg);
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

        void seccuss(Reg reg);

        void error(String msg);

        void netfailure(String msg);

    }

}

package Presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import Model.ILoginModel;
import basemodel.BasePresenterr;
import view.LogView;
import bean.Deng;

/**
 * Created by GUODONG on 2017/11/15.
 */

public class LoginPresenter extends BasePresenterr<LogView> implements ILoginModel.LoginInterface{
    private ILoginModel model;
    private Context context;

    public LoginPresenter(LogView mView,Context context) {
        super(mView);
        this.context = context;
        model = new ILoginModel(this);
    }
    public void login(String mobile,String password){
        if(TextUtils.isEmpty(mobile))
        {
            Toast.makeText(context, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(context, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        model.network(mobile, password);
    }
    @Override
    public void seccuss(Deng d) {

        v.seccuss(d);
    }
    @Override
    public void error(String msg) {

        v.error(msg);
    }
    @Override
    public void netfailure(String msg) {
        v.netfailure(msg);
    }
}

package Presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import Model.RegModel;
import basemodel.BasePresenterr;
import bean.Reg;
import view.RegView;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class ZhuPresenter extends BasePresenterr<RegView> implements RegModel.LoginInterface {

    private RegModel regModel;
    private Context context;

    public ZhuPresenter(RegView mView,Context context) {
        super(mView);
        this.context = context;
        regModel = new RegModel(this);
    }

    public void reg(String mobile,String password,String regType){

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
        regModel.networkZhu(mobile, password,regType);

    }
    @Override
    public void seccuss(Reg r) {

        v.seccuss(r);

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

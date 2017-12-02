package Presenter;

import android.content.Context;

import Model.UpdateNickNameMoedl;
import basemodel.BasePresenterr;
import bean.Update;
import view.UpdateView;

/**
 * Created by GUODONG on 2017/11/30.
 */

public class UpdateNickNamePresenter extends BasePresenterr<UpdateView>implements UpdateNickNameMoedl.UpdateInterface {


    private UpdateNickNameMoedl moedl;
    private Context context;

    public UpdateNickNamePresenter(UpdateView view,Context context) {
        super(view);
        this.context = context;
        moedl = new UpdateNickNameMoedl(this);
    }


    public void update(String uid,String nickname){


        moedl.networkUpade(uid,nickname);

    }

    @Override
    public void seccuss(Update u) {

        v.seccuss(u);
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

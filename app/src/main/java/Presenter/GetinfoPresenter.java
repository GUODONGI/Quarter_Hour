package Presenter;

import android.content.Context;

import Model.GetinfoModel;
import basemodel.BasePresenterr;
import bean.GeRen;
import view.InfoView;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class GetinfoPresenter extends BasePresenterr<InfoView> implements GetinfoModel.InfoInterface{

    private GetinfoModel model;
    private Context context;

    public GetinfoPresenter(InfoView view,Context context) {
        super(view);
        this.context = context;
        model = new GetinfoModel(this);
    }


    public void Getinfo(String uid){

        model.network(uid);

    }

    @Override
    public void seccuss(GeRen g) {

        v.seccuss(g);
    }

    @Override
    public void error(String msg) {

        v.error(msg);

    }

    @Override
    public void netfailure(String msg) {

        v.netfailure(msg);
    }

    @Override
    public void Token(String msg) {

        v.Token(msg);
    }
}

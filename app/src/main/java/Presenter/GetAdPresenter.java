package Presenter;

import android.content.Context;

import Model.GetAdModel;
import Model.GetinfoModel;
import basemodel.BasePresenterr;
import bean.GetAd;
import view.GetAdView;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class GetAdPresenter extends BasePresenterr<GetAdView> implements GetAdModel.GetAdInterface {


    private GetAdModel model;
    private Context context;

    public GetAdPresenter(GetAdView view,Context context) {
        super(view);
        this.context = context;
        model = new GetAdModel(this);
    }

    public void GetAd(){

       model.network();

    }

    @Override
    public void seccuss(GetAd g) {
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

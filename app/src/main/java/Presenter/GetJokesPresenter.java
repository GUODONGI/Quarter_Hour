package Presenter;

import android.content.Context;

import Model.GetJokesModel;
import Model.GetinfoModel;
import basemodel.BasePresenterr;
import bean.DuanZi;
import bean.GeRen;
import view.GetJokesView;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class GetJokesPresenter extends BasePresenterr<GetJokesView> implements GetJokesModel.GetJokesInterface {


    private GetJokesModel jokesModel;
    private Context context;

    public GetJokesPresenter(GetJokesView view,Context context) {
        super(view);
        this.context = context;
        jokesModel = new GetJokesModel(this);
    }


    public void GetJokes(String uid){

        jokesModel.network(uid);

    }

    @Override
    public void seccuss(DuanZi d) {

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

    @Override
    public void Token(String msg) {

        v.Token(msg);
    }
}

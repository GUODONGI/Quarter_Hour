package fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.meg7.widget.CustomShapeImageView;

import Model.GetinfoModel;
import Presenter.GetinfoPresenter;
import Presenter.LoginPresenter;
import base.BaseActivity;
import base.BaseFragment;
import basemodel.BasePresenterr;
import bean.GeRen;
import test.bwie.com.quarter_hour.R;
import test.bwie.com.quarter_hour.XiuGaiXinXi;
import view.InfoView;

/**
 * Created by GUODONG on 2017/11/27.
 */

public class Left_fragment extends BaseFragment<GetinfoPresenter>implements InfoView{


    private SharedPreferences sp;
    private RelativeLayout re_lay;
    private int uid;
    private TextView te_name;
    private CustomShapeImageView touxiang;
    private String icon;
    private String nickname;

    @Override
    public GetinfoPresenter initPresenter() {
        return new GetinfoPresenter(this,getActivity());
    }

    @Override
    public int getViewId() {
        return R.layout.geren;
    }

    @Override
    public void initFragment() {

        te_name = view.findViewById(R.id.te_name);
        touxiang = view.findViewById(R.id.touxiang);
        re_lay = view.findViewById(R.id.re_lay);

        re_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(XiuGaiXinXi.class);

            }
        });

        sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        uid = sp.getInt("uid", 0);
        String icon = sp.getString("icon", "");
        String name = sp.getString("name", "");
        te_name.setText(name);
        Glide.with(getActivity()).load(icon).into(touxiang);

    }

    @Override
    public void resumFragment() {


      /*  presenter.Getinfo(uid+"");*/
    }




    @Override
    public void seccuss(GeRen g) {

       /* GeRen.DataBean data = g.data;
        icon = data.icon;
        nickname = data.nickname;
        te_name.setText(nickname);
        Glide.with(getActivity()).load(icon).into(touxiang);

*/

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void netfailure(String msg) {

    }

    @Override
    public void Token(String msg) {



    }
}

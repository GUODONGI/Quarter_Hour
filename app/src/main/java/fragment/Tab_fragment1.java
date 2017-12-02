package fragment;



import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import java.util.ArrayList;
import java.util.List;
import Presenter.GetAdPresenter;
import base.BaseFragment;
import bean.GetAd;
import test.bwie.com.quarter_hour.R;
import view.GetAdView;

/**
 * Created by GUODONG on 2017/11/25.
 */

public class Tab_fragment1 extends BaseFragment<GetAdPresenter> implements GetAdView{

    private List<String> list;
    private XBanner xban;

    @Override
    public GetAdPresenter initPresenter() {
        return new GetAdPresenter(this,getActivity());
    }

    @Override
    public int getViewId() {
        return R.layout.yemian1;
    }

    @Override
    public void initFragment() {
        xban = view.findViewById(R.id.xban);
        list = new ArrayList<>();
        xban.setPointsIsVisible(false);

    }
    @Override
    public void resumFragment() {

        presenter.GetAd();
    }
    @Override
    public void seccuss(GetAd getAd) {
        List<GetAd.DataBean> data = getAd.data;
        for (int i = 0; i <data.size() ; i++) {
            GetAd.DataBean dataBean = data.get(i);
            String icon = dataBean.icon;
            list.add(icon);

        }
        xban.setData(list,null);
        xban.setPoinstPosition(XBanner.CENTER);
        xban.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {

                Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);


            }
        });
    }

    @Override
    public void error(String msg) {

        showToast(msg);
    }

    @Override
    public void Token(String msg) {


    }

    @Override
    public void netfailure(String msg) {

    }


    @Override
    public void onResume() {
        super.onResume();
        xban.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        xban.stopAutoPlay();
    }


}

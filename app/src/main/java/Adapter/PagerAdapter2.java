package Adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import bean.Tu;
import test.bwie.com.quarter_hour.R;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class PagerAdapter2 extends android.support.v4.view.PagerAdapter {


    private List<Tu> list;
    private Context context;
    private ImageView img_lun;

    public PagerAdapter2(List<Tu> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = View.inflate(context, R.layout.lunbo, null);
        img_lun = view.findViewById(R.id.img_lun);



        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}

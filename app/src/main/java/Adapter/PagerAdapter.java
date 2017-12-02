package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.List;


import test.bwie.com.quarter_hour.R;

/**
 * Created by GUODONG on 2017/11/17.
 */
public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    List<Integer> list;
    private Context context;
    public PagerAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.yindao, null);
        ImageView tu = view.findViewById(R.id.tu);
        tu.setImageResource(list.get(position));
       /* else{
            view = View.inflate(context, R.layout.item, null);
            ImageView te_tu = view.findViewById(R.id.te_tu);
            //加载动图
            Glide.with(context).load(R.drawable.dong)

                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)

                    .into(new GlideDrawableImageViewTarget(te_tu,1));
        }*/
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

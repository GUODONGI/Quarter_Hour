package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import test.bwie.com.quarter_hour.R;

/**
 * Created by GUODONG on 2017/11/30.
 */

public class TuPianAdapter extends RecyclerView.Adapter<TuPianAdapter.MyViewHolder> {

    public Context context;
    public List<String> imgs;

    public TuPianAdapter(Context context, List<String> imgs) {
        this.context = context;
        this.imgs = imgs;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.statin_item_img,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String img = imgs.get(position);

        File file=new File(img);
        Glide.with(context).load(file).into(holder.iv_statin_img);
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_statin_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_statin_img = itemView.findViewById(R.id.iv_statin_img);
        }
    }
}

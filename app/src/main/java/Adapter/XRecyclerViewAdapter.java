package Adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.meg7.widget.CustomShapeImageView;

import java.util.List;

import bean.Duan;
import test.bwie.com.quarter_hour.R;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class XRecyclerViewAdapter extends XRecyclerView.Adapter<XRecyclerViewAdapter.ViewHloder> {


    private List<Duan> list;
    private Context context;

    public XRecyclerViewAdapter(List<Duan> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHloder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.duanitem, null);
        ViewHloder viewHloder = new ViewHloder(view);


        return viewHloder;
    }

    @Override
    public void onBindViewHolder(ViewHloder holder, int position) {



        Glide.with(context).load(list.get(position).icon).into(holder.img_tx);
        Glide.with(context).load(list.get(position).imgUrls).into(holder.iv_tu);

        holder.te_content.setText(list.get(position).content);
        holder.te_name2.setText(list.get(position).nickname);
        holder.te_time.setText(list.get(position).createTime);


        holder.imag_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(context, "13", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHloder extends RecyclerView.ViewHolder{

        private final TextView te_content;
        private final TextView te_time;
        private final TextView te_name2;
        private final CustomShapeImageView img_tx;
        private final ImageView imag_dong;
        private final ImageView iv_tu;

        public ViewHloder(View itemView) {
            super(itemView);
            te_content = itemView.findViewById(R.id.te_content);
            te_time = itemView.findViewById(R.id.te_time);
            te_name2 = itemView.findViewById(R.id.te_name2);
            img_tx = itemView.findViewById(R.id.img_tx);
            imag_dong = itemView.findViewById(R.id.imag_dong);
            iv_tu = itemView.findViewById(R.id.iv_tu);


        }
    }
}

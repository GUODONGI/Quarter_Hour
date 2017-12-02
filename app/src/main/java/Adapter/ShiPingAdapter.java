package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import bean.Product;
import test.bwie.com.quarter_hour.R;
/**
 * Created by GUODONG on 2017/12/1.
 */
public class ShiPingAdapter extends XRecyclerView.Adapter<ShiPingAdapter.ViewHloder> {

    private List<Product> products;
    private Context context;
    private List<Integer> mHeights;
    public ShiPingAdapter(List<Product> list,Context context) {
        products=list;
        this.context  = context;
        mHeights = new ArrayList<>();

        for(int i=0; i < list.size();i++){

            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+Math.random()*400));
        }
    }
    @Override
    public ViewHloder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.masonry_item, viewGroup,false);

        return new ViewHloder(view);
    }

    @Override
    public void onBindViewHolder(ViewHloder viewHloder, int position) {
        ViewGroup.LayoutParams layoutParams = viewHloder.itemView.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        viewHloder.imageView.setImageResource(products.get(position).getImg());
        viewHloder.textView.setText(products.get(position).getTitle());

    }
    @Override
    public int getItemCount() {
        return products.size();
    }
    public class ViewHloder extends XRecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public ViewHloder(View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.masonry_item_img );
            textView= itemView.findViewById(R.id.masonry_item_title);


        }
    }

}

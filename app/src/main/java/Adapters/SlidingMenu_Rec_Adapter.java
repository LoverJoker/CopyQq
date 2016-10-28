package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joker.copyqq.R;

/**
 * Created by Joker on 2016/10/28.
 */

public class SlidingMenu_Rec_Adapter extends RecyclerView.Adapter {

    private String[] mSliding_title;
    private int[] mSliding_img ;
    private Context mContext  ;
    private OnMyitemClick onMyitemClick ;

    //回调接口
    public interface OnMyitemClick{
        void OnClick(View view , int position);
    }

    public void setOnMyitemClick(OnMyitemClick onMyitemClick){
        this.onMyitemClick = onMyitemClick ;
    }



    public SlidingMenu_Rec_Adapter(Context mContext,String[] mSliding_title,int[] mSliding_img){
        this.mSliding_img = mSliding_img ;
        this.mSliding_title = mSliding_title ;
        this.mContext = mContext ;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Normal_Holder normal_holder = new Normal_Holder(LayoutInflater.from(mContext).inflate(R.layout.
                sliding_menu_item, parent, false));
        return normal_holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Normal_Holder normal_holder = (Normal_Holder) holder;
        Glide.with(mContext)
                .load(mSliding_img[position])
                .crossFade()
                .into(normal_holder.iv_sliding_menu);
        normal_holder.tv_sliding_menu.setText(mSliding_title[position]);
        normal_holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyitemClick.OnClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSliding_img.length;
    }

    class Normal_Holder extends RecyclerView.ViewHolder{
        ImageView iv_sliding_menu;
        TextView tv_sliding_menu;
        public Normal_Holder(View itemView) {
            super(itemView);
            iv_sliding_menu = (ImageView) itemView.findViewById(R.id.iv_sliding_menu);
            tv_sliding_menu = (TextView) itemView.findViewById(R.id.tv_sliding_menu);
        }
    }
}

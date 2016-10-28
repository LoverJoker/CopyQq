package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.copyqq.R;

/**
 * Created by Joker on 2016/10/27.
 */

public class Qzone_Rec_Adapter extends RecyclerView.Adapter {

    private String[] list_title ;
    private int[] list_img;
    private Context context ;
    private OnMyitemClicck onMyitemClicck ;

    //回调接口
    public interface OnMyitemClicck{
        void OnClick(View v , int position);
    }

    public void setOnMyitemClicck(OnMyitemClicck onMyitemClicck){
        this.onMyitemClicck = onMyitemClicck ;
    }

    public Qzone_Rec_Adapter(Context context,String[] list_title,int[] list_img){
        this.list_img = list_img ;
        this.list_title = list_title;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Normal_holder normal_holder = new Normal_holder(LayoutInflater.from(context)
                .inflate(R.layout.qzone_normal_item, parent, false));

        return normal_holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Normal_holder normal_holder = (Normal_holder) holder;
        normal_holder.iv_qzone_normal.setImageResource(list_img[position]);
        normal_holder.tv_qzone_normal.setText(list_title[position]);
        normal_holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyitemClicck.OnClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_img.length ;
    }

    class Normal_holder extends RecyclerView.ViewHolder{
        ImageView iv_qzone_normal;
        TextView tv_qzone_normal ;
        public Normal_holder(View itemView) {
            super(itemView);
            iv_qzone_normal = (ImageView) itemView.findViewById(R.id.iv_qzone_normal);
            tv_qzone_normal = (TextView) itemView.findViewById(R.id.tv_qzone_normal);
        }
    }
}

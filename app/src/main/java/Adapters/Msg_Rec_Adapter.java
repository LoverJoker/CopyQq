package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joker.copyqq.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Joker on 2016/10/27.
 */

public class Msg_Rec_Adapter extends RecyclerView.Adapter {

    private int[] mImg_url ;
    private String[] msg_information;
    private String[] msg_name;
    private Context mContext;

    private OnMyitemClicck onMyitemClicck ;

    //回调接口
    public interface OnMyitemClicck{
        void OnClick(View v , int position);
    }

    public void setOnMyitemClicck(OnMyitemClicck onMyitemClicck){
        this.onMyitemClicck = onMyitemClicck ;
    }



    public Msg_Rec_Adapter(Context mContext, int[] mImg_url, String[] msg_name,String[] msg_information){
        this.mImg_url = mImg_url ;
        this.msg_information = msg_information ;
        this.msg_name = msg_name ;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.msg_item, parent, false);
        NorMal_holder norMal_holder = new NorMal_holder(view);
        return norMal_holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        NorMal_holder norMal_holder = (NorMal_holder) holder;
        norMal_holder.tv_msg_information.setText(msg_information[position]);
        norMal_holder.tv_msg_name.setText(msg_name[position]);
        norMal_holder.cimg_msg.setImageResource(mImg_url[position]);
        norMal_holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyitemClicck.OnClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImg_url.length;
    }

    class NorMal_holder extends RecyclerView.ViewHolder{

        TextView tv_msg_name ;
        TextView tv_msg_information ;
        CircleImageView cimg_msg;

        public NorMal_holder(View itemView) {
            super(itemView);
            tv_msg_name = (TextView) itemView.findViewById(R.id.tv_msg_name);
            tv_msg_information = (TextView) itemView.findViewById(R.id.tv_msg_information);
            cimg_msg = (CircleImageView) itemView.findViewById(R.id.cimg_msg);

        }
    }
}

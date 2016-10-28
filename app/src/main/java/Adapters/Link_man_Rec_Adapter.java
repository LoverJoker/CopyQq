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
 * Created by Joker on 2016/10/26.
 */

public class Link_man_Rec_Adapter extends RecyclerView.Adapter {
    private int TOP_ITEM = 0;
    private int NORMAL_ITEM = 1;
    private Context context;

    private String[] link_name ;
    private String[] link_information;
    private int[] link_imgurl;

    private OnMyitemClicck onMyitemClicck ;

    //回调接口
    public interface OnMyitemClicck{
        void OnClick(View v , int position);
    }

    public void setOnMyitemClicck(OnMyitemClicck onMyitemClicck){
        this.onMyitemClicck = onMyitemClicck ;
    }




    public Link_man_Rec_Adapter(Context context,String[] link_name,String[] link_information,int[] link_imgurl){
        this.context = context ;
        this.link_name = link_name ;
        this.link_imgurl = link_imgurl;
        this.link_information = link_information;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder ;
        if (viewType == TOP_ITEM){
            viewHolder = new TopHolder(LayoutInflater.from(context).inflate(R.layout.link_man_top_item, parent, false));
        }else {
            viewHolder = new NorMal_Holder(LayoutInflater.from(context).inflate(R.layout.linkman_normal,parent,false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TopHolder){
            TopHolder topHolder = (TopHolder) holder;
        }else if (holder instanceof NorMal_Holder){
            NorMal_Holder norMal_holder = (NorMal_Holder) holder;
            norMal_holder.tv_linkman_name.setText(link_name[position-1]);
            norMal_holder.tv_linkman_information.setText(link_information[position-1]);
            norMal_holder.cimg_lingkman.setImageResource(link_imgurl[position-1]);
            norMal_holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyitemClicck.OnClick(v,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return link_information.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TOP_ITEM;
        }else {
            return NORMAL_ITEM;
        }
    }

    class TopHolder extends RecyclerView.ViewHolder{

        public TopHolder(View itemView) {
            super(itemView);
        }
    }

   class NorMal_Holder extends RecyclerView.ViewHolder{
        CircleImageView cimg_lingkman;
       TextView tv_linkman_name;
       TextView tv_linkman_information;

        public NorMal_Holder(View itemView) {
            super(itemView);
            tv_linkman_name = (TextView) itemView.findViewById(R.id.tv_linkman_name);
            tv_linkman_information = (TextView) itemView.findViewById(R.id.tv_linkman_information);
            cimg_lingkman = (CircleImageView) itemView.findViewById(R.id.cimg_lingkman);
        }
    }
}

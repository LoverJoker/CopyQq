package Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.joker.copyqq.R;

import Adapters.Qzone_Rec_Adapter;
import utils.Recycle_list_Decoration;

/**
 * Created by Joker on 2016/10/26.
 */

public class Qzone_Fragment extends Fragment implements View.OnClickListener{

    private RecyclerView mRec_qzone;
    private Activity mRootActivity;
    private String[] mList_title;
    private int[] mList_img;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_qzone, container, false);
        initView(view);
        initData();
        initAdapter();
        return view ;
    }

    private void initData() {
        mList_title = new String[]{"文件中转站","朋友","游戏中心","QQ钱包","二维码","设置"};
        mList_img = new int[]{
                R.drawable.qzone_list_file,
                R.drawable.qzone_list_friends,
                R.drawable.qzone_list_game,
                R.drawable.qzone_list_qianbao,
                R.drawable.qzone_list_saosao,
                R.drawable.qzone_list_setting,
};
    }

    private void initAdapter() {
        Qzone_Rec_Adapter qzone_rec_adapter = new Qzone_Rec_Adapter(mRootActivity, mList_title, mList_img);
        mRec_qzone.setLayoutManager(new LinearLayoutManager(mRootActivity));
        mRec_qzone.addItemDecoration(new Recycle_list_Decoration(mRootActivity,LinearLayout.VERTICAL));
        mRec_qzone.setAdapter(qzone_rec_adapter);
        qzone_rec_adapter.setOnMyitemClicck(new Qzone_Rec_Adapter.OnMyitemClicck() {
            @Override
            public void OnClick(View v, int position) {
                Toast.makeText(mRootActivity,"保留回调接口，方便修改",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        mRec_qzone = (RecyclerView) view.findViewById(R.id.Rec_qzone);
        RadioButton rbt_dongtai = (RadioButton) view.findViewById(R.id.rbt_dongtai);
        RadioButton rbt_fujing = (RadioButton) view.findViewById(R.id.rbt_fujing);
        RadioButton rbt_xingqu = (RadioButton) view.findViewById(R.id.rbt_xingqu);
        rbt_dongtai.setOnClickListener(this);
        rbt_fujing.setOnClickListener(this);
        rbt_xingqu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbt_dongtai:
                Toast.makeText(mRootActivity,"点击了好友动态",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbt_fujing:
                Toast.makeText(mRootActivity,"点击了附近的人",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbt_xingqu:
                Toast.makeText(mRootActivity,"点击了兴趣部落",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

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
import android.widget.ListView;
import android.widget.Toast;

import com.example.joker.copyqq.R;

import Adapters.Msg_Rec_Adapter;
import utils.Recycle_list_Decoration;

/**
 * Created by Joker on 2016/10/26.
 */

public class Msg_Fragment extends Fragment {

    private ListView mLv_msg;
    private String[] mlateMsg;
    private Activity mRootActivity;
    private RecyclerView mRec_msg;
    private String[] msg_name;
    private int[] mHeadimg;
    private String[] msg_information;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_msg, container, false);
        initData();
        initView(view);
        initAdapter();
        return view;

    }

    private void initData() {
        mHeadimg = new int[]{R.mipmap.tangwei,
                R.mipmap.tangwei2,
                R.mipmap.tangwei,
                R.mipmap.tangwei,
                R.mipmap.tangwei2,
                R.mipmap.tangwei,
                R.mipmap.tangwei2
        };
        msg_name = new String[]{"汤唯","TANGWEI","汤唯","Tangwei","汤唯","Tangwei","汤唯"};
        msg_information = new String[]{"好好学习,天天向上","天天向上","Good Good learn,Day day up","Day day up","beautiful","Day day up","tangweiwoshi nvsheng,beautiful"};
    }

    private void initView(View view) {
        mRec_msg = (RecyclerView) view.findViewById(R.id.Rec_msg);
    }

    private void initAdapter() {
        mRec_msg.setLayoutManager(new LinearLayoutManager(mRootActivity));
        Msg_Rec_Adapter msg_rec_adapter = new Msg_Rec_Adapter(mRootActivity, mHeadimg, msg_name, msg_information);
        mRec_msg.addItemDecoration(new Recycle_list_Decoration(mRootActivity, LinearLayout.VERTICAL));
        mRec_msg.setAdapter(msg_rec_adapter);
        msg_rec_adapter.setOnMyitemClicck(new Msg_Rec_Adapter.OnMyitemClicck() {
            @Override
            public void OnClick(View v, int position) {
                Toast.makeText(mRootActivity,"保留回调接口，方便修改",Toast.LENGTH_SHORT).show();
            }
        });
    }




}

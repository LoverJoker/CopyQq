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
import android.widget.Toast;

import com.example.joker.copyqq.R;

import Adapters.Link_man_Rec_Adapter;
import utils.Recycle_list_Decoration;

/**
 * Created by Joker on 2016/10/26.
 */

public class LinkMan_Fragment extends Fragment {

    private Activity mRootActivity;
    private RecyclerView mRec_linkMan;
    private String[] link_name ;
    private int[] mLink_Headimg;
    private String[] link_information;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_linkman, container, false);
        initView(view);
        initData();
        initAdapter();
        return view;
    }

    private void initData() {
        mLink_Headimg = new int[]{R.mipmap.tangwei,
                R.mipmap.tangwei2,
                R.mipmap.tangwei,
                R.mipmap.tangwei,
                R.mipmap.tangwei2,
                R.mipmap.tangwei,
                R.mipmap.tangwei2
        };
        link_name = new String[]{"汤唯","TANGWEI","汤唯","Tangwei","汤唯","Tangwei","汤唯"};
        link_information = new String[]{"好好学习,天天向上","天天向上","Good Good learn,Day day up","Day day up","beautiful","Day day up",
                "tangweiwoshi nvsheng,beautiful"};

    }

    private void initAdapter() {
        Link_man_Rec_Adapter link_man_rec_adapter = new Link_man_Rec_Adapter(mRootActivity, link_name,link_information,mLink_Headimg);
        mRec_linkMan.setLayoutManager(new LinearLayoutManager(mRootActivity));
        mRec_linkMan.addItemDecoration(new Recycle_list_Decoration(mRootActivity, LinearLayout.VERTICAL));
        mRec_linkMan.setAdapter(link_man_rec_adapter);
        link_man_rec_adapter.setOnMyitemClicck(new Link_man_Rec_Adapter.OnMyitemClicck() {
            @Override
            public void OnClick(View v, int position) {
                Toast.makeText(mRootActivity,"保留回调接口，方便修改",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        mRec_linkMan = (RecyclerView) view.findViewById(R.id.Rec_LinkMan);
        
    }
}

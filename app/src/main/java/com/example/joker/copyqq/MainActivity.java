package com.example.joker.copyqq;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

import Adapters.SlidingMenu_Rec_Adapter;
import Fragments.LinkMan_Fragment;
import Fragments.Msg_Fragment;
import Fragments.Qzone_Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends SlidingActivity implements View.OnClickListener , SlidingMenu_Rec_Adapter.OnMyitemClick {

    private FrameLayout mFl_main;
    private RadioButton mRbt_linkman;
    private RadioButton mRbt_msg;
    private RadioButton mRbt_qzone;
    private CircleImageView mCir_main_top;
    private SlidingMenu slidingMenu;
    private ImageView mIv_left_menu;
    private CircleImageView mCimg_sliding;
    private RecyclerView mRec_sliding;
    private String[] mSliding_title;
    private int[] mSliding_img;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.slding_menu);
        initSlidingMenu();
        initSlidingView();
        initView();
        initData();
        initAdapter();
        initFragments();
    }

    private void initData() {
        mSliding_title = new String[]{"相机","我的文件","最新消息","照片","我的文件"};
        mSliding_img = new int[]{R.mipmap.xiangji,R.mipmap.wodewenjian,R.mipmap.zuijxiaoxi,R.mipmap.zhaopian,R.mipmap.wodewenjian};
    }

    private void initAdapter() {
        mRec_sliding.setLayoutManager(new LinearLayoutManager(this));
        SlidingMenu_Rec_Adapter slidingMenu_rec_adapter = new SlidingMenu_Rec_Adapter(this, mSliding_title, mSliding_img);
        mRec_sliding.setAdapter(slidingMenu_rec_adapter);
        slidingMenu_rec_adapter.setOnMyitemClick(this);
    }

    private void initSlidingView() {
        mIv_left_menu = (ImageView) findViewById(R.id.iv_left_menu);
        Glide.with(this)
                .load(R.mipmap.tangwei5)
                .crossFade()
                .into(mIv_left_menu);
        mCimg_sliding = (CircleImageView) findViewById(R.id.cimg_sliding);
        Glide.with(this)
                .load(R.mipmap.tangwei6)
                .crossFade()
                .into(mCimg_sliding);

    }

    private void initSlidingMenu() {
        WindowManager wm = getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(width-800);
    }

    private void slidingMenutoogle() {
        slidingMenu.toggle();
    }

    private void initFragments() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fmt = fm.beginTransaction();
        fmt.replace(R.id.fl_main,new LinkMan_Fragment());
        fmt.commit();
        mRbt_linkman.setChecked(true);
    }

    private void initView() {
        mFl_main = (FrameLayout) findViewById(R.id.fl_main);
        mRbt_linkman = (RadioButton) findViewById(R.id.rbt_linkman);
        mRbt_msg = (RadioButton) findViewById(R.id.rbt_msg);
        mRbt_qzone = (RadioButton) findViewById(R.id.rbt_qzone);
        mCir_main_top = (CircleImageView) findViewById(R.id.cir_main_top);
        mRec_sliding = (RecyclerView) findViewById(R.id.Rec_Sliding);
        mRbt_linkman.setOnClickListener(this);
        mRbt_msg.setOnClickListener(this);
        mRbt_qzone.setOnClickListener(this);
        mCir_main_top.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbt_linkman:
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fmt = fm.beginTransaction();
                fmt.replace(R.id.fl_main,new LinkMan_Fragment());
                fmt.commit();
                break;
            case R.id.rbt_msg:
                FragmentManager fm1 = getFragmentManager();
                FragmentTransaction fmt1 = fm1.beginTransaction();
                fmt1.replace(R.id.fl_main,new Msg_Fragment());
                fmt1.commit();

                break;
            case R.id.rbt_qzone:
                FragmentManager fm2 = getFragmentManager();
                FragmentTransaction fmt2 = fm2.beginTransaction();
                fmt2.replace(R.id.fl_main,new Qzone_Fragment());
                fmt2.commit();
                break;
            case R.id.cir_main_top:
                slidingMenutoogle();
                break;
        }
    }


    //回调接口中点击的方法
    @Override
    public void OnClick(View view, int position) {
        slidingMenutoogle();
    }

}

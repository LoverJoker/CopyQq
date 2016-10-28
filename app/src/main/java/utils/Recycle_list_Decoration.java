package utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Joker on 2016/10/27.
 */

public class Recycle_list_Decoration extends RecyclerView.ItemDecoration {

    private int mOrientation = LinearLayout.VERTICAL ; //只显示竖屏幕
    private int mItem_size  = 2;
    private Context mContext;
    private Paint mPaint;

    public Recycle_list_Decoration(Context mContext,int mOrientation){
        this.mContext = mContext ;
        this.mOrientation = mOrientation ;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == LinearLayout.VERTICAL){
            //画纵向分割线
            drawVertical(c,parent);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin ;
            final int bottom = top + mItem_size ;
            c.drawRect(left,top,right,bottom,mPaint);
        }


    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == LinearLayoutManager.VERTICAL){
            outRect.set(0,0,0,mItem_size);
        }else {
            outRect.set(0,0,mItem_size,0);
        }
    }
}

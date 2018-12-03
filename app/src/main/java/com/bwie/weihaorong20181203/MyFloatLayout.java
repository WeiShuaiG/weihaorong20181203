package com.bwie.weihaorong20181203;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by W on 2018/12/3.
 */

public class MyFloatLayout extends LinearLayout {
    private int mSreenWidth;
    private int mSreenHeight;
    private String mColor;
    public MyFloatLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        mSreenWidth = metrics.widthPixels;
        mSreenHeight = metrics.heightPixels;
        setOrientation(VERTICAL);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.GroupView);
        if (typedArray!= null){
            mColor = (String) typedArray.getText(R.styleable.GroupView_textColor);
        }
    }
    public void removeAllChildView(){
        removeAllViews();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
    public void setData(ArrayList<String> data){
        LinearLayout linearLayout = getLin();
        for (int i = 0; i <data.size() ; i++) {
            final String tmp = data.get(i);
            int numWidth = 0;
            int childWidth = linearLayout.getChildCount();
            for (int j = 0; j <childWidth ; j++) {
                TextView tv = (TextView) linearLayout.getChildAt(j);
                LayoutParams params = (LayoutParams) tv.getLayoutParams();
                int leftMargin = params.leftMargin;
                tv.measure(getMeasuredWidth(),getMeasuredHeight());
                numWidth += tv.getMeasuredWidth() + leftMargin + tv.getPaddingLeft()+tv.getPaddingRight();

            }
            TextView dataText = getText();
            dataText.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),tmp,Toast.LENGTH_SHORT).show();
                }
            });
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            params.topMargin = 10;
            params.leftMargin = 15;
            dataText.setLayoutParams(params);
            dataText.setText(tmp);
            dataText.measure(getMeasuredWidth(),getMeasuredHeight());
            int dataTextWidth = dataText.getMeasuredWidth() + dataText.getPaddingRight()+dataText.getPaddingLeft();
            if (mSreenWidth>=numWidth + dataTextWidth){
                linearLayout.addView(dataText);
            }else {
                linearLayout = getLin();
                linearLayout.addView(dataText);
            }


        }
    }



    private LinearLayout getLin() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);

        this.addView(linearLayout);
        return linearLayout;

    }
    private TextView getText() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(20);
        textView.setTextColor(Color.parseColor(mColor));
        textView.setBackgroundResource(R.drawable.text_style);
        textView.setPadding(10,10,10,10);
        return textView;

    }
}

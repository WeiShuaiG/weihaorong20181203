package com.bwie.weihaorong20181203;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by W on 2018/12/3.
 */

public class MyXHView extends LinearLayout {
    private EditText mEditText;
    private TextView textView;
    public MyXHView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.header_view,this);
        mEditText = findViewById(R.id.Search_edit);
        textView = findViewById(R.id.Cannel_text);

    }
    public String getStr(){
        return mEditText.getText().toString();
    }
    public TextView getCannel(){
        return textView;
    }
}

package com.bwie.weihaorong20181203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.weihaorong20181203.db.MyDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] data = {"电动牙刷","豆豆鞋","肥皂","榴莲","雅诗兰黛","尤佳妮","沐浴露","沐浴露","沐浴露","沐浴露"};
    private MyFloatLayout myfloat_history;
    private MyFloatLayout myfloat_layout;
    private MyXHView xh;
    private MyDao dao;
    private ArrayList<String> history = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    private TextView mdelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new MyDao(this);
        history = dao.select();
        for (int i = 0; i <data.length ; i++) {
            list.add(data[i]);
        }
        mdelete = findViewById(R.id.delete_text);
        mdelete.setOnClickListener(this);
        xh = findViewById(R.id.header_view);
        xh.getCannel().setOnClickListener(this);
        myfloat_history = findViewById(R.id.myfloat_history);

        myfloat_layout = findViewById(R.id.folat_layout);
        myfloat_layout.setData(list);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Cannel_text:
                String name = xh.getStr().trim();
                dao.insertSqlit(xh.getStr().trim());
                myfloat_history.removeAllChildView();
                history.add(name);
                myfloat_history.setData(history);
                break;
            case R.id.delete_text:
                dao.delete();
                myfloat_history.removeAllChildView();
                history.clear();
                break;
        }
    }
}

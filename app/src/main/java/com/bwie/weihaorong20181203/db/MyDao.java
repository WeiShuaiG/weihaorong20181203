package com.bwie.weihaorong20181203.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by W on 2018/12/3.
 */

public class MyDao {
    private DBHelper helper;
    private SQLiteDatabase myData;
    private Context mContext;
    public MyDao(Context context){
        mContext = context;
        helper = new DBHelper(context);
        myData = helper.getWritableDatabase();

    }
    public void insertSqlit(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        myData.insert("liu",null,values);
        Toast.makeText(mContext,"插入成功",Toast.LENGTH_SHORT).show();
    }
    public ArrayList<String> select(){
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = myData.query("liu",null,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            list.add(name);
        }
        return  list;
    }
    public void delete(){
        myData.execSQL("delete from liu");
    }
}

package com.example.resturant_billing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context)
    {
        super(context,"Restaurant",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_query = "CREATE TABLE User(ID INTEGER PRIMARY KEY AUTOINCREMENT , Email VARCHAR(40) NOT NULL UNIQUE , Phone VARCHAR(10) NOT NULL , Password VARCHAR(30) NOT NULL , RESTAURANT VARCHAR(50) NOT NULL , OWNER VARCHAR(50) NOT NULL , GST VARCHAR(50) NOT NULL , ADDRESS TEXT NOT NULL)";
        sqLiteDatabase.execSQL(create_table_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean checkEmail(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM User WHERE Email = '"+email+"'";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean registerUserHelper(String email , String password , String contact , String gst , String owner , String address , String restaurant)
    {
        ContentValues content = new ContentValues();
        content.put("Email",email);
        content.put("Phone",contact);
        content.put("ADDRESS",address);
        content.put("GST",gst);
        content.put("OWNER",owner);
        content.put("RESTAURANT",restaurant);
        content.put("Password",password);
        SQLiteDatabase db = this.getWritableDatabase();
        long l = db.insert("User",null,content);
        if(l > 0 )
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }
    public boolean checkLogin(String email , String password){
        String query = "SELECT * FROM User WHERE Email = '"+email+"' AND Password = '"+password+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            return true ;
        }
        else
        {
            return false ;
        }
    }
}

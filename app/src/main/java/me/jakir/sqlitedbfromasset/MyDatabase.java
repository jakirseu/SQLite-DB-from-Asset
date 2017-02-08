package me.jakir.sqlitedbfromasset;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "hello.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "name";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);

        return res;

    }
}
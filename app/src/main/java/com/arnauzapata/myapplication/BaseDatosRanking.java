package com.arnauzapata.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import static com.arnauzapata.myapplication.MyDataBaseContract2.Table1.PASSWORD;
import static com.arnauzapata.myapplication.MyDataBaseContract2.Table1.TABLE_NAME;
import static com.arnauzapata.myapplication.MyDataBaseContract2.Table1.USERNAME;

/**
 * Created by usuari on 8/07/17.
 */

final class MyDataBaseContract2 {
    public MyDataBaseContract2(){}

    public class Table1 implements BaseColumns {
        public static final String TABLE_NAME = "RANKING";
        public static final String USERNAME = "USER";
        public static final String PASSWORD = "PUNTUATION";
    }

}

public class BaseDatosRanking extends SQLiteOpenHelper {
    private final String TAG = "BaseDatosRanking";

    public static final int DATABASE_VERSION_RANKING = 2;
    public static final String DATABASE_NAME_RANKING = "MyDataBaseRanking.db";




    static final String SQL_CREATE_TABLE = "create table "+ "Ranking"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USER  text UNIQUE,PUNTUATION text); ";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + MyDataBaseContract1.Table1.TABLE_NAME;


    private static BaseDatosRanking instance;
    private static SQLiteDatabase writable;
    private static SQLiteDatabase readable;


    //We will use this method instead the default constructor to get a reference.
    //With this we will use all the time the same reference.
    public static BaseDatosRanking getInstance(Context c){
        if(instance == null){
            instance = new BaseDatosRanking(c);
            if (writable == null) writable = instance.getWritableDatabase();
            if (readable == null) readable = instance.getReadableDatabase();
        }
        return instance;
    }

    //With this, all must use getInstance(Context) to use this class
    public BaseDatosRanking(Context context) {
        super(context, DATABASE_NAME_RANKING, null, DATABASE_VERSION_RANKING);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //We execute here the SQL sentence to create the DB
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public static long createRow(String user, String password) {
        ContentValues values = new ContentValues();
        values.put(USERNAME,user);
        values.put(PASSWORD,password);
        long newId = writable.insert(TABLE_NAME,null,values);
        return newId;
    }

    public static int updateRow(String user, String password) {
        ContentValues values = new ContentValues();
        values.put(USERNAME, user);
        values.put(PASSWORD,password);
        int rows_afected = readable.update(TABLE_NAME,    //Table name
                values,                                                             //New value for columns
                USERNAME + " LIKE ? ",                 //Selection args
                new String[] {user});                                                  //Selection values

        return rows_afected;
    }

    public int deleteRow(String s) {
        int afected = readable.delete(TABLE_NAME,         //Table name
                USERNAME + " LIKE ? ",                 //Selection args
                new String[] {s});                                                  //Selection values

        return afected;
    }

    public static String queryRow(String user) {
        Cursor c;
        c = readable.query(TABLE_NAME,    //Table name
                new String[] {PASSWORD},       //Columns we select
                USERNAME + " = ? ",    //Columns for the WHERE clause
                new String[] {user},                                   //Values for the WHERE clause
                null,                                               //Group By
                null,                                               //Having
                null);                                              //Sort

        String password = "NULL";
        if (c.moveToFirst()) {
            do {
                //We go here if the cursor is not empty
                String l = c.getString(c.getColumnIndex(PASSWORD));
                password= String.valueOf(l);
            } while (c.moveToNext());
        }
        c.close();
        return password;
    }

    @Override
    public synchronized void close() {
        super.close();
        //Always close the SQLiteDatabase
        writable.close();
        readable.close();
        Log.v(TAG,"close()");
    }
}

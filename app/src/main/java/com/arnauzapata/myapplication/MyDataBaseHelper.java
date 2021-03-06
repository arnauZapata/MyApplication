package com.arnauzapata.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

final class MyDataBaseContract1 {
    public MyDataBaseContract1(){}

    public static class Table1 implements BaseColumns {
        public static final String TABLE_NAME = "LOGIN";
        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String IMAGE = "IMAGE";
        public static final String DIRECCIO = "DIRECCIO";
    }

}



class MyDataBaseHelper1 extends SQLiteOpenHelper{

    /*
    * DEFINITION:
    * This class is the one which talks with the DB.
    */
    private final String TAG = "MyDataBaseHelper";

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "MYDataBase2.db";


    static final String SQL_CREATE_TABLE1 = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text UNIQUE,PASSWORD text,IMAGE text,DIRECCIO text); ";

    private static final String SQL_DELETE_TABLE1 =
            "DROP TABLE IF EXISTS " + MyDataBaseContract1.Table1.TABLE_NAME;



    private static MyDataBaseHelper1 instance;
    private static SQLiteDatabase writable;
    private static SQLiteDatabase readable;


    //We will use this method instead the default constructor to get a reference.
    //With this we will use all the time the same reference.
    public static MyDataBaseHelper1 getInstance(Context c){
        if(instance == null){
            instance = new MyDataBaseHelper1(c);
            if (writable == null) writable = instance.getWritableDatabase();
            if (readable == null) readable = instance.getReadableDatabase();
        }
        return instance;
    }

    //With this, all must use getInstance(Context) to use this class
    public MyDataBaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //We execute here the SQL sentence to create the DB
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE1);
        onCreate(sqLiteDatabase);
    }

    public long createRow(String user,String password) {
        ContentValues values = new ContentValues();
        values.put(MyDataBaseContract1.Table1.USERNAME,user);
        values.put(MyDataBaseContract1.Table1.PASSWORD,password);
        values.put(MyDataBaseContract1.Table1.IMAGE,"NULL");
        values.put(MyDataBaseContract1.Table1.DIRECCIO,"NULL");
        long newId = writable.insert(MyDataBaseContract1.Table1.TABLE_NAME,null,values);
        return newId;
    }

    public int updateRow(String user, String password) {
        ContentValues values = new ContentValues();
        values.put("USERNAME", user);
        values.put("PASSWORD",password);
        int rows_afected = readable.update(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                values,                                                             //New value for columns
                MyDataBaseContract1.Table1.USERNAME + " LIKE ? ",                 //Selection args
                new String[] {user});                                                  //Selection values

        return rows_afected;
    }

    public int deleteRow(String s) {
        int afected = readable.delete(MyDataBaseContract1.Table1.TABLE_NAME,         //Table name
                MyDataBaseContract1.Table1.USERNAME + " LIKE ? ",                 //Selection args
                new String[] {s});                                                  //Selection values

        return afected;
    }

    public String queryRow(String user) {
        Cursor c;
        c = readable.query(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                new String[] {MyDataBaseContract1.Table1.PASSWORD},       //Columns we select
                MyDataBaseContract1.Table1.USERNAME + " = ? ",    //Columns for the WHERE clause
                new String[] {user},                                   //Values for the WHERE clause
                null,                                               //Group By
                null,                                               //Having
                null);                                              //Sort

        String password = "NULL";
        if (c.moveToFirst()) {
            do {
                //We go here if the cursor is not empty
                String l = c.getString(c.getColumnIndex(MyDataBaseContract1.Table1.PASSWORD));
                 password= String.valueOf(l);
            } while (c.moveToNext());
        }
        c.close();
        Log.v(TAG,password);
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

    public void setImage(String user, String image) {
        ContentValues values = new ContentValues();
        values.put(MyDataBaseContract1.Table1.USERNAME,user);
        values.put(MyDataBaseContract1.Table1.PASSWORD,queryRow(user));
        values.put(MyDataBaseContract1.Table1.IMAGE,image);
        readable.update(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                values,                                                             //New value for columns
                MyDataBaseContract1.Table1.USERNAME + " LIKE ? ",                 //Selection args
                new String[] {user});
    }

    public String getImage(String user) {
        Cursor c;
        c = readable.query(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                new String[] {MyDataBaseContract1.Table1.IMAGE},       //Columns we select
                MyDataBaseContract1.Table1.USERNAME + " = ? ",    //Columns for the WHERE clause
                new String[] {user},                                   //Values for the WHERE clause
                null,                                               //Group By
                null,                                               //Having
                null);                                              //Sort

        String image = "NULL";
        if (c.moveToFirst()) {
            do {
                //We go here if the cursor is not empty
                String l = c.getString(c.getColumnIndex(MyDataBaseContract1.Table1.IMAGE));
                image= String.valueOf(l);
            } while (c.moveToNext());
        }
        c.close();
        Log.v(TAG,image);
        return image;
    }

    public String getDireccion(String user) {
        Cursor c;
        c = readable.query(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                new String[] {MyDataBaseContract1.Table1.DIRECCIO},       //Columns we select
                MyDataBaseContract1.Table1.USERNAME + " = ? ",    //Columns for the WHERE clause
                new String[] {user},                                   //Values for the WHERE clause
                null,                                               //Group By
                null,                                               //Having
                null);                                              //Sort
        String direccion = "NULL";
        if (c.moveToFirst()) {
            do {
                //We go here if the cursor is not empty
                String l = c.getString(c.getColumnIndex(MyDataBaseContract1.Table1.DIRECCIO));
                direccion= String.valueOf(l);
            } while (c.moveToNext());
        }
        c.close();
        Log.v(TAG,direccion);
        return direccion;
    }

    public void setDireccio(String user,String direccio) {
        ContentValues values = new ContentValues();
        values.put("USERNAME", user);
        values.put("DIRECCIO",direccio);
        readable.update(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                values,                                                             //New value for columns
                MyDataBaseContract1.Table1.USERNAME + " LIKE ? ",                 //Selection args
                new String[] {user});                                                  //Selection values


    }
}

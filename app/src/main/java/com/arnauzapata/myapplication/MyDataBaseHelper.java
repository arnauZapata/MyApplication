package com.arnauzapata.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.provider.BaseColumns;

final class MyDataBaseContract1 {
    public MyDataBaseContract1(){}

    public static class Table1 implements BaseColumns {
        public static final String TABLE_NAME = "tablename";
        public static final String COLUMN_TEXT = "text";
    }

}

class MyDataBaseHelper1 extends SQLiteOpenHelper{

    /*
    * DEFINITION:
    * This class is the one which talks with the DB.
    */
    private final String TAG = "MyDataBaseHelper";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyDataBase.db";


    private static final String SQL_CREATE_TABLE1 =
            "CREATE TABLE " + MyDataBaseContract1.Table1.TABLE_NAME + " (" +
                    MyDataBaseContract1.Table1._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    MyDataBaseContract1.Table1.COLUMN_TEXT + " TEXT)";

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
        //This method will be executed when the system detects that DATABASE_VERSION has been upgraded
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE1);
        onCreate(sqLiteDatabase);
    }

    public long createRow(String user,String password) {
        ContentValues values = new ContentValues();
        values.put(MyDataBaseContract1.Table1.COLUMN_TEXT,user);
        long newId = writable.insert(MyDataBaseContract1.Table1.TABLE_NAME,null,values);
        return newId;
    }

    public int updateRow(String s) {
        ContentValues values = new ContentValues();
        values.put(MyDataBaseContract1.Table1.COLUMN_TEXT, s.charAt(0)+s);
        int rows_afected = readable.update(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                values,                                                             //New value for columns
                MyDataBaseContract1.Table1.COLUMN_TEXT + " LIKE ? ",                 //Selection args
                new String[] {s});                                                  //Selection values

        return rows_afected;
    }

    public int deleteRow(String s) {
        int afected = readable.delete(MyDataBaseContract1.Table1.TABLE_NAME,         //Table name
                MyDataBaseContract1.Table1.COLUMN_TEXT + " LIKE ? ",                 //Selection args
                new String[] {s});                                                  //Selection values

        return afected;
    }

    public String queryRow(String user,String password) {
        Cursor c;
        c = readable.query(MyDataBaseContract1.Table1.TABLE_NAME,    //Table name
                new String[] {MyDataBaseContract1.Table1._ID},       //Columns we select
                MyDataBaseContract1.Table1.COLUMN_TEXT + " = ? ",    //Columns for the WHERE clause
                new String[] {user},                                   //Values for the WHERE clause
                null,                                               //Group By
                null,                                               //Having
                null);                                              //Sort

        String returnValue = "Not found";

        if (c.moveToFirst()) {
            do {
                //We go here if the cursor is not empty
                long l = c.getLong(c.getColumnIndex(MyDataBaseContract1.Table1._ID));
                returnValue = String.valueOf(l);
            } while (c.moveToNext());
        }

        //Always close the cursor after you finished using it
        c.close();

        return returnValue;
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
